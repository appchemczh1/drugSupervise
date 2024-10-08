package org.jeecg.modules.demo.dzzz.util;

import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.Getter;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.jeecg.common.system.vo.DictModel;
import org.jeecg.common.util.DecimalFormatUtils;
import org.jeecg.common.util.SpringContextUtils;
import org.jeecg.common.util.StringUtils;
import org.jeecg.common.util.UUIDGenerator;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.demo.dzzz.attachinfo.entity.Attachinfo;
import org.jeecg.modules.demo.dzzz.attachinfo.service.IAttachinfoService;
import org.jeecg.modules.demo.dzzz.certInfoOperation.entity.CertInfoOperationDetail;
import org.jeecg.modules.demo.dzzz.certInfoOperation.entity.CertInfoOperationRecord;
import org.jeecg.modules.demo.dzzz.certinfo.entity.ACertInfo;
import org.jeecg.modules.demo.dzzz.certinfo.entity.ACertInfoIsType;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertInfo;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertInfoIsType;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertSubTable;
import org.jeecg.modules.demo.dzzz.certinfo.mapper.CertHandleMapper;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertInfoService;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertSubTableService;
import org.jeecg.modules.demo.dzzz.certmatadataversion.entity.CertMetadata;
import org.jeecg.modules.demo.dzzz.certmode.entity.CertMode;
import org.jeecg.modules.demo.dzzz.certmode.service.ICertModeService;
import org.jeecg.modules.demo.dzzz.certtype.entity.CertType;
import org.jeecg.modules.demo.dzzz.certtype.service.ICertTypeService;
import org.jeecg.modules.demo.dzzz.dataExchange.exception.YwException;
import org.jeecg.modules.demo.dzzz.dataExchange.util.YwUtil;
import org.jeecg.modules.demo.dzzz.sczz.ZsDto;
import org.jeecg.modules.demo.dzzz.wgz.entity.ZsYwxxb;
import org.jeecg.modules.system.service.ISysDictService;
import org.springframework.core.env.Environment;
import org.springframework.util.ReflectionUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * <p>Created by Raofeicheng on 2024/8/19.</p>
 * @author Raofeicheng
 * @version 1.0
 */
public class CertUtils {

	public static List<CertInfoOperationDetail> diff(Object source, Object target, String certTypeId, Map<String, List<CertSubTable>> subTable,
													 List<String> diffList, CertInfoOperationRecord record) {
		CertType certType = getCertTypeService().getById(certTypeId);
		if (null == certType) throw new YwException("证书类型不存在");
		List<CertInfoOperationDetail> res = new ArrayList<>();
		String format = "fieldName由【oldValue】变更为【newValue】";
		String dateFormat = "yyyy-MM-dd HH:mm:ss", numberFormat = "0.##########";
		List<CertMetadata> metadataList = getCertInfoService().queryCertMetadateById(certTypeId, "1");
		for (CertMetadata metadata : metadataList) {
			String name = getFieldName(metadata),
				oldValue = StringUtils.trimToEmpty(BeanUtils.getPropertyStrQuietly(source, name, dateFormat, numberFormat)),
				newValue = StringUtils.trimToEmpty(BeanUtils.getPropertyStrQuietly(target, name, dateFormat, numberFormat));
			if (StringUtils.isBlank(name) || StringUtils.equals(oldValue, newValue)) continue;
			diffList.add(format.replace("fieldName", StringUtils.defaultIfBlank(metadata.getLm(), name))
				.replace("oldValue", oldValue).replace("newValue", newValue));
			CertInfoOperationDetail detail = new CertInfoOperationDetail();
			TableName tableName = source.getClass().getAnnotation(TableName.class);
			if (null != tableName) detail.setCzbm(tableName.value());
			detail.setBgzdmc(name);
			detail.setBgzdms(StringUtils.defaultIfBlank(metadata.getLm(), name));
			detail.setCzsjid(record.getId());
			detail.setBgr(record.getCzrxm());
			detail.setBgyy(record.getBgyy());
			detail.setCzsj(new Date());
			detail.setDataFlg("1");
			detail.setZsczjl(record.getId());
			detail.setZsid(record.getZsid());
			detail.setZdlszt(oldValue);
			detail.setZdxz(newValue);
			res.add(detail);
		}
		String sourceId = BeanUtils.getPropertyStrQuietly(source, "id"),
			targetId = BeanUtils.getPropertyStrQuietly(target, "id"),
			zt = BeanUtils.getPropertyStrQuietly(target, "zt");
		for (CertSubTableEnum em : CertSubTableEnum.byAbbrArray(StringUtils.trimToEmpty(certType.getZszb()).split("[,]+"))) {
			QueryWrapper<CertSubTable> query = new QueryWrapper<>();
			query.eq("XZSPID", sourceId);
			Map<String, CertSubTable> sourceMap = getCertSubTableService().list(em, zt, query)
				.stream().collect(Collectors.toMap(t -> t.getString("id"), Function.identity()));
			List<CertSubTable> targetList = subTable.get(em.abbr);
			if (null == targetList) targetList = new ArrayList<>();
			String sortColumn = oConvertUtils.camelName(em.getSortColumn());
			StringBuilder sb = new StringBuilder();
			int add = 0, edit = 0, sort = 0;
			for (CertSubTable targetItem : targetList) {
				sort++;
				if (StringUtils.isBlank(targetItem.getString("id")))
					targetItem.put("id", UUIDGenerator.generate());
				if (StringUtils.isNotBlank(sortColumn)) targetItem.put(sortColumn, sort);
				targetItem.put("xzspid", targetId);
				targetItem.put("zsid", BeanUtils.getPropertyStrQuietly(source, "zsid"));
				CertSubTable sourceItem = sourceMap.get(targetItem.getString("id"));
				if (null == sourceItem) {
					add++;
					continue;
				}
				int changeNum = 0;
				for (CertMetadata metadata : CollectionUtils.emptyIfNull(em.getMetadata())) {
					Class<?> typeClass = null != sourceItem.get(metadata.getLbs()) ? sourceItem.get(metadata.getLbs()).getClass() : null;
					String name = metadata.getLbs(),
						oldValue = StringUtils.trimToEmpty(BeanUtils.getPropertyStrQuietly(sourceItem, name, dateFormat, numberFormat)),
						newValue = StringUtils.trimToEmpty(MapUtils.getString(targetItem, name));
					if (null != typeClass && StringUtils.isNotBlank(newValue)) {
						if (Date.class.isAssignableFrom(typeClass)) newValue = DateFormatUtils.format(DateUtils.parseDate(newValue), dateFormat);
						if (Number.class.isAssignableFrom(typeClass)) newValue = DecimalFormatUtils.format(NumberUtils.toDouble(newValue, 0), numberFormat);
					}
					if (StringUtils.isBlank(name) || StringUtils.equals(oldValue, newValue)) continue;
					//后期可以在这里添加子表变化字段比对记录
					changeNum++;
				}
				if (0 < changeNum) edit++;
				sourceMap.remove(targetItem.getString("id"));
			}
			if (0 < add) sb.append(0 < sb.length() ? "，" : "").append("新增").append(add).append("条数据");
			if (0 < edit) sb.append(0 < sb.length() ? "，" : "").append("修改").append(edit).append("条数据");
			if (0 < sourceMap.size()) sb.append(0 < sb.length() ? "，" : "").append("删除").append(sourceMap.size()).append("条数据");
			if (0 < sb.length()) {
				sb.insert(0, StringUtils.trimToEmpty(em.getTitle()) + "子表：");
				diffList.add(sb.toString());
			}
		}
		return res;
	}

	public static List<CertInfoOperationRecord> diff(List<CertInfoOperationRecord> source, List<CertInfoOperationRecord> target,
													 List<String> diffList, CertInfoOperationRecord record) {
		record.setBgcs((source.size() + 1) + "");
		List<CertInfoOperationRecord> res = new ArrayList<>();
		Map<String, CertInfoOperationRecord> sourceMap = source.stream().collect(Collectors.toMap(CertInfoOperationRecord::getId, Function.identity()));
		Map<String, String> bglxMap = SpringContextUtils.getBean(ISysDictService.class).queryDictItemsByCode("changetype")
			.stream().collect(Collectors.toMap(DictModel::getValue, DictModel::getLabel));
		String dateFormat = "yyyy-MM-dd HH:mm:ss";
		for (CertInfoOperationRecord targetItem : CollectionUtils.emptyIfNull(target)) {
			CertInfoOperationRecord sourceItem = sourceMap.get(targetItem.getId());
			targetItem.setId("wh-" + targetItem.getId());
			targetItem.setCreateBy(null);
			targetItem.setCreateTime(null);
			targetItem.setZsid(record.getZsid());
			targetItem.setGzstutas("0");
			if (null == sourceItem) continue;
			StringBuilder sb = new StringBuilder();
			String oldValue, newValue;
			if (!StringUtils.equals(sourceItem.getBglx(), targetItem.getBglx())) {
				oldValue = StringUtils.defaultIfBlank(bglxMap.get(sourceItem.getBglx()), sourceItem.getBglx());
				newValue = StringUtils.defaultIfBlank(bglxMap.get(targetItem.getBglx()), targetItem.getBglx());
				sb.append(0 < sb.length() ? "，" : "").append("业务类型由【").append(oldValue).append("】变更为【").append(newValue).append("】");
			}
			oldValue = DateFormatUtils.format(sourceItem.getCzsj(), dateFormat);
			newValue = DateFormatUtils.format(targetItem.getCzsj(), dateFormat);
			if (!StringUtils.equals(oldValue, newValue)) {
				sb.append(0 < sb.length() ? "，" : "").append("操作时间由【").append(oldValue).append("】变更为【").append(newValue).append("】");
			}
			oldValue = StringUtils.trimToEmpty(sourceItem.getBgnr());
			newValue = StringUtils.trimToEmpty(targetItem.getBgnr());
			if (!StringUtils.equals(oldValue, newValue)) {
				sb.append(0 < sb.length() ? "，" : "").append("变更内容由【").append(oldValue).append("】变更为【").append(newValue).append("】");
			}
			oldValue = StringUtils.trimToEmpty(sourceItem.getBgyy());
			newValue = StringUtils.trimToEmpty(targetItem.getBgyy());
			if (!StringUtils.equals(oldValue, newValue)) {
				sb.append(0 < sb.length() ? "，" : "").append("变更原因由【").append(oldValue).append("】变更为【").append(newValue).append("】");
			}
			if (0 < sb.length()) {
				sb.insert(0, "第" + targetItem.getBgcs() + "次操作记录的");
				diffList.add(sb.toString());
				res.add(targetItem);
			}
		}
		return res;
	}

	public static String getFieldName(CertMetadata metadata) {
		String lbs = StringUtils.trimToEmpty(metadata.getLbs()),
			yssx = StringUtils.trimToEmpty(metadata.getYssx());
		if (StringUtils.isNotBlank(lbs) && !StringUtils.equalsIgnoreCase(lbs, yssx)) {
			return lbs;
		} else if ("cp".equalsIgnoreCase(yssx)) {
			return "chanping";
		} else if ("gg".equalsIgnoreCase(yssx)) {
			return "guige";
		} else if ("cs".equalsIgnoreCase(yssx)) {
			return "chaosong";
		} else {
			return yssx.toLowerCase();
		}
	}

	public static void initSubTable(ZsDto dto, String zsid, String xzspId, String zt, CertType certType) {
		String zszb = StringUtils.trimToEmpty(null != certType ? certType.getZszb() : "");
		dto.setSubMap(getSubTable(xzspId, zt, zszb.split("[,]+")));
	}

	public static Map<String, List<CertSubTable>> getSubTable(String xzspId, String zt, String... subKey) {
		Map<String, List<CertSubTable>> subMap = new HashMap<>();
		for (CertSubTableEnum em : CertSubTableEnum.byAbbrArray(subKey)) {
			QueryWrapper<CertSubTable> query = new QueryWrapper<>();
			query.eq("XZSPID", xzspId);
			if (StringUtils.isNotBlank(em.getOrderBy()))
				query.orderByAsc(em.getOrderBy());
			subMap.put(em.getAbbr(), getCertSubTableService().list(em, zt, query));
		}
		return subMap;
	}

	public static void copySubTable(CertInfo certInfo, String orgId) {
		if (null == certInfo) return;
		boolean isChange = !StringUtils.equalsIgnoreCase(certInfo.getId(), orgId);
		List<String> subTableNames = getSubTableNameList(certInfo.getLocalZszb());
		for (String tableName : subTableNames) {
			//id变化时需要把所有有效子表移到历史表，反之只需要移走非本id的子表记录
			getCertHandleMapper().copyToHistory(tableName, certInfo.getZsid(), isChange ? null : orgId);
			//删除非本id子表记录，反之删除
			getCertHandleMapper().deleteByZsidAndXzspId(tableName, certInfo.getZsid(), orgId);
			//id变化时修改id值
			getCertHandleMapper().updateXzspId(tableName, certInfo.getZsid(), orgId, certInfo.getId());
		}
	}

	public static List<String> getSubTableNameList(String zszb) {
		zszb = StringUtils.wrap(StringUtils.trimToEmpty(zszb), ",");
		List<String> res = new ArrayList<>();
		for (CertSubTableEnum item : CertSubTableEnum.values()) {
			if (!StringUtils.contains(zszb, StringUtils.wrap(item.getAbbr(), ","))) continue;
			res.add(item.getTableName());
		}
		return res;
	}

	@SuppressWarnings({"rawtype", "unchecked"})
	public static <T> QueryWrapper<T> cloneQuery(QueryWrapper<?> query, Class<T> clazz) {
		QueryWrapper<T> res;
		if (null == query) res = new QueryWrapper<>();
		else res = (QueryWrapper<T>) query.clone();
		return res;
	}

	public static <R extends ACertInfoIsType, T extends ACertInfo> List<R> addAttachInfo(List<T> data, String source, Class<R> resultClass) {
		return addAttachInfo(data, source, resultClass, false);
	}

	public static <R extends ACertInfoIsType, T extends ACertInfo> List<R> addAttachInfo(List<T> data, String source, Class<R> resultClass,
																						 boolean containsPath) {
		boolean isGs = "GS".equals(source),  //公式平台
			isWgz = "WGZ".equals(source),    //未盖章
			isYgz = "YGZ".equals(source),    //已盖章
			isQyd = "QYD".equals(source);    //企业端
		Map<String, CertType> certTypeCache = new HashMap<>();
		Map<String, List<CertMode>> certModeCache = new HashMap<>();
		Map<String, List<Map<String, Object>>> attachTypeCache = new HashMap<>();
		List<String> ids = new ArrayList<>(),
			typeIds = new ArrayList<>();
		for (T item : data) {
			if (StringUtils.isNotBlank(item.getId())) ids.add(item.getId());
			if (StringUtils.isNotBlank(item.getCertTypeId())) typeIds.add(item.getCertTypeId());
		}
		if (CollectionUtils.isNotEmpty(typeIds)) {
			certTypeCache = getCertTypeService().list(new LambdaQueryWrapper<CertType>().in(CertType::getId, typeIds))
				.stream().collect(Collectors.toMap(CertType::getId, t -> t));
			LambdaQueryWrapper<CertMode> query = new LambdaQueryWrapper<>();
			query.in(CertMode::getCerttypeid, typeIds);
			query.orderByAsc(CertMode::getCerttypeid);
			query.orderByAsc(CertMode::getOrderNum);
			for (CertMode item : getCertModeService().list(query)) {
				if (!certModeCache.containsKey(item.getCerttypeid()))
					certModeCache.put(item.getCerttypeid(), new ArrayList<>());
				certModeCache.get(item.getCerttypeid()).add(item);
			}
		}
		if (CollectionUtils.isNotEmpty(ids)) {
			QueryWrapper<Attachinfo> query = new QueryWrapper<>();
			query.in("ZSID", ids).eq("STATUS", "1").eq("ISGZ", isWgz ? "0" : "1");
			query.select("zsid,TYPE AS \"type\",MAX(MODE_URL)filePath,MAX(USER_NAME)userName,MAX(CREATE_TIME)createTime");
			query.groupBy("zsid,type").orderByAsc("zsid,type");
			for (Map<String, Object> item : getAttachInfoService().listMaps(query)) {
				String id = MapUtils.getString(item, "zsid");
				if (!attachTypeCache.containsKey(id)) attachTypeCache.put(id, new ArrayList<>());
				attachTypeCache.get(id).add(item);
			}
		}
		List<R> res = new ArrayList<>();
		for (T item : data) {
			R target;
			try {
				target = resultClass.newInstance();
			} catch (Throwable e) {
				continue;
			}
			BeanUtils.copyProperties(item, target);
			res.add(target);
			if ((isYgz || isQyd) && target instanceof CertInfoIsType) {
				CertInfoIsType bean = (CertInfoIsType) target;
				CertType certType = certTypeCache.get(item.getCertTypeId());
				if (null != certType) bean.setZslxName(certType.getCerttypename());
				if (StringUtils.isNotBlank(bean.getYxzt())) bean.setYxztName(YwUtil.zsYxZtConvert(bean.getYxzt()));
			}
			if (certModeCache.containsKey(item.getCertTypeId()) && attachTypeCache.containsKey(item.getId())) {
				List<String> array = new ArrayList<>();
				for (CertMode certMode : certModeCache.get(item.getCertTypeId())) {
					for (Map<String, Object> map : attachTypeCache.get(item.getId())) {
						String type = MapUtils.getString(map, "type");
						if ((!isGs || "1".equals(certMode.getIsgs())) && (!isQyd || "1".equals(certMode.getIsqy()))
							&& StringUtils.startsWith(type, certMode.getTemplateName())) {
							if (containsPath) {
								array.add(StringUtils.join(Arrays.asList(type,
									MapUtils.getString(map, "filePath"),
									MapUtils.getString(map, "userName"),
									DateFormatUtils.format(convertType(map.get("createTime"), Date.class), "yyyy-MM-dd HH:mm:ss")
								), ";"));
							} else array.add(type);
						}
					}
				}
				target.setIsType(StringUtils.join(array, ","));
			}
		}
		return res;
	}

	public static ZsYwxxb setDataByMetadata(JSONObject json, ZsYwxxb target, List<CertMetadata> certMetadata, String... ignoreProperties) {
		if (null == target) target = new ZsYwxxb();
		for (CertMetadata meta : certMetadata) {
			String lbs = StringUtils.trimToEmpty(meta.getLbs()), yssx = StringUtils.trimToEmpty(meta.getYssx()), value;
			if (StringUtils.isNotBlank(lbs) && !StringUtils.equalsIgnoreCase(lbs, yssx)) {
				value = json.getString(json.containsKey(yssx) ? yssx : yssx.toLowerCase());
			} else {
				value = json.getString(yssx.toLowerCase());
				if ("cp".equalsIgnoreCase(yssx)) lbs = "chanping";
				else if ("gg".equalsIgnoreCase(yssx)) lbs = "guige";
				else if ("cs".equalsIgnoreCase(yssx)) lbs = "chaosong";
				else lbs = yssx.toLowerCase();
			}
			if ("1".equals(meta.getIsbt()) && StringUtils.isBlank(value))
				throw new YwException("属性[ " + yssx + " ]不能为空");
			if (null == value || ArrayUtils.contains(ignoreProperties, lbs)) continue;
			PropertyDescriptor pd = BeanUtils.getPropertyDescriptor(target, lbs);
			if (null == pd) throw new YwException("属性[ " + yssx + " ]不存在");
			if (null != pd.getWriteMethod()) {
				ReflectionUtils.makeAccessible(pd.getWriteMethod());
				ReflectionUtils.invokeMethod(pd.getWriteMethod(), target, convertType(value, pd.getPropertyType()));
			} else {
				Field field = ReflectionUtils.findField(target.getClass(), lbs);
				if (null == field) throw new YwException("属性[ " + yssx + " ]不存在");
				try {
					ReflectionUtils.makeAccessible(field);
					ReflectionUtils.setField(field, target, convertType(value, pd.getPropertyType()));
				} catch (Throwable e) {
					throw new YwException(e.getMessage(), e);
				}
			}
		}
		return target;
	}

	public static CertInfo initSyncState(CertInfo certInfo) {
		if (null == certInfo) return null;
		certInfo.setSjtbXzsp("0");
		certInfo.setSjtbGj("0");
		certInfo.setSjtbSscj("0");
		certInfo.setV006("0");
		certInfo.setSjzx("0");
		certInfo.setV007("0");
		certInfo.setDsjnlpt("0");
		return certInfo;
	}

	public static <T> T convertType(Object source, Class<T> targetClass) {
		if (null == source) return null;
		if (source instanceof Date) return convertType((Date) source, targetClass);
		if (source instanceof String) return convertType((String) source, targetClass);
		return null;
	}

	@SuppressWarnings({"unchecked"})
	public static <T> T convertType(Date source, Class<T> targetClass) {
		if (null == source) return null;
		if (targetClass.isAssignableFrom(Date.class)) return (T) source;
		else if (targetClass.isAssignableFrom(Timestamp.class)) return (T) new Timestamp(source.getTime());
		else if (targetClass.isAssignableFrom(Integer.class)) return (T) toInteger(source);
		else if (targetClass.isAssignableFrom(String.class)) return (T) DateFormatUtils.format(source, "yyyy-MM-dd HH:mm:ss");
		return null;
	}

	@SuppressWarnings({"unchecked"})
	public static <T> T convertType(String source, Class<T> targetClass) {
		if (null == source) return null;
		if (targetClass.isAssignableFrom(Date.class)) return (T) DateUtils.parseDate(source);
		else if (targetClass.isAssignableFrom(Integer.class)) return (T) toInteger(source);
		else if (targetClass.isAssignableFrom(String.class)) return (T) source;
		return null;
	}

	public static Integer toInteger(Object obj) {
		return toInteger(obj, null);
	}

	public static Integer toInteger(Object obj, Integer defaultVal) {
		if (null == obj) return defaultVal;
		else if (obj instanceof Number) return ((Number) obj).intValue();
		else if (obj instanceof Date) return (int) ((Date) obj).getTime();
		else {
			try {
				return Integer.parseInt(obj + "");
			} catch (Throwable e) {
				return defaultVal;
			}
		}
	}

	public static CertHandleMapper getCertHandleMapper() {
		if (null == certHandleMapper) certHandleMapper = SpringContextUtils.getBean(CertHandleMapper.class);
		return certHandleMapper;
	}

	public static ICertSubTableService getCertSubTableService() {
		if (null == certSubTableService) certSubTableService = SpringContextUtils.getBean(ICertSubTableService.class);
		return certSubTableService;
	}

	public static IAttachinfoService getAttachInfoService() {
		if (null == attachInfoService) attachInfoService = SpringContextUtils.getBean(IAttachinfoService.class);
		return attachInfoService;
	}

	public static ICertTypeService getCertTypeService() {
		if (null == certTypeService) certTypeService = SpringContextUtils.getBean(ICertTypeService.class);
		return certTypeService;
	}

	public static ICertModeService getCertModeService() {
		if (null == certModeService) certModeService = SpringContextUtils.getBean(ICertModeService.class);
		return certModeService;
	}

	public static ICertInfoService getCertInfoService() {
		if (null == certInfoService) certInfoService = SpringContextUtils.getBean(ICertInfoService.class);
		return certInfoService;
	}

	private static CertHandleMapper certHandleMapper;
	private static ICertSubTableService certSubTableService;
	private static IAttachinfoService attachInfoService;
	private static ICertTypeService certTypeService;
	private static ICertModeService certModeService;
	private static ICertInfoService certInfoService;

	@Getter
	public enum CertSubTableEnum {

		/*药品生产许可证-自产*/
		YPSC_ZC("zc", "自产", "T_JC_ZS_YPSCXK_ZC", "TO_NUMBER(NUM)", "ID", "PROTYPE", "WORKSHOP",
			"PREPARATION", "PRODUCTIONSCOPE", "PRODUCTIONSCOPEF", "ZT", "ADDRDETAIL", "THROUGHPUT", "CALCULATIONUNIT",
			"PREPARATIONNUMBER", "GETGMPCERTIFICATE", "GMPRZSCOPE", "BGQID", "ZSID", "CREATETIME", "GZRQ", "PRODUCTIONSCOPECODE",
			"XZSPID", "GGFLAG", "ISGMP", "SFSC", "NUM"),
		/*药品生产许可证-委托*/
		YPSC_WT("wt", "委托", "T_JC_ZS_YPSCXK_WT", "TO_NUMBER(NUM)", "ID", "PROTYPE", "REFCOMPADDR", "WORKSHOP",
			"REFCOMPNAME", "REFCOMPID", "PREPARATION", "DRUGTYPE", "DRUGNAME", "CORDRUGID", "REGNUMB", "DRUGDOSE", "SPEC", "ENTRUSTVALIDATE",
			"PRODUCTIONSCOPE", "PRODUCTIONSCOPEF", "THROUGHPUT", "CALCULATIONUNIT", "PREPARATIONNUMBER", "GETGMPCERTIFICATE", "GMPRZSCOPE",
			"ZT", "BGQID", "ZSID", "CREATETIME", "GZRQ", "PRODUCTIONSCOPECODE", "REGNUMBVALIDATE", "XZSPID", "GGFLAG", "ISGMP", "SFSC", "NUM"),
		/*药品生产许可证-受托*/
		YPSC_ST("st", "受托", "T_JC_ZS_YPSCXK_ST", "TO_NUMBER(NUM)", "ID", "PROTYPE", "REFCOMPADDR", "WORKSHOP",
			"REFCOMPNAME", "REFCOMPID", "PREPARATION", "DRUGTYPE", "DRUGNAME", "CORDRUGID", "REGNUMB", "DRUGDOSE", "SPEC", "ENTRUSTVALIDATE",
			"PRODUCTIONSCOPE", "PRODUCTIONSCOPEF", "THROUGHPUT", "CALCULATIONUNIT", "PREPARATIONNUMBER", "GETGMPCERTIFICATE", "GMPRZSCOPE",
			"ZT", "BGQID", "ADDRDETAIL", "ZSID", "CREATETIME", "GZRQ", "PRODUCTIONSCOPECODE", "REGNUMBVALIDATE", "XZSPID", "GGFLAG", "ISGMP", "SFSC", "NUM"),
		/*麻醉药品和精神药品定点生产批件*/
		MJYP_DDPJ("mz", "", "T_JC_ZS_MZYPHJSYPDDSCPJ_ZB", "NUM", "ID", "ZSID", "NUM", "YPMC", "JY", "GG", "GZLB", "PZWH", "ZT", "XZSPID"),
		/*药品出口准许证*/
		YPCK("ypck", "", "T_JC_ZS_YPCKZXZ_ZB", "NUM", "ID", "ZSID", "NUM", "CKYWMC", "CKYWYWMC", "SPBM", "JX", "CKYWBZ", "CKYWGZ", "CKYWSL", "ZT", "XZSPID"),
		/*药品出口销售证明*/
		YPCK_XSZM("ypxs", "", "T_JC_ZS_YPCKXSZM_ZB", "TO_NUMBER(NUM)", "ID", "ZSID", "NUM", "JKGJZW", "JKGJYW", "CKSL", "LX", "ZT", "XZSPID"),
		/*出口欧盟原料*/
		YPCK_OMYLY("om", "", "T_JC_ZS_CKOMYLY_ZB", "NUM", "ID", "ZSID", "NUM", "YPTYMCZW", "YPTYMCYW", "JGFFZW",
			"JGFFYW", "ZGYPPZWHZW", "ZGYPPZWHYW", "SFTGRZ", "ZT", "XZSPID"),
		/*第一类医疗器械生产备案品种*/
		QX_DYL("dyl", "", "T_JC_ZS_DYLYLQXSCBAPZ_ZB", "NUM", "ID", "ZSID", "ZCZH", "CPLB_DM", "SFWTSC",
			"ZCBARMC", "ZCBARDZ", "SHXYDM", "WTQX", "BZ", "CPMC", "NUM", "ZT", "XZSPID"),
		/*第二三类医疗器械委托备案子表*/
		QX_QXBA23("qxba23", "", "T_JC_ZS_YLQXWTSCBA_ZB", "PX", "ID", "ZSID", "CPMC", "CPZCH", "WTRQ", "PX", "ZT", "XZSPID"),
		/*第二三类医疗机械生产子表*/
		QX_XKZ23("qxxkz", "", "T_JC_ZS_YLQXSCBA_ZB", "PX", "ID", "ZSID", "CPMC", "CPBAH", "DZRQ", "BZ", "PX", "ZT", "XZSPID"),
		/*医疗器械临床试验备案*/
		QX_LCSYBA("qxba", "", "T_JC_ZS_YLQXLCSYBA_ZB", "TO_NUMBER(NUM)", "ID", "ZSID", "NUM", "MC", "DZ", "LXR", "DH", "LB", "ZT", "XZSPID"),
		/*医疗器械产品出口销售证明*/
		QXCK_XSZM("qxxs", "", "T_JC_ZS_YLQXCPCKXSZM_ZB", "TO_NUMBER(NUM)", "ID", "ZSID", "NUM", "MC", "GG", "BH", "ZT", "XZSPID"),
		/*医疗器械网络销售备案*/
		QX_WLXSBA("wlxsba", "", "BA_QXWLXSBA_ZB", "TO_NUMBER(NUM)", "ID", "ZSID", "SHXYDM", "DSFPTBAFPTMC", "PZBH", "BZ", "NUM", "XZSPID"),
		/*未知子表*/
		UNKNOWN("_unknown_", "未知", "UNKNOWN_SUB_TABLE", "");

		CertSubTableEnum(String abbr, String title, String tableName, String orderBy, String... columns) {
			this.abbr = abbr;
			this.tableName = tableName;
			this.orderBy = orderBy;
			this.columns = columns;
		}

		static {
			initMetadata();
		}

		private final String abbr;
		private String title;
		private String tableName;
		private String orderBy;
		private String[] columns;
		private List<CertMetadata> metadata;

		public String getTableName(String zt) {
			String suffix = "";
			if ("1".equals(zt)) suffix = "_LS";
			else if ("4".equals(zt)) suffix = "_ZS";
			return tableName + suffix;
		}

		public String getTableNameDgz() {
			return getTableName("3");
		}

		public String getTableNameLs() {
			return getTableName("1");
		}

		public String getTableNameZs() {
			return getTableName("4");
		}

		public String getSortColumn() {
			String res = StringUtils.contains(orderBy, "TO_NUMBER") ? orderBy.replaceAll("TO_NUMBER\\((.+)\\)", "$1") : orderBy;
			return ArrayUtils.contains(columns, res) ? res : null;
		}

		public static CertSubTableEnum byAbbr(String abbr) {
			List<CertSubTableEnum> res = byAbbrArray(abbr);
			return CollectionUtils.isNotEmpty(res) ? res.get(0) : CertSubTableEnum.UNKNOWN;
		}

		public static List<CertSubTableEnum> byAbbrArray(String... abbrArray) {
			List<CertSubTableEnum> res = new ArrayList<>();
			for (String abbr : abbrArray) {
				for (CertSubTableEnum item : values()) {
					if (StringUtils.equals(abbr, item.getAbbr())) res.add(item);
				}
			}
			return res;
		}

		public static void initMetadata() {
			Charset charset = StandardCharsets.UTF_8;
			JSONObject json = null;
			String path = StringUtils.trimToEmpty(SpringContextUtils.getBean(Environment.class).getProperty("spring.config.location"));
			for (String item : path.split("[,]+")) {
				URI uri = null;
				try {uri = new URI(item);} catch (Throwable ignore) {}
				File file = new File(item);
				if (null != uri) {
					if (StringUtils.equalsIgnoreCase(uri.getScheme(), "file"))
						file = new File(uri);
					if (StringUtils.equalsIgnoreCase(uri.getScheme(), "classpath")) {
						String str = uri.getPath();
						if ("/".equals(str)) str = "";
						try (InputStream in = CertUtils.class.getResourceAsStream(str + "/cert.json")) {
							if (null != in) {
								json = JSON.parseObject(IOUtils.toString(in, charset));
								break;
							}
						} catch (Exception ignore) {}
					}
				}
				if (file.isFile()) file = file.getParentFile();
				try {
					json = JSON.parseObject(FileUtils.readFileToString(new File(file, "cert.json"), charset));
					break;
				} catch (Throwable ignore) {}
			}
			if (null == json) {
				try (InputStream in = CertUtils.class.getResourceAsStream("/cert.json")) {
					if (null != in) json = JSON.parseObject(IOUtils.toString(in, charset));
				} catch (Exception ignore) {}
			}
			if (null == json) return;
			json = json.getJSONObject("subTable");
			if (null == json) return;
			for (String abbr : json.keySet()) {
				CertSubTableEnum em = byAbbr(abbr);
				if (null == em) continue;
				JSONObject item = json.getJSONObject(abbr);
				em.title = StringUtils.defaultIfBlank(item.getString("title"), em.title);
				em.tableName = StringUtils.defaultIfBlank(item.getString("tableName"), em.tableName);
				em.orderBy = StringUtils.defaultIfEmpty(item.getString("orderBy"), em.orderBy);
				String[] array = item.getObject("columns", String[].class);
				if (ArrayUtils.isNotEmpty(array)) em.columns = array;
				em.metadata = item.getObject("metadata", new TypeReference<List<CertMetadata>>() {});
			}
		}

	}

}
