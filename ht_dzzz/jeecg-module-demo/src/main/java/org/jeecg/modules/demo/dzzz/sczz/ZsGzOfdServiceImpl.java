package org.jeecg.modules.demo.dzzz.sczz;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertInfo;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertInfoService;
import org.jeecg.modules.demo.dzzz.certmatadataversion.entity.CertMetadata;
import org.jeecg.modules.demo.dzzz.certmatadataversion.service.ICertMetadataService;
import org.jeecg.modules.demo.dzzz.certmode.entity.CertMode;
import org.jeecg.modules.demo.dzzz.certmode.service.ICertModeService;
import org.jeecg.modules.demo.dzzz.util.BeanUtils;
import org.jeecg.modules.demo.dzzz.util.OfdUtil;
import org.jeecg.modules.demo.dzzz.util.XmlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @description:
 * @author: 刘枫
 * @date: 2021-1-25
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class ZsGzOfdServiceImpl  {

    private static final Logger logger = LoggerFactory.getLogger(ZsGzOfdServiceImpl.class);
  @Autowired
    ICertMetadataService iCertMetadataService;
  /*  @Autowired
    private SystemProps systemProps;

    @Autowired
    private SlaveService slaveService;

    @Autowired
    private ZsGzMapper zsGzMapper;
    @Autowired
    private TJcFjMapper fjMapper;
    @Autowired
    private ZsLsMapper zsLsMapper;
    @Autowired
    private ZsMapper zsMapper;
    @Autowired
    private ZsyMapper zsyMapper;
    @Autowired
    private ZsCzjlmxLsMapper mxLsMapper;
    @Autowired
    private ZsCzjlmxMapper mxMapper;
    @Autowired
    private TJcQyJbxxMapper qyxxMapper;
    @Autowired
    private ZsCzjlLsMapper czjlLsMapper;
    @Autowired
    private ZsCzjlMapper czjlMapper;
    @Autowired
    private ZsmbMapper zsmbMapper;
    @Autowired
    private ZsPdfMapper pdfMapper;

    //子表Mapper
    @Autowired
    private YlqxcpckxszmZbMapper ylqxcpckxszmZbMapper;
    @Autowired
    private YlqxcpckxszmZbLsMapper ylqxcpckxszmZbLsMapper;
    @Autowired
    private YlqxscbaMapper ylqxscbaMapper;
    @Autowired
    private MzyphjsypddscpjMapper mzyphjsypddscpjMapper;
    @Autowired
    private DylylqxscbapzZbMapper dylylqxscbapzZbMapper;
    @Autowired
    private DylylqxscwtbaZbMapper dylylqxscwtbaZbMapper;
    @Autowired
    private MzypjsypgyzmZbMapper mzypjsypgyzmZbMapper;
    @Autowired
    private TsypmcgyzmZbMapper tsypmcgyzmZbMapper;
    @Autowired
    private YlqxwtscbaZbMapper ylqxwtscbaZbMapper;
    @Autowired
    private YlqxlcsybaZbMapper ylqxlcsybaZbMapper;
    @Autowired
    private YpckzxzZbMapper ypckzxzZbMapper;
    @Autowired
    private YpckxszmZbMapper ypckxszmZbMapper;
    @Autowired
    private CkomylyZbMapper ckomylyZbMapper;

    @Autowired
    private YlqxscbaLsMapper ylqxscbaLsMapper;
    @Autowired
    private MzyphjsypddscpjLsMapper mzyphjsypddscpjLsMapper;
    @Autowired
    private DylylqxscbapzZbLsMapper dylylqxscbapzZbLsMapper;
    @Autowired
    private DylylqxscwtbaZbLsMapper dylylqxscwtbaZbLsMapper;
    @Autowired
    private MzypjsypgyzmZbLsMapper mzypjsypgyzmZbLsMapper;
    @Autowired
    private TsypmcgyzmZbLsMapper tsypmcgyzmZbLsMapper;
    @Autowired
    private YlqxwtscbaZbLsMapper ylqxwtscbaZbLsMapper;
    @Autowired
    private YlqxlcsybaZbLsMapper ylqxlcsybaZbLsMapper;
    @Autowired
    private YpckzxzZbLsMapper ypckzxzZbLsMapper;
    @Autowired
    private YpckxszmZbLsMapper ypckxszmZbLsMapper;
    @Autowired
    private CkomylyZbLsMapper ckomylyZbLsMapper;

    @Autowired
    private ZsHistoryMapper zsHistoryMapper;

    @Autowired
    private ModifyInfo modifyInfo;*/

    @Autowired
    private ICertInfoService iCertInfoService;

    @Autowired
    ICertModeService iCertModeService;
    @Value(value = "${jeecg.path.upload}")
    private String uploadpath;
    /*@Override
    public List<TYwZs> selectZsGzList(TYwZs zs) {
        return zsGzMapper.selectZsGzList(zs);
    }
*/
   /* @Override
    public boolean checkFj(String id) {
        Wrapper<TJcFj> query = Wrappers.<TJcFj>lambdaQuery()
                .eq(TJcFj::getFjid, id)
                .eq(TJcFj::getLx, "ggfj");
        return fjMapper.selectList(query).isEmpty();
    }*/

    /**
     * @param zsids         批量盖章
     * @param signatureName
     * @param keySn
     * @param request
     * @throws Exception
     */

    public void batchGz(String zsids, String signatureName, String keySn, HttpServletRequest request) throws Exception {
        //第一步 查询证照数据
        CertInfo certInfo = iCertInfoService.getById(zsids);

        //第二部 将证照数据复制至新的对接对象
        ZsDto zsDto = new ZsDto();
        BeanUtils.copyProperties(certInfo,zsDto);

        //第三步 处理对接对象的数据


        //第四步  获取证照类型模型文件
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("certtypeid",certInfo.getCerttypeid());
        queryWrapper.eq("zt","1");
         List<CertMode> certModes = iCertModeService.list(queryWrapper);
         CertMode certMode=null;
         if (!certModes.isEmpty()&&certModes.size()>0)
         {
             certMode=certModes.get(0);
         }
         //拼装路径
        String oldfile = uploadpath+certMode.getFile();
        File zsPdfDir = new File(oldfile);
        if (!zsPdfDir.exists()) {
            zsPdfDir.mkdirs();
        }

        String timeStr =  new SimpleDateFormat("yyyyMMddHHmmss").format( new Date());
        String newfile = uploadpath + "/" + certInfo.getId() + "_"
                + timeStr + "_" + ( 1) + "_temp.ofd";
        //第五步
        List<CertMetadata> cardrecordlist = getRecordList(false, 0);

        //第五步  将模板文件，对接对象，文件地址 传给接口 获取接口返回的文件 完成
        createOfdByTemplate(zsDto, cardrecordlist,
                oldfile, newfile);


    }

    /*private String addSignFy1(String fyPdfPath, String gzwz, String signatureName, String keySn, ZsDto zsDto, Map<String, String> fjmap, ZsDto cardprint) throws Exception {
        String fileName = null;
        try {
            String content = Signature.getQrcode() + "gyEntcardprint.id="
                    + cardprint.getId() + "&gyEntcardprint.cardtype="
                    + codeMapper.selectCodeByZslx(cardprint.getZslx());
            //加二维码
            String path = SignatureUtil.addQrcode(fyPdfPath, "T001", "测试章", content, zsDto);
            String ofdPath = OfdUtil.pdf2Ofd(path);
            fileName = addSignOfd(ofdPath, gzwz, signatureName, keySn, zsDto, fjmap);
        } catch (Exception e) {
            logger.error("副页转换盖章失败:{}", e.getMessage());
            throw new Exception("副页转换盖章失败", e);
        }
        return fileName;
    }
*/
   /* @Override
    public void updateCardPrintGz(HttpServletRequest request, String id, String signatureName, String keySn) throws Exception {
        batchGz(id, signatureName, keySn, request);
        TYwZs zs = zsMapper.selectZsById(id);
        List<TYwZsMm> moduleList = zsmbMapper.selectList(Wrappers.<TYwZsMm>lambdaQuery()
                .eq(TYwZsMm::getZslx, zs.getZslx())
                .notIn(TYwZsMm::getMblx, "4", "7")
                .orderByAsc(TYwZsMm::getPxm));
        List<Map<String, String>> btnMapList = new ArrayList<Map<String, String>>();
        String pdfUrl = Signature.getPdfViewUrl();// pdf访问地址
        List<TYwZsPdf> zsPdfList = pdfMapper.selectList(Wrappers.<TYwZsPdf>lambdaQuery()
                .eq(TYwZsPdf::getZsid, id)
                .eq(TYwZsPdf::getSfdsy, 1)
                .orderByAsc(TYwZsPdf::getPx));
        for (TYwZsPdf pdf : zsPdfList) {
            Map<String, String> btnMap = new HashMap<String, String>();
            btnMap.put("name", pdf.getMc());
            btnMap.put("path", pdfUrl + "/" + pdf.getXzqh() + "/" + pdf.getLj());
            btnMapList.add(btnMap);
        }
        request.setAttribute("btnMapList", btnMapList);
    }
*/
 /*   @Override
    public String findXzspIdByZsId(String zsid) {
        List<String> list = zsMapper.selectXzspIdByZsId(zsid);
        String rs = "";
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                rs = list.get(i);
                if (!StringUtils.isEmpty(rs)) {
                    break;
                }
            }
        }
        return rs;
    }

    @Override
    public List<ZsVo> findQxgzList(ZsVo zs) {
        return zsGzMapper.selectQxgzList(zs);
    }

    @Override
    public int qxgz(String zsid) throws Exception {
        List<TYwZsCzjlLs> list = czjlLsMapper.selectList(Wrappers.<TYwZsCzjlLs>lambdaQuery().eq(TYwZsCzjlLs::getZsid, zsid));
        if (!list.isEmpty()) {
            throw new BusinessException("还有待盖章的操作记录,请等待盖章后重试!");
        }
        SysUser user = ShiroUtils.getSysUser();
        TYwZsCzjlLs czjlLs = ZsUtils.newOperLs(zsid, user, Constants.CZJL_SJLY_SJ, Constants.CZJL_YWLB_QXGZ);
        return czjlLsMapper.insert(czjlLs);
    }

    @Override
    public String viewCtzy(String id, Integer zslx) {
        String url = "";
        if (zslx == 75 || zslx == 76) {
            String clxid = "";
            if (zslx == 75) {
                clxid = RuoYiConfig.getCtzyFileSc();
            } else if (zslx == 76) {
                clxid = RuoYiConfig.getCtzyFileBg();
            }
            //查询行政审批附件表
            List<TJcFj> list = slaveService.selectXzspFj(clxid, id);
            if (null != list && list.size() > 0) {
                url = url + list.get(0).getFjlj();
            }
        }
        return url;
    }
*/

    /**
     * 创建变更pdf
     *
     * @param bgTemplateList
     * @param bgTemplateTdList
     * @param cardprint
     * @param pdfFolder
     * @param contextDir
     * @param adCode
     * @param signatureName
     * @param keySn
     * @param idx
     * @param user
     * @throws Exception
     */
 /*   public void createBgPdf(List<TYwZsMm> bgTemplateList,
                            List<TYwZsMm> bgTemplateTdList, ZsDto cardprint,
                            String pdfFolder, String contextDir, Integer adCode,
                            String signatureName, String keySn, int idx, SysUser user,
                            String operateId) throws Exception {
        int j = idx;
        if (bgTemplateList.size() == 0) {// 如果没有变更模板，则直接返回
            return;
        }
        Integer zslx = cardprint.getZslx();
        String dateStr = DateUtils.parseDateToStr("yyyyMMdd", new Date());
        String timeStr = DateUtils.parseDateToStr("yyyyMMddHHmmss", new Date());
        String[] modifyFields = {"modifyinfo1", "modifyinfo2", "modifyinfo3",
                "modifyinfo4", "modifyinfo5", "modifyinfo6", "modifyinfo7", "modifyinfo8"};
        final List<TYwZsZsy> cardrecordlist = getRecordList(true,
                zslx);
        String modifyContent = null;
        int index = 0;
        for (int i = 0; i < modifyFields.length; i++) {
            String modifyInfo = (String) PropertyUtils.getProperty(
                    cardprint, modifyFields[i]);
            if (StringUtils.isNotEmpty(modifyInfo)) {
                modifyContent = modifyInfo;
                index = i;
            }
        }

        if (bgTemplateList.size() <= index) {
            if (index == 7) {
                cardprint.setModifyinfo1(cardprint.getModifyinfo3());
                cardprint.setModifyinfo2(cardprint.getModifyinfo4());
                cardprint.setModifyinfo3(cardprint.getModifyinfo5());
                cardprint.setModifyinfo4(cardprint.getModifyinfo6());
                cardprint.setModifyinfo5(cardprint.getModifyinfo7());
                cardprint.setModifyinfo6(cardprint.getModifyinfo8());
                cardprint.setModifytime1(cardprint.getModifytime3());
                cardprint.setModifytime2(cardprint.getModifytime4());
                cardprint.setModifytime3(cardprint.getModifytime5());
                cardprint.setModifytime4(cardprint.getModifytime6());
                cardprint.setModifytime5(cardprint.getModifytime7());
                cardprint.setModifytime6(cardprint.getModifytime8());
            } else if (index == 6) {
                cardprint.setModifyinfo1(cardprint.getModifyinfo2());
                cardprint.setModifyinfo2(cardprint.getModifyinfo3());
                cardprint.setModifyinfo3(cardprint.getModifyinfo4());
                cardprint.setModifyinfo4(cardprint.getModifyinfo5());
                cardprint.setModifyinfo5(cardprint.getModifyinfo6());
                cardprint.setModifyinfo6(cardprint.getModifyinfo7());
                cardprint.setModifytime1(cardprint.getModifytime2());
                cardprint.setModifytime2(cardprint.getModifytime3());
                cardprint.setModifytime3(cardprint.getModifytime4());
                cardprint.setModifytime4(cardprint.getModifytime5());
                cardprint.setModifytime5(cardprint.getModifytime6());
                cardprint.setModifytime6(cardprint.getModifytime7());
            }
            index = 5;
        }

        if (StringUtils.isNotEmpty(modifyContent)
                && bgTemplateList.size() > index) {
            TYwZsMm dyTmpTemp = bgTemplateList.get(index);
            if (!bgTemplateTdList.isEmpty()) {
                TYwZsMm tdTmpTemp = bgTemplateTdList.get(index);
            }
            // 带水印的
            String pdfDir = pdfFolder + "/" + adCode + "/dy/" + dateStr;
            File pdfDirFile = new File(pdfDir);
            if (!pdfDirFile.exists()) {
                pdfDirFile.mkdirs();
            }
            String pdfZbPath = pdfDir + "/" + cardprint.getId() + "_" + timeStr
                    + "_" + (j + 1) + "_bg_temp.pdf";
            String pdfZbTemplatePath = contextDir + "/"
                    + dyTmpTemp.getAttachUrl();
            if (zslx.equals(6)) {
                if (StringUtils.isNotEmpty(cardprint.getModifyinfo1())) {
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo1())) {
                        String value = cardprint.getModifyinfo1();
                        cardprint.setModifyinfo1(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo2())) {
                        String value = cardprint.getModifyinfo2();
                        cardprint.setModifyinfo2(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo3())) {
                        String value = cardprint.getModifyinfo3();
                        cardprint.setModifyinfo3(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo4())) {
                        String value = cardprint.getModifyinfo4();
                        cardprint.setModifyinfo4(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo5())) {
                        String value = cardprint.getModifyinfo5();
                        cardprint.setModifyinfo5(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo6())) {
                        String value = cardprint.getModifyinfo6();
                        cardprint.setModifyinfo6(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo7())) {
                        String value = cardprint.getModifyinfo7();
                        cardprint.setModifyinfo7(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo8())) {
                        String value = cardprint.getModifyinfo8();
                        cardprint.setModifyinfo8(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo9())) {
                        String value = cardprint.getModifyinfo9();
                        cardprint.setModifyinfo9(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo10())) {
                        String value = cardprint.getModifyinfo10();
                        cardprint.setModifyinfo10(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo11())) {
                        String value = cardprint.getModifyinfo11();
                        cardprint.setModifyinfo11(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo12())) {
                        String value = cardprint.getModifyinfo12();
                        cardprint.setModifyinfo12(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo13())) {
                        String value = cardprint.getModifyinfo13();
                        cardprint.setModifyinfo13(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo14())) {
                        String value = cardprint.getModifyinfo14();
                        cardprint.setModifyinfo14(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo15())) {
                        String value = cardprint.getModifyinfo15();
                        cardprint.setModifyinfo15(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo16())) {
                        String value = cardprint.getModifyinfo16();
                        cardprint.setModifyinfo16(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo17())) {
                        String value = cardprint.getModifyinfo17();
                        cardprint.setModifyinfo17(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo18())) {
                        String value = cardprint.getModifyinfo18();
                        cardprint.setModifyinfo18(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo19())) {
                        String value = cardprint.getModifyinfo19();
                        cardprint.setModifyinfo19(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo20())) {
                        String value = cardprint.getModifyinfo20();
                        cardprint.setModifyinfo20(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo21())) {
                        String value = cardprint.getModifyinfo21();
                        cardprint.setModifyinfo21(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo22())) {
                        String value = cardprint.getModifyinfo22();
                        cardprint.setModifyinfo22(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo23())) {
                        String value = cardprint.getModifyinfo23();
                        cardprint.setModifyinfo23(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo24())) {
                        String value = cardprint.getModifyinfo24();
                        cardprint.setModifyinfo24(value.replace("\n", ""));
                    }
                }
            }
            createPdfByTemplate(cardprint, cardrecordlist,
                    pdfZbTemplatePath, pdfZbPath);
            String bgFileName = addBgSign(pdfZbPath, dyTmpTemp.getGzwz(),
                    signatureName, keySn, cardprint);// 打印模板pdf
            String path = "dy/" + dateStr + "/" + bgFileName + ".pdf";
            TYwZsPdf zsPdf = new TYwZsPdf();
            zsPdf.setCjsj(new Date());
            zsPdf.setMc("变更");
            zsPdf.setXzqh(adCode);
            zsPdf.setLj(path);
            zsPdf.setSfdsy(1);// 带水印
            j++;
            zsPdf.setPx(j);
            zsPdf.setZsid(cardprint.getId());
            zsPdf.setMbid(dyTmpTemp.getId());
            zsPdf.setUserid(user.getUserId());
            zsPdf.setUsermc(user.getUserName());
            zsPdf.setZzlx(dyTmpTemp.getZzlx());
            zsPdf.setGzwz(dyTmpTemp.getGzwz());
            zsPdf.setZt("0");
            zsPdf.setCzjlid(operateId);
            pdfMapper.insert(zsPdf);
            // 不带水印的
            *//*pdfDir = pdfFolder + "/" + adCode + "/td/" + dateStr;
            pdfDirFile = new File(pdfDir);
            if (!pdfDirFile.exists()) {
                pdfDirFile.mkdirs();
            }*//*
            *//*套打注释*//*
            //String pdfZbTdPath = pdfDir + "/" + cardprint.getId() + "_"
            //        + timeStr + "_" + (j + 1) + "_bg_td_temp.pdf";
            //pdfZbTemplatePath = contextDir + "/" + tdTmpTemp.getAttachUrl();
            //createPdfByTemplate(cardprint, cardrecordlist, pdfZbTemplatePath, pdfZbTdPath);
            //String bgTdFileName = addBgSign(pdfZbTdPath, tdTmpTemp.getGzwz(),
            //        signatureName, keySn, cardprint);// 套打模板pdf
            //path = "td/" + dateStr + "/" + bgTdFileName + ".pdf";
            //TYwZsPdf zsTdPdf = new TYwZsPdf();
            //zsTdPdf.setCjsj(new Date());
            //zsTdPdf.setMc("变更套打");
            //zsTdPdf.setXzqh(adCode);
            //zsTdPdf.setLj(path);
            //zsTdPdf.setSfdsy(0);// 不带水印
            //zsTdPdf.setPx(j);
            //zsTdPdf.setZsid(cardprint.getId());
            //zsTdPdf.setMbid(tdTmpTemp.getId());
            //zsTdPdf.setUserid(user.getUserId());
            //zsTdPdf.setUsermc(user.getUserName());
            //zsTdPdf.setZzlx(tdTmpTemp.getZzlx());
            //zsTdPdf.setGzwz(tdTmpTemp.getGzwz());
            //zsTdPdf.setPdfid(zsPdf.getId());
            //zsTdPdf.setCzjlid(operateId);
            //pdfMapper.insert(zsTdPdf);
            //j++;
        }
    }

    public void createBgOfd(List<TYwZsMm> bgTemplateList,
                            List<TYwZsMm> bgTemplateTdList, ZsDto cardprint,
                            String pdfFolder, String contextDir, Integer adCode,
                            String signatureName, String keySn, int idx, SysUser user,
                            String operateId) throws Exception {
        int j = idx;
        if (bgTemplateList.size() == 0) {// 如果没有变更模板，则直接返回
            return;
        }
        Integer zslx = cardprint.getZslx();
        String dateStr = DateUtils.parseDateToStr("yyyyMMdd", new Date());
        String timeStr = DateUtils.parseDateToStr("yyyyMMddHHmmss", new Date());
        String[] modifyFields = {"modifyinfo1", "modifyinfo2", "modifyinfo3",
                "modifyinfo4", "modifyinfo5", "modifyinfo6", "modifyinfo7", "modifyinfo8"};
        final List<TYwZsZsy> cardrecordlist = getRecordList(true,
                zslx);
        String modifyContent = null;
        int index = 0;
        for (int i = 0; i < modifyFields.length; i++) {
            String modifyInfo = (String) PropertyUtils.getProperty(
                    cardprint, modifyFields[i]);
            if (StringUtils.isNotEmpty(modifyInfo)) {
                modifyContent = modifyInfo;
                index = i;
            }
        }

        if (bgTemplateList.size() <= index) {
            if (index == 7) {
                cardprint.setModifyinfo1(cardprint.getModifyinfo3());
                cardprint.setModifyinfo2(cardprint.getModifyinfo4());
                cardprint.setModifyinfo3(cardprint.getModifyinfo5());
                cardprint.setModifyinfo4(cardprint.getModifyinfo6());
                cardprint.setModifyinfo5(cardprint.getModifyinfo7());
                cardprint.setModifyinfo6(cardprint.getModifyinfo8());
                cardprint.setModifytime1(cardprint.getModifytime3());
                cardprint.setModifytime2(cardprint.getModifytime4());
                cardprint.setModifytime3(cardprint.getModifytime5());
                cardprint.setModifytime4(cardprint.getModifytime6());
                cardprint.setModifytime5(cardprint.getModifytime7());
                cardprint.setModifytime6(cardprint.getModifytime8());
            } else if (index == 6) {
                cardprint.setModifyinfo1(cardprint.getModifyinfo2());
                cardprint.setModifyinfo2(cardprint.getModifyinfo3());
                cardprint.setModifyinfo3(cardprint.getModifyinfo4());
                cardprint.setModifyinfo4(cardprint.getModifyinfo5());
                cardprint.setModifyinfo5(cardprint.getModifyinfo6());
                cardprint.setModifyinfo6(cardprint.getModifyinfo7());
                cardprint.setModifytime1(cardprint.getModifytime2());
                cardprint.setModifytime2(cardprint.getModifytime3());
                cardprint.setModifytime3(cardprint.getModifytime4());
                cardprint.setModifytime4(cardprint.getModifytime5());
                cardprint.setModifytime5(cardprint.getModifytime6());
                cardprint.setModifytime6(cardprint.getModifytime7());
            }
            index = 5;
        }

        if (StringUtils.isNotEmpty(modifyContent)
                && bgTemplateList.size() > index) {
            TYwZsMm dyTmpTemp = bgTemplateList.get(index);
            if (!bgTemplateTdList.isEmpty()) {
                TYwZsMm tdTmpTemp = bgTemplateTdList.get(index);
            }
            // 带水印的
            String pdfDir = pdfFolder + "/" + adCode + "/dy/" + dateStr;
            File pdfDirFile = new File(pdfDir);
            if (!pdfDirFile.exists()) {
                pdfDirFile.mkdirs();
            }
            String ofdZbPath = pdfDir + "/" + cardprint.getId() + "_" + timeStr
                    + "_" + (j + 1) + "_bg_temp.ofd";
            String ofdZbTemplatePath = contextDir + "/"
                    + dyTmpTemp.getAttachUrl();
            *//*if (zslx.equals(6)) {
                if (StringUtils.isNotEmpty(cardprint.getModifyinfo1())) {
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo1())) {
                        String value = cardprint.getModifyinfo1();
                        cardprint.setModifyinfo1(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo2())) {
                        String value = cardprint.getModifyinfo2();
                        cardprint.setModifyinfo2(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo3())) {
                        String value = cardprint.getModifyinfo3();
                        cardprint.setModifyinfo3(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo4())) {
                        String value = cardprint.getModifyinfo4();
                        cardprint.setModifyinfo4(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo5())) {
                        String value = cardprint.getModifyinfo5();
                        cardprint.setModifyinfo5(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo6())) {
                        String value = cardprint.getModifyinfo6();
                        cardprint.setModifyinfo6(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo7())) {
                        String value = cardprint.getModifyinfo7();
                        cardprint.setModifyinfo7(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo8())) {
                        String value = cardprint.getModifyinfo8();
                        cardprint.setModifyinfo8(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo9())) {
                        String value = cardprint.getModifyinfo9();
                        cardprint.setModifyinfo9(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo10())) {
                        String value = cardprint.getModifyinfo10();
                        cardprint.setModifyinfo10(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo11())) {
                        String value = cardprint.getModifyinfo11();
                        cardprint.setModifyinfo11(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo12())) {
                        String value = cardprint.getModifyinfo12();
                        cardprint.setModifyinfo12(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo13())) {
                        String value = cardprint.getModifyinfo13();
                        cardprint.setModifyinfo13(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo14())) {
                        String value = cardprint.getModifyinfo14();
                        cardprint.setModifyinfo14(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo15())) {
                        String value = cardprint.getModifyinfo15();
                        cardprint.setModifyinfo15(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo16())) {
                        String value = cardprint.getModifyinfo16();
                        cardprint.setModifyinfo16(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo17())) {
                        String value = cardprint.getModifyinfo17();
                        cardprint.setModifyinfo17(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo18())) {
                        String value = cardprint.getModifyinfo18();
                        cardprint.setModifyinfo18(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo19())) {
                        String value = cardprint.getModifyinfo19();
                        cardprint.setModifyinfo19(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo20())) {
                        String value = cardprint.getModifyinfo20();
                        cardprint.setModifyinfo20(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo21())) {
                        String value = cardprint.getModifyinfo21();
                        cardprint.setModifyinfo21(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo22())) {
                        String value = cardprint.getModifyinfo22();
                        cardprint.setModifyinfo22(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo23())) {
                        String value = cardprint.getModifyinfo23();
                        cardprint.setModifyinfo23(value.replace("\n", ""));
                    }
                    if (StringUtils.isNotEmpty(cardprint.getModifyinfo24())) {
                        String value = cardprint.getModifyinfo24();
                        cardprint.setModifyinfo24(value.replace("\n", ""));
                    }
                }
            }*//*
            createOfdByTemplate(cardprint, cardrecordlist,
                    ofdZbTemplatePath, ofdZbPath);
            String bgFileName = addBgSignOfd(ofdZbPath, dyTmpTemp.getGzwz(),
                    signatureName, keySn, cardprint, new ArrayList<>());// 打印模板pdf
            String path = "dy/" + dateStr + "/" + bgFileName + ".ofd";
            TYwZsPdf zsPdf = new TYwZsPdf();
            zsPdf.setCjsj(new Date());
            zsPdf.setMc("变更");
            zsPdf.setXzqh(adCode);
            zsPdf.setLj(path);
            zsPdf.setSfdsy(1);// 带水印
            j++;
            zsPdf.setPx(j);
            zsPdf.setZsid(cardprint.getId());
            zsPdf.setMbid(dyTmpTemp.getId());
            zsPdf.setUserid(user.getUserId());
            zsPdf.setUsermc(user.getUserName());
            zsPdf.setZzlx(dyTmpTemp.getZzlx());
            zsPdf.setGzwz(dyTmpTemp.getGzwz());
            zsPdf.setZt("0");
            zsPdf.setCzjlid(operateId);
            pdfMapper.insert(zsPdf);
        }
    }
*/
/*

    public void createBgOfdNew(List<TYwZsMm> bgTemplateList,
                               List<TYwZsMm> bgTemplateTdList, ZsDto cardprint,
                               String pdfFolder, String contextDir, Integer adCode,
                               String signatureName, String keySn, int idx, SysUser user,
                               String operateId) throws Exception {
        int j = idx;
        if (bgTemplateList.size() == 0) {// 如果没有变更模板，则直接返回
            return;
        }
        TYwZsMm dyTmpTemp = bgTemplateList.get(0);
        Integer zslx = cardprint.getZslx();
        final List<TYwZsZsy> cardrecordlist = getRecordList(true,
                zslx);
        List<TYwZsCzjl> czjlList = czjlMapper.selectList(Wrappers.<TYwZsCzjl>lambdaQuery()
                .eq(TYwZsCzjl::getZsid, cardprint.getId())
                .eq(TYwZsCzjl::getYwlx, Constants.CZJL_YWLB_CHANGE)
                .orderByAsc(TYwZsCzjl::getCzsj));
        if (zslx == 8) {
            //如果是医疗器械生产许可证，则变更记录在2022年5月1日前的数据都将不显示在变更记录列表中
            Date date = DateUtils.parseDate("2022-04-30", "yyyy-MM-dd");
            czjlList = czjlList.stream().filter(s -> s.getCzsj().after(date)).collect(Collectors.toList());
        }


        String dateStr = DateUtils.parseDateToStr("yyyyMMdd", new Date());
        String timeStr = DateUtils.parseDateToStr("yyyyMMddHHmmss", new Date());
        //已拓展到理论无限
        List<Map<String, Object>> modifyinfoList = cardprint.getModifyinfoList();
        if (modifyinfoList == null || modifyinfoList.isEmpty()) {
            return;
        }
        int size = modifyinfoList.size();
        String position = dyTmpTemp.getGzwz();
        //String six = OfdConfig.getBgsix();
        //String eight = OfdConfig.getBgeight();
        //boolean sixItem = Arrays.asList(six.split(",")).contains(zslx.toString());
        //通过模板的盖章位置个数判断该模板是一页六个还是八个
       
//        boolean sixItem = position.split("_").length == 6;
//        //通过记录数和每页数量计算变更页数
//        int page = 1;//默认一页
//        if (size % (sixItem ? 6 : 8) > 0) {
//            page = page + size / (sixItem ? 6 : 8);
//        } else {
//            page = size / (sixItem ? 6 : 8);
//        }
//                logger.info("ID:{},编号:{},变更分页数:{}", cardprint.getId(), cardprint.getZsbh(), page);
//        //分割每一个变更页需要使用的操作记录,用于分页盖章时定位
//        List<List<TYwZsCzjl>> split = CollUtil.split(czjlList, sixItem ? 6 : 8);
//        //分割变更详情列表
//        List<List<Map<String, Object>>> split2 = CollUtil.split(modifyinfoList, sixItem ? 6 : 8);
                //特殊情况换成4个
                boolean sixItem = position.split("_").length == 4;
        //通过记录数和每页数量计算变更页数
        int page = 1;//默认一页
        if (size % (sixItem ? 4 : 8) > 0) {
            page = page + size / (sixItem ? 4 : 8);
        } else {
            page = size / (sixItem ? 4 : 8);
        }
        logger.info("ID:{},编号:{},变更分页数:{}", cardprint.getId(), cardprint.getZsbh(), page);
        //分割每一个变更页需要使用的操作记录,用于分页盖章时定位
        List<List<TYwZsCzjl>> split = CollUtil.split(czjlList, sixItem ?4 : 8);
        //分割变更详情列表
        List<List<Map<String, Object>>> split2 = CollUtil.split(modifyinfoList, sixItem ? 4 : 8);
        String pdfDir = pdfFolder + "/" + adCode + "/dy/" + dateStr;
        File pdfDirFile = new File(pdfDir);
        if (!pdfDirFile.exists()) {
            pdfDirFile.mkdirs();
        }
        //循环每页
        for (int i = 0; i < page; i++) {
            //获取该段的修改详情和修改时间列表
            List<Map<String, Object>> modifyinfos = split2.get(i);
            //设置每页的变更属性
            for (int k = 1; k < (sixItem ? 5 : 9); k++) {
                if (k - 1 == modifyinfos.size()) {
                    break;
                }
                Map<String, Object> modifyinfo = modifyinfos.get(k - 1);
                JavaReflect.setter(cardprint, "Modifyinfo" + k, modifyinfo.get("Modifyinfo"), String.class);
                JavaReflect.setter(cardprint, "Modifytime" + k, modifyinfo.get("Modifytime"), Date.class);
            }
            // TODO: 2021-9-14 之后改成从变更模板中获取,同时可直接判断该变更是六项还是八项
            */
/*
            if (position.length() <= 7) {
                if (sixItem) {
                    position = "404,530_404,325_404,120_914,530_914,325_914,120";
                } else {
                    position = "402,577_402,422_402,267_402,112_911,577_911,422_911,267_911,112";
                }
            }
            *//*

            //根据每页的变更记录数量动态获取盖章位置
            int index = 0;
            for (int k = 1; k < (sixItem ? 5 : 9); k++) {
                String value = (String) JavaReflect.getter(cardprint, "Modifyinfo" + k);
                if (StringUtils.isEmpty(value)) {
                    index = k;
                    break;
                }
            }
            if (index == 1) {//当前页第一项变更为空
                break;
            }
            if (index != 0) {
                int indexOf = StringUtils.getIndexOf(position, "_", (index - 1));
                position = position.substring(0, indexOf);
            }
            String ofdZbPath = pdfDir + "/" + cardprint.getId() + "_" + timeStr
                    + "_" + (j + 1) + "_bg_temp" + (i + 1) + ".ofd";
            String ofdZbTemplatePath = contextDir + "/"
                    + dyTmpTemp.getAttachUrl();
            createOfdByTemplate(cardprint, cardrecordlist,
                    ofdZbTemplatePath, ofdZbPath);
            String bgFileName = addBgSignOfd(ofdZbPath, position,
                    signatureName, keySn,
                    cardprint, split.get(i));//根据页标拿到该页对应的操作记录
            //循环每一页后清空modifyinfo属性 否则循环判断位置会出错
            for (int k = 1; k < 9; k++) {
                JavaReflect.setter(cardprint, "Modifyinfo" + k, null, String.class);
                JavaReflect.setter(cardprint, "Modifytime" + k, null, Date.class);
            }
            // 打印模板pdf
            String path = "dy/" + dateStr + "/" + bgFileName + ".ofd";
            TYwZsPdf zsPdf = new TYwZsPdf();
            zsPdf.setCjsj(new Date());
            zsPdf.setMc("变更" + (i + 1));
            //if (page == 1){
            //    zsPdf.setMc("变更");
            //}
            zsPdf.setXzqh(adCode);
            zsPdf.setLj(path);
            zsPdf.setSfdsy(1);// 带水印
            j++;
            zsPdf.setPx(j);
            zsPdf.setZsid(cardprint.getId());
            zsPdf.setMbid(dyTmpTemp.getId());
            zsPdf.setUserid(user.getUserId());
            zsPdf.setUsermc(user.getUserName());
            zsPdf.setZzlx(dyTmpTemp.getZzlx());
            zsPdf.setGzwz(dyTmpTemp.getGzwz());
            zsPdf.setZt("0");
            zsPdf.setCzjlid(operateId);
            pdfMapper.insert(zsPdf);
        }
    }
*/

   /* //单独变更页的文件
    public void createBgOfdSp(List<TYwZsMm> bgTemplateList,
                              List<TYwZsMm> bgTemplateTdList, ZsDto cardprint,
                              String pdfFolder, String contextDir, Integer adCode,
                              String signatureName, String keySn, int idx, SysUser user,
                              String operateId) throws Exception {
        int j = idx;
        if (bgTemplateList.size() == 0) {// 如果没有变更模板，则直接返回
            return;
        }
        List<Map<String, Object>> modifyinfoList = cardprint.getModifyinfoList();
        if (modifyinfoList == null || modifyinfoList.isEmpty()) {
            return;
        }
        Integer zslx = cardprint.getZslx();
        String dateStr = DateUtils.parseDateToStr("yyyyMMdd", new Date());
        String timeStr = DateUtils.parseDateToStr("yyyyMMddHHmmss", new Date());
        List<TYwZsCzjl> czjlList = czjlMapper.selectList(Wrappers.<TYwZsCzjl>lambdaQuery()
                .eq(TYwZsCzjl::getZsid, cardprint.getId())
                .eq(TYwZsCzjl::getYwlx, Constants.CZJL_YWLB_CHANGE)
                .orderByAsc(TYwZsCzjl::getCzsj));
        final List<TYwZsZsy> cardrecordlist = getRecordList(false, //因为是单独文件 所以传false
                zslx);
        //获取唯一变更模板
        TYwZsMm dyTmpTemp = bgTemplateList.get(0);
        //创建目录
        String pdfDir = pdfFolder + "/" + adCode + "/dy/" + dateStr;
        File pdfDirFile = new File(pdfDir);
        if (!pdfDirFile.exists()) {
            pdfDirFile.mkdirs();
        }

        for (int i = 0; i < modifyinfoList.size(); i++) {
            if (i == czjlList.size()) {
                break;
            }
            //对应的操作记录
            TYwZsCzjl czjl = czjlList.get(i);
            String xzspslh = czjl.getXzspslh();
            String jzqp = slaveService.getJzqp(xzspslh);
            Map<String, Object> map = modifyinfoList.get(i);
            String modifyInfo = (String) map.get("Modifyinfo");
            //取变更时间
            Date modifytime = (Date) map.get("Modifytime");
            //取局长签批
            if (zslx == 3 || zslx == 26) {
                modifytime = DateUtils.dateTime("yyyy-MM-dd", jzqp);
            }
            if (StringUtils.isNotEmpty(modifyInfo)) {
                //每条变更记录生成一个变更文件
                String ofdZbPath = pdfDir + "/" + cardprint.getId() + "_" + timeStr
                        + "_" + (j + 1) + "_bg_temp_" + (i + 1) + ".ofd";
                String ofdZbTemplatePath = contextDir + "/"
                        + dyTmpTemp.getAttachUrl();
                TYwZsZsy zsy = new TYwZsZsy();
                zsy.setYssx("ylzd36"); //用于单独模板上的变更内容字段
                cardrecordlist.add(zsy);
                String keysn = czjl.getQzid();
                String qzmc = czjl.getQzmc();
                ContrastKeySn key = SignatureUtil.contrastKeySn(keysn, qzmc);
                keysn = key.getKeySnOfd();
                qzmc = key.getKeyNameOfd();
                //List<TYwZsCzjlmx> mxList = mxMapper.selectList(Wrappers.<TYwZsCzjlmx>lambdaQuery()
                //        .eq(TYwZsCzjlmx::getZsczjlid, czjl.getId()));
                //if (!mxList.isEmpty()){
                //    String bz = mxList.get(0).getBz();
                //    cardprint.setBz(bz);
                //}else{
                //    cardprint.setBz("");
                //}
                if (zslx == 72) {
                    TYwZsZsy zsy1 = new TYwZsZsy();
                    zsy1.setYssx("bz"); //用于单独模板上的变更内容字段
                    cardrecordlist.add(zsy1);
                    cardprint.setBz("本文件与“医疗器械网络交易服务第三方平台备案凭证,编号" + cardprint.getZsbh() + "”共同使用。");
                } else {
                    cardprint.setBz("本文件与“" + cardprint.getCp() + "”注册证共同使用。");
                }
                if (!StringUtils.isEmpty(cardprint.getBz())) {
                    modifyInfo = StringUtils.substringBeforeLast(modifyInfo, "；") + "；";
                }
                cardprint.setYlzd36(modifyInfo);//变更内容
                cardprint.setFzrq(modifytime);//变更时间
                createOfdByTemplate(cardprint, cardrecordlist,
                        ofdZbTemplatePath, ofdZbPath);
                //变更页盖章
                String bgFileName = addSignOfd(ofdZbPath, dyTmpTemp.getGzwz(),
                        qzmc, keysn, cardprint, new HashMap());// 打印模板pdf
                String path = "dy/" + dateStr + "/" + bgFileName + ".ofd";
                TYwZsPdf zsPdf = new TYwZsPdf();
                zsPdf.setCjsj(new Date());
                zsPdf.setMc("变更" + (i + 1));
                zsPdf.setXzqh(adCode);
                zsPdf.setLj(path);
                zsPdf.setSfdsy(1);// 带水印
                j++;
                zsPdf.setPx(j);
                zsPdf.setZsid(cardprint.getId());
                zsPdf.setMbid(dyTmpTemp.getId());
                zsPdf.setUserid(user.getUserId());
                zsPdf.setUsermc(user.getUserName());
                zsPdf.setZzlx(dyTmpTemp.getZzlx());
                zsPdf.setGzwz(dyTmpTemp.getGzwz());
                zsPdf.setZt("0");
                zsPdf.setCzjlid(operateId);
                pdfMapper.insert(zsPdf);
            }

        }
    }


*/
/*
    */
/**
     * 添加签章,变更
     *
     * @param pdfPath
     * @param keyPath
     *//*

    public String addBgSign(String pdfPath, String position,
                            String signatureName, String serialNum, ZsDto cardprint) throws Exception {
        String content = Signature.getQrcode() + "gyEntcardprint.id="
                + cardprint.getId() + "&gyEntcardprint.cardtype="
                + codeMapper.selectCodeByZslx(cardprint.getZslx());
        return SignatureUtil.addSignBgPdf(pdfPath, content, position,
                signatureName, serialNum, cardprint);
    }

    public String addBgSignOfd(String pdfPath, String position,
                               String signatureName, String serialNum, ZsDto cardprint, List<TYwZsCzjl> czjlList) throws Exception {
        String content = Signature.getQrcode() + "gyEntcardprint.id="
                + cardprint.getId() + "&gyEntcardprint.cardtype="
                + codeMapper.selectCodeByZslx(cardprint.getZslx());
        return SignatureUtil.addSignBgOfd(pdfPath, content, position,
                signatureName, serialNum, cardprint, czjlList);
    }
*/

   /* *//**
     * 添加签章
     *
     * @param pdfPath
     * @param
     *//*
    public String addSign(String pdfPath, String position,
                          String signatureName, String serialNum, ZsDto cardprint, Map fjmap) throws Exception {
        String content = Signature.getQrcode() + "gyEntcardprint.id="
                + cardprint.getId() + "&gyEntcardprint.cardtype="
                + codeMapper.selectCodeByZslx(cardprint.getZslx());
        return SignatureUtil.addSignPdf(pdfPath, content, position,
                signatureName, serialNum, cardprint, fjmap);
    }

    public String addSignOfd(String pdfPath, String position,
                             String signatureName, String serialNum, ZsDto cardprint, Map fjmap) throws Exception {
        String content = Signature.getQrcode() + "gyEntcardprint.id="
                + cardprint.getId() + "&gyEntcardprint.cardtype="
                + codeMapper.selectCodeByZslx(cardprint.getZslx());
        return SignatureUtil.addSignOfd1(pdfPath, content, position,
                signatureName, serialNum, cardprint, fjmap);
    }


    public void createPdfByTemplate(ZsDto zsDto, List<TYwZsZsy> cardrecordlist, String pdfZbTemplatePath, String pdfPath) throws FileNotFoundException {
        InputStream pdfZbTemplateIs = null;
        try {
            String xmlTemplate = XmlUtil.createCardprintXML(zsDto, cardrecordlist);
            pdfZbTemplateIs = new FileInputStream(pdfZbTemplatePath);
            int ret = PdfUtil.createPdfFillContent(xmlTemplate, pdfPath,
                    pdfZbTemplateIs);// 生成查看的pdf
            if (ret == 1) {
                logger.info("证书【" + zsDto.getId() + "】生成pdf文件成功！");
            } else {
                logger.error("证书【" + zsDto.getId() + "】生成pdf文件失败！");
            }
        } catch (Exception e) {
            throw new BusinessException("生成pdf文件失败", e);
        }
    }
*/
    public void createOfdByTemplate(ZsDto zsDto, List<CertMetadata> cardrecordlist, String pdfZbTemplatePath, String pdfPath) throws FileNotFoundException {
        try {
            /*String content = Signature.getQrcode() + "gyEntcardprint.id="
                    + zsDto.getId() + "&gyEntcardprint.cardtype="
                    + codeMapper.selectCodeByZslx(zsDto.getZslx());
            zsDto.setQrcode(content);*/
            //拼装xml模板
            String xmlTemplate = XmlUtil.createCardprintXMLForOFD(zsDto, cardrecordlist,0);
            long start = System.currentTimeMillis();
            int ret = OfdUtil.template2Ofd(xmlTemplate, pdfZbTemplatePath, pdfPath);// 生成查看的ofd
            logger.error("生成OFD时间:{}", (System.currentTimeMillis() - start));
            if (ret == 1) {
                logger.info("证书【" + zsDto.getId() + "】生成OFD文件成功！");
            } else {
                logger.error("证书【" + zsDto.getId() + "】生成OFD文件失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 组装变更字段
     *
     * @return
     * @throws Exception
     */
    public List<CertMetadata> getRecordList(boolean sfbg, int cardType) {
        List<CertMetadata> recordList = null;
        if (!sfbg) {
            recordList = iCertMetadataService.list(Wrappers.<CertMetadata>lambdaQuery()
                    .eq(CertMetadata::getZslx, cardType)
                    .eq(CertMetadata::getZt, 0)
                    /*.eq(CertMetadata::getSfsc, 0)*/
                    .orderByAsc(CertMetadata::getPx));
        } else {
            recordList = new ArrayList<CertMetadata>();
            for (int i = 1; i < 9; i++) {
                CertMetadata record1 = new CertMetadata();
                record1.setYssx("modifyinfo" + i);
                recordList.add(record1);
                CertMetadata record2 = new CertMetadata();
                record2.setYssx("modifytime" + i);
                recordList.add(record2);
            }
        }
        return recordList;
    }

    /**
     * 临时表转正式表
     *
     * @param user
     * @param id
     * @param keySn
     * @param signatureName
     * @return
     */
   /* public TYwZsCzjl updateCardprintInfo(SysUser user, String id, String keySn, String signatureName) throws Exception {
        TYwZsCzjl tYwZsCzjl = new TYwZsCzjl();
        //临时证书 -> 正式证书
        TYwZs bean = zsMapper.selectZsById(id);
        //这份副本给二类注册,体外诊断试剂,第三方平台备案使用
        TYwZs zs1 = new TYwZs();
        BeanUtils.copyProperties(bean, zs1);
        boolean isTemp = StringUtils.isNotEmpty(bean.getTemp());
        TYwZs zs = new TYwZs();
        List<TYwZsCzjlLs> list = czjlLsMapper.selectList(Wrappers.<TYwZsCzjlLs>lambdaQuery().eq(TYwZsCzjlLs::getZsid, id).orderByAsc(TYwZsCzjlLs::getCzsj));
        if (list.isEmpty()) {
            throw new BusinessException("无法根据证书ID查询临时操作记录");
        }
        List<TYwZsCzjl> listRs = new ArrayList<>();
        for (int j = 0; j < list.size(); j++) {
            TYwZsCzjlLs czjlLs = list.get(j);
            //List<TYwZsZsy> zsyList = zsyMapper.selectList(Wrappers.<TYwZsZsy>lambdaQuery().eq(TYwZsZsy::getZt, 0).eq(TYwZsZsy::getZslx, bean.getZslx()));
            TYwZsCzjl czjl = new TYwZsCzjl();
            if (bean != null) {
                int status = czjlLs.getYwlx();
                //变更换发
                if (Constants.CZJL_YWLB_REPEAT.equals(status)
                        || Constants.CZJL_YWLB_CHANGE.equals(status)
                        || (Constants.CZJL_YWLB_MANDATORY.equals(status) && !isTemp)) {
                    List<TYwZsCzjlmx> mxRs = new ArrayList<>();
                    //List<BgxxDto> bgxxList = zsGzMapper.selectBg(id);
                    List<TYwZsCzjlmxLs> mxls = mxLsMapper.selectList(Wrappers.<TYwZsCzjlmxLs>lambdaQuery()
                            .eq(TYwZsCzjlmxLs::getZsczjlid, czjlLs.getId()));
                    boolean onlyBz = false;
                    if (mxls.size() == 1 && StringUtils.isEmpty(mxls.get(0).getZdmc()) && mxls.get(0).getZt().equals(Constants.CZJL_ZBCZ_UPDATE)) {
                        //变更信息只有备注
                        onlyBz = true;
                        TYwZsCzjlmx mx = new TYwZsCzjlmx();
                        BeanUtils.copyProperties(mxls.get(0), mx);
                        mxRs.add(mx);
                        mxLsMapper.deleteById(mxls.get(0).getId());
                    }
                    if (!onlyBz) {
                        List<BgxxDto> bgxxList = zsGzMapper.selectBg1(id, czjlLs.getId());
                        //用来插入正式表的明细列表
                        if (bgxxList != null && bgxxList.size() > 0) {
                            String modifyinfo = "";
                            Date modifytime = null;
                            String bgs = "";
                            String bz = "";
                            for (int i = 0; i < bgxxList.size(); i++) {
                                BgxxDto bgxx = bgxxList.get(i);
                                Object bghxx = bgxx.getBghxx();
                                // 字段类型（1：字符型；2：整数型；3：数字型；4：时间型）
                                Class<?> ValeuType = null;
                                if (bgxx.getDataType().equals(
                                        Constants.XZSP_CARDRECORD_TYPE_STRING)) {
                                    ValeuType = String.class;
                                }
                                if (bgxx.getDataType().equals(
                                        Constants.XZSP_CARDRECORD_TYPE_INTEGER)) {
                                    ValeuType = Integer.class;
                                    bghxx = Integer.valueOf(bgxx.getBghxx());
                                }
                                if (bgxx.getDataType().equals(
                                        Constants.XZSP_CARDRECORD_TYPE_FLOAT)) {
                                    ValeuType = Float.class;
                                    bghxx = Float.valueOf(bgxx.getBghxx());
                                }
                                if (bgxx.getDataType().equals(
                                        Constants.XZSP_CARDRECORD_TYPE_DATE)) {
                                    ValeuType = Date.class;
                                    bghxx = DateUtils.parseDate(bgxx.getBghxx(), "yyyy-MM-dd");

                                }
                                JavaReflect.setter(bean,
                                        JavaReflect.getFristStrUp(bgxx.getColumnsH()),
                                        bghxx, ValeuType);
                                TYwZsCzjlmxLs bgnrBean = mxLsMapper.selectById(bgxx.getId());
                                // 将变更后的信息更新到企业信息
                                if (bgxx.getColumnsH() != null) {
                                    String qyid = bean.getQyid();
                                    TJcQyJbxx gyEntbaseinfo = qyxxMapper.searchById(qyid);
                                    if ("qymc".equals(bgxx.getColumnsH())) {
                                        gyEntbaseinfo.setQymc(String.valueOf(bghxx));
                                    }
                                    if ("shxydm".equals(bgxx.getColumnsH())) {
                                        gyEntbaseinfo.setShxydm(String.valueOf(bghxx));
                                    }
                                    if ("fddbr".equals(bgxx.getColumnsH())) {
                                        gyEntbaseinfo.setFddbr(String.valueOf(bghxx));
                                    }
                                    if ("zcdz".equals(bgxx.getColumnsH())) {
                                        gyEntbaseinfo.setQyzcdz(String.valueOf(bghxx));
                                    }
                                    gyEntbaseinfo.setSyncZs("1");
                                    qyxxMapper.updateById(gyEntbaseinfo);
                                }
                                // 证书主表明细更新到正式表 逐条从临时表删除
                                mxLsMapper.deleteById(bgnrBean.getId());
                                TYwZsCzjlmx mx = new TYwZsCzjlmx();
                                BeanUtils.copyProperties(bgnrBean, mx);
                                //mx.setZt(1);//已盖章
                                mxRs.add(mx);
                            }
                        }
                        // 查询子表变更明细 通过证书ID,和记录表名不为业务表和业务正式表来判断是子表信息
                    *//*List<TYwZsCzjlmxLs> zbBgLsit = mxLsMapper.selectList(Wrappers.<TYwZsCzjlmxLs>lambdaQuery()
                            .notIn(TYwZsCzjlmxLs::getBm, "T_YW_ZS", "T_YW_ZS_LS")
                            .eq(TYwZsCzjlmxLs::getJlid, id));*//*
                        // 子表信息增删改
                        updateChildInfo(id, czjlLs.getId(), bean.getZslx(), mxRs);
                    }
                    //更新操作记录到正式表
                    czjlLsMapper.deleteById(czjlLs.getId());
                    czjl = new TYwZsCzjl();
                    BeanUtils.copyProperties(czjlLs, czjl);
                    czjl.setClsj(DateUtils.getNowDate());
                    czjl.setClrid(user.getUserId());
                    czjl.setClrxm(user.getUserName());
                    czjl.setZt(1);//已盖章
                    czjl.setQzid(keySn);//签章ID
                    czjl.setQzmc(signatureName);//签章名称
                    czjlMapper.insert(czjl);
                    //插入新的明细表
                    mxRs.forEach(temp -> {
                        mxMapper.insert(temp);
                    });
                    //update证书信息
                    //BeanUtils.copyProperties(bean,zs);
                    if (!"0".equals(bean.getExcel())) {
                        bean.setFzjg(systemProps.getMakedeptAbsypjdglj());
                    }
                    int[] excludes = {3, 26, 72};//二类注册,二类注册体外诊断,器械网络交易第三方
                    if (ArrayUtil.contains(excludes, bean.getZslx()) && Constants.CZJL_YWLB_CHANGE.equals(status)) {//这几类证的变更不改证面
                        //只修改同步标
                        zs1.setSjtbZsgs(1);
                        zs1.setSjtbDa(1);
                        zs1.setSjtbXzsp(1);
                        zs1.setSjtbGj(1);
                        zsMapper.updateById(zs1);
                    } else {
                        zsMapper.updateById(bean);
                        ZsHistory zsHistory = new ZsHistory();
                        BeanUtils.copyProperties(bean, zsHistory);
                        zsHistory.setId(null);
                        zsHistory.setZsid(bean.getId());
                        zsHistory.setCreateTime(DateUtils.getNowDate());
                        zsHistoryMapper.insert(zsHistory);
                    }
                } else if (Constants.CZJL_YWLB_NEW.equals(status)
                        || Constants.CZJL_YWLB_ADD.equals(status)
                        || Constants.CZJL_YWLB_MANDATORY.equals(status)) {
                    //补发核发
                    if (Constants.CZJL_YWLB_NEW.equals(status)
                            || (Constants.CZJL_YWLB_MANDATORY.equals(status) && isTemp)) {
                        //核发,将信息更新到企业信息
                        if (bean.getQyid() != null) {
                            TJcQyJbxx gyEntbaseinfo = qyxxMapper.searchById(bean.getQyid());
                            gyEntbaseinfo.setQymc(bean.getQymc());
                            gyEntbaseinfo.setShxydm(bean.getShxydm());
                            gyEntbaseinfo.setFddbr(bean.getFddbr());
                            gyEntbaseinfo.setQyzcdz(bean.getZcdz());
                            gyEntbaseinfo.setSyncZs("1");
                            qyxxMapper.updateById(gyEntbaseinfo);
                        }
                        //更新证书信息到正式表
                        zsLsMapper.deleteById(bean.getId());
                        BeanUtils.copyProperties(bean, zs);
                        zs.setZt(Constants.CARD_STATUS_VALID);
                        zsMapper.insert(zs);
                        transferLsToZs(id, zs.getZslx());
                    }
                    //更新操作记录到正式表
                    czjlLsMapper.deleteById(czjlLs.getId());
                    czjl = new TYwZsCzjl();
                    BeanUtils.copyProperties(czjlLs, czjl);
                    czjl.setClsj(DateUtils.getNowDate());
                    czjl.setClrid(user.getUserId());
                    czjl.setClrxm(user.getUserName());
                    czjl.setZt(1);//已盖章
                    czjl.setQzid(keySn);
                    czjl.setQzmc(signatureName);
                    czjlMapper.insert(czjl);
                } else if (Constants.CZJL_YWLB_QXGZ.equals(status)) {
                    //取消盖章
                    //关联到上一条有效历史记录
                    List<TYwZsCzjl> oldList = czjlMapper.selectList(Wrappers.<TYwZsCzjl>lambdaQuery()
                            .eq(TYwZsCzjl::getZsid, id)
                            .in(TYwZsCzjl::getYwlx, Constants.CZJL_YWLB_NEW, Constants.CZJL_YWLB_REPEAT, Constants.CZJL_YWLB_CHANGE, Constants.CZJL_YWLB_ADD, Constants.XZSP_SERVICETYPE_QZWH)
                            .orderByDesc(TYwZsCzjl::getCzsj));
                    if (!oldList.isEmpty()) {
                        czjl = oldList.get(0);
                    }
                    //更新操作记录到正式表
                    czjlLsMapper.deleteById(czjlLs.getId());
                    TYwZsCzjl newczjl = new TYwZsCzjl();
                    BeanUtils.copyProperties(czjlLs, newczjl);
                    newczjl.setClsj(DateUtils.getNowDate());
                    newczjl.setClrid(user.getUserId());
                    newczjl.setClrxm(user.getUserName());
                    newczjl.setZt(1);//已盖章
                    newczjl.setQzid(keySn);
                    newczjl.setQzmc(signatureName);
                    czjlMapper.insert(newczjl);
                }
                listRs.add(czjl);
                //return czjl;
            }
        }
        TYwZsCzjl rs = listRs.stream().max(Comparator.comparing(TYwZsCzjl::getCzsj)).get();
        return rs;
    }
*/
    /**
     * 将子表临时表的数据转移到正式表
     *
     * @param id
     * @param zslx
     */
/*    public void transferLsToZs(String id, Integer zslx) {
        *//*药品生产 子表逻辑和其他表不一样*//*
        if (zslx != null && zslx == 6) {
            List<TJcZsYpscxkZc> zcList = zsMapper.searchCardprintYPSCZC(id);
            zcList.forEach(temp -> {
                if (temp.getZt().equals("7")) {
                    temp.setZt("1");
                    temp.setGzrq(DateUtils.getNowDate());
                    ypsczcMapper.updateById(temp);
                }
            });
            List<TJcZsYpscxkWt> wtList = zsMapper.searchCardprintYPSCWT(id);
            wtList.forEach(temp -> {
                if (temp.getZt().equals("7")) {
                    temp.setZt("1");
                    temp.setGzrq(DateUtils.getNowDate());
                    ypscwtMapper.updateById(temp);
                }
            });
            List<TJcZsYpscxkSt> stList = zsMapper.searchCardprintYPSCST(id);
            stList.forEach(temp -> {
                if (temp.getZt().equals("7")) {
                    temp.setZt("1");
                    temp.setGzrq(DateUtils.getNowDate());
                    ypscstMapper.updateById(temp);
                }
            });
        }
        //委托器械生产备案产品明细905
        if (zslx != null && zslx == 31) {
            List<TJcZsYlqxwtscbaZbLs> wtqxscbaDetails = zsMapper.serarchCardprintWtqxscbaLs(id);
            wtqxscbaDetails.forEach(temp -> {
                TJcZsYlqxwtscbaZb newBean = new TJcZsYlqxwtscbaZb();
                BeanUtils.copyProperties(temp, newBean);
                ylqxwtscbaZbLsMapper.deleteById(temp.getId());
                ylqxwtscbaZbMapper.insert(newBean);
            });
        }
        //第一类医疗器械生产备案凭证930
        if (zslx != null && zslx == 46) {
            List<TJcZsDylylqxscbapzZbLs> ylqxscbzList = zsMapper.searchCardprintDylylqxscbapzZbLs(id);
            ylqxscbzList.forEach(temp -> {
                TJcZsDylylqxscbapzZb newBean = new TJcZsDylylqxscbapzZb();
                BeanUtils.copyProperties(temp, newBean);
                dylylqxscbapzZbLsMapper.deleteById(temp.getId());
                dylylqxscbapzZbMapper.insert(newBean);
            });
        }
        //第一类医疗器械生产委托备案931
        if (zslx != null && zslx == 47) {
            List<TJcZsDylylqxscwtbaZbLs> ylqxscwtbaList = zsMapper.searchCardprintDylylqxscwtbaZbLs(id);
            ylqxscwtbaList.forEach(temp -> {
                TJcZsDylylqxscwtbaZb newBean = new TJcZsDylylqxscwtbaZb();
                BeanUtils.copyProperties(temp, newBean);
                dylylqxscwtbaZbLsMapper.deleteById(temp.getId());
                dylylqxscwtbaZbMapper.insert(newBean);
            });
        }
        //非药品生产企业、科研和教学单位所需麻醉药品、精神药品购用证明932
        if (zslx != null && zslx == 48) {
            List<TJcZsMzypjsypgyzmZbLs> mzypjsypgyList = zsMapper.searchCardprintMzypjsypgyzmZbLs(id);
            mzypjsypgyList.forEach(temp -> {
                TJcZsMzypjsypgyzmZb newBean = new TJcZsMzypjsypgyzmZb();
                BeanUtils.copyProperties(temp, newBean);
                mzypjsypgyzmZbLsMapper.deleteById(temp.getId());
                mzypjsypgyzmZbMapper.insert(newBean);
            });
        }
        //特殊药品名称购用证明子表933
        if (zslx != null && zslx == 49) {
            List<TJcZsTsypmcgyzmZbLs> tsypmcgyzmList = zsMapper.searchCardprintTsypmcgyzmZbLs(id);
            tsypmcgyzmList.forEach(temp -> {
                TJcZsTsypmcgyzmZb newBean = new TJcZsTsypmcgyzmZb();
                BeanUtils.copyProperties(temp, newBean);
                tsypmcgyzmZbLsMapper.deleteById(temp.getId());
                tsypmcgyzmZbMapper.insert(newBean);
            });
        }
        //器械生产备案产品明细09
        if (zslx != null && zslx == 8) {
            List<TJcZsYlqxscbaZbLs> qxscbaDetails = zsMapper.serarchCardprintQxscbaLs(id);
            qxscbaDetails.forEach(temp -> {
                TJcZsYlqxscbaZb newBean = new TJcZsYlqxscbaZb();
                BeanUtils.copyProperties(temp, newBean);
                ylqxscbaLsMapper.deleteById(temp.getId());
                ylqxscbaMapper.insert(newBean);
            });
        }
        //麻醉药品和精神药品定点生产批件子表922
        if (zslx != null && zslx == 45) {
            List<TJcZsMzyphjsypddscpjZbLs> MzyphjsypddscpjList = zsMapper.searchCardprintMzyphjsypddscpjZbLs(id);
            MzyphjsypddscpjList.forEach(temp -> {
                TJcZsMzyphjsypddscpjZb newBean = new TJcZsMzyphjsypddscpjZb();
                BeanUtils.copyProperties(temp, newBean);
                mzyphjsypddscpjLsMapper.deleteById(temp.getId());
                mzyphjsypddscpjMapper.insert(newBean);
            });
        }
        //器械临床试验备案表子表子表947
        if (zslx != null && zslx == 63) {
            List<TJcZsYlqxlcsybaZbLs> ylqxlcsyba = zsMapper.searchCardprintTJcZsYlqxlcsybzZbLs(id, "1");
            ylqxlcsyba.forEach(temp -> {
                TJcZsYlqxlcsybaZb newBean = new TJcZsYlqxlcsybaZb();
                BeanUtils.copyProperties(temp, newBean);
                ylqxlcsybaZbLsMapper.deleteById(temp.getId());
                ylqxlcsybaZbMapper.insert(newBean);
            });
            //器械临床试验备案表子表子表947
            List<TJcZsYlqxlcsybaZbLs> ylqxlcsyba1 = zsMapper.searchCardprintTJcZsYlqxlcsybzZbLs(id, "2");
            ylqxlcsyba1.forEach(temp -> {
                TJcZsYlqxlcsybaZb newBean = new TJcZsYlqxlcsybaZb();
                BeanUtils.copyProperties(temp, newBean);
                ylqxlcsybaZbLsMapper.deleteById(temp.getId());
                ylqxlcsybaZbMapper.insert(newBean);
            });
        }
        //药品出口准许证子表936
        if (zslx != null && zslx == 52) {
            List<TJcZsYpckzxzZbLs> ypckzxz = zsMapper.searchCardprintTJcZsYpckzxzZbLs(id);
            ypckzxz.forEach(temp -> {
                TJcZsYpckzxzZb newBean = new TJcZsYpckzxzZb();
                BeanUtils.copyProperties(temp, newBean);
                ypckzxzZbLsMapper.deleteById(temp.getId());
                ypckzxzZbMapper.insert(newBean);
            });
        }
        //药品出口销售证明949 954 955
        if (zslx != null && (zslx == 65 || zslx == 70 || zslx == 71)) {
            List<TJcZsYpckxszmZbLs> ypckxszm = zsMapper.searchCardprintTJcZsYpckxszmZbLs(id);
            ypckxszm.forEach(temp -> {
                TJcZsYpckxszmZb newBean = new TJcZsYpckxszmZb();
                BeanUtils.copyProperties(temp, newBean);
                ypckxszmZbLsMapper.deleteById(temp.getId());
                ypckxszmZbMapper.insert(newBean);
            });
        }
        //出口欧盟原料药子表950
        if (zslx != null && zslx == 66) {
            List<TJcZsCkomylyZbLs> ckomyly = zsMapper.searchCardprintTJcZsCkomylyZbLs(id);
            ckomyly.forEach(temp -> {
                TJcZsCkomylyZb newBean = new TJcZsCkomylyZb();
                BeanUtils.copyProperties(temp, newBean);
                ckomylyZbLsMapper.deleteById(temp.getId());
                ckomylyZbMapper.insert(newBean);
            });
        }
        //医疗器械产品出口销售证明957
        if (zslx != null && zslx == 73) {
            List<TJcZsYlqxcpckxszmZbLs> ylqxcpckxszm = zsMapper.searchCardprintYlqxcpckxszmZbLs(id);
            ylqxcpckxszm.forEach(temp -> {
                TJcZsYlqxcpckxszmZb newBean = new TJcZsYlqxcpckxszmZb();
                BeanUtils.copyProperties(temp, newBean);
                ylqxcpckxszmZbLsMapper.deleteById(temp.getId());
                ylqxcpckxszmZbMapper.insert(newBean);
            });
        }
    }

 */

    /**
     * 将变更和延续对子表的变更应用到正式表
     *
     * @param      证书ID
     * @param  操作记录ID
     * @param    证书类型
     * @param    转移到明细正式表的结果集
     */
   /* public void updateChildInfo(String id, String operId, Integer zslx, List<TYwZsCzjlmx> mxRs) {
        //获取该操作记录对应的所有明细
        List<TYwZsCzjlmxLs> mxList = mxLsMapper.selectList(Wrappers.<TYwZsCzjlmxLs>lambdaQuery()
                .eq(TYwZsCzjlmxLs::getZsczjlid, operId)
                .notIn(TYwZsCzjlmxLs::getBm, "T_YW_ZS", "T_YW_ZS_LS"));
        List<TYwZsCzjlmxLs> addList = mxList.stream().filter(map -> map.getZt()
                .equals(Constants.CZJL_ZBCZ_ADD)).collect(Collectors.toList());
        addList.forEach(temp -> {
            //将子表临时表数据拉到正式表
            transferLsToZs(id, zslx);
            //主证变更时 子表的新增有明细 所以需要迁移到正式表
            mxLsMapper.deleteById(temp.getId());
            TYwZsCzjlmx rs = new TYwZsCzjlmx();
            BeanUtils.copyProperties(temp, rs);
            mxRs.add(rs);
        });
        mxList.removeAll(addList);
        if (!mxList.isEmpty()) {
            for (int i = 0; i < mxList.size(); i++) {
                TYwZsCzjlmxLs mx = mxList.get(i);
                Integer zt = mx.getZt();
                String bm = mx.getBm();
                String zbid = mx.getJlid();
                if (zt.equals(Constants.CZJL_ZBCZ_UPDATE)) {
                    if (bm.contains("YPSCXK")) {
                        //药品生产子表的更新和其他子表不一样
                        if (bm.contains("ZC")) {//自产
                            TJcZsYpscxkZc zc = ypsczcMapper.selectById(zbid);
                            zc.setZt("1");
                            zc.setGzrq(DateUtils.getNowDate());
                            ypsczcMapper.updateById(zc);
                            TJcZsYpscxkZc bgq = ypsczcMapper.selectById(zc.getBgqid());
                            bgq.setZt("0");//变更前状态设为无效
                            ypsczcMapper.updateById(bgq);
                        } else if (bm.contains("WT")) {//委托
                            TJcZsYpscxkWt wt = ypscwtMapper.selectById(zbid);
                            wt.setZt("1");
                            wt.setGzrq(DateUtils.getNowDate());
                            ypscwtMapper.updateById(wt);
                            TJcZsYpscxkWt bgq = ypscwtMapper.selectById(wt.getBgqid());
                            bgq.setZt("0");//变更前状态设为无效
                            ypscwtMapper.updateById(bgq);
                        } else if (bm.contains("ST")) {//受托
                            TJcZsYpscxkSt st = ypscstMapper.selectById(zbid);
                            st.setZt("1");
                            st.setGzrq(DateUtils.getNowDate());
                            ypscstMapper.updateById(st);
                            TJcZsYpscxkSt bgq = ypscstMapper.selectById(st.getBgqid());
                            bgq.setZt("0");//变更前状态设为无效
                            ypscstMapper.updateById(bgq);
                        }
                    } else {
                        String zdmc = JavaReflect.getFristStrUp(mx.getZdmc());
                        String xz = mx.getXz();
                        xz = StringUtils.isEmpty(xz) ? "" : xz;
                        Date date = null;
                        try {
                            date = DateUtils.dateTime("yyyy-MM-dd", xz);
                            zsGzMapper.updateChild(bm, zbid, zdmc, date);
                        } catch (Exception e) {
                            zsGzMapper.updateChild(bm, zbid, zdmc, xz);
                        }
                    }
                } else if (zt.equals(Constants.CZJL_ZBCZ_REMOVE)) {
                    if (bm.contains("YPSCXK")) {
                        zsGzMapper.softRemoveYpsc(bm, zbid);
                    } else {
                        zsGzMapper.softRemove(bm, zbid);
                    }
                }
                // 证书主表明细更新到正式表 逐条从临时表删除
                mxLsMapper.deleteById(mx.getId());
                TYwZsCzjlmx rs = new TYwZsCzjlmx();
                BeanUtils.copyProperties(mx, rs);
                mxRs.add(rs);
            }
        }

    }

    public void updateYpscZb(String id) {
        //药品生产自产 如果查到子表 根据状态修改
        List<TJcZsYpscxkZc> zcList = zsMapper.searchCardprintYPSCZC(id);
        if (!zcList.isEmpty()) {
            zcList.forEach(temp -> {
                temp.setGzrq(DateUtils.getNowDate());
                if (temp.getZt().equals("7") || temp.getZt().equals("3")) {
                    temp.setZt("1");
                } else if (temp.getZt().equals("2") || temp.getZt().equals("4")) {
                    temp.setZt("0");
                }
                ypsczcMapper.updateById(temp);
            });
        }
    }

    public void transferLsById(String target, String id) {
        zsGzMapper.insertFromSelect(target + "_LS", target, id);
        zsGzMapper.deleteByZbId(target + "_LS", id);
    }


    public void invalidPdf(String id) {
        LambdaQueryWrapper<TYwZsPdf> wrapper = Wrappers.<TYwZsPdf>lambdaQuery();
        wrapper = wrapper.eq(TYwZsPdf::getZsid, id);
        wrapper.and(temp -> temp.eq(TYwZsPdf::getZt, "0").or().isNull(TYwZsPdf::getZt));
        List<TYwZsPdf> pdfList = pdfMapper.selectList(wrapper);
        if (pdfList.size() > 0) {
            for (TYwZsPdf zsPdf : pdfList) {
                zsPdf.setZt("2");// 置为无效
                pdfMapper.updateById(zsPdf);
            }
        }
    }
*/
    //替换特殊字符
    private void replaceSpChar(ZsDto zsDto) {
        try {
            //通过getDeclaredFields()方法获取对象类中的所有属性（含私有）
            //注:获取的是父类即TYwZs的属性和方法
            Field[] fields = zsDto.getClass().getSuperclass().getDeclaredFields();
            for (Field field : fields) {
                String name = field.getName(); // 获取属性的名字
                name = name.substring(0, 1).toUpperCase() + name.substring(1); // 将属性的首字符大写，方便构造get，set方法
                String type = field.getGenericType().toString(); // 获取属性的类型
                if ("class java.lang.String".equals(type)) { // 如果type是类类型，则前面包含"class "，后面跟类名
                    Method m = zsDto.getClass().getMethod("get" + name);
                    String value = (String) m.invoke(zsDto); // 调用getter方法获取属性值
                    if (value != null) {
                        if (value.contains("&")) {
                            value = value.replace("&", "&amp;");
                        }
                        if (value.contains("%")) {
                            value = value.replace("%", "％");
                        }
                        m = zsDto.getClass().getMethod("set" + name, String.class);
                        m.invoke(zsDto, value);
                    }
                }
            }
        } catch (Exception ex) {
            logger.error("替换特殊字符失败:{}", ex.getMessage());
        }
    }


   /* @Override
    public List<TYwZs> selectZsGzExcelList() {
        return zsGzMapper.selectZsGzExcelList();
    }


    @Override
    public void batchGzExcel(List<String> ids, String signatureName, String keySn) throws Exception {
        Map<String, String> fjmap = null;//附件材料
        SysUser user = ShiroUtils.getSysUser();
        String dateStr = DateUtils.parseDateToStr("yyyyMMdd", new Date());
        String timeStr = DateUtils.parseDateToStr("yyyyMMddHHmmss", new Date());
        final String contextDir = RuoYiConfig.getPdfFloder();
        String pdfFolder = RuoYiConfig.getPdfFloder();// pdf文件的目录
        // pdf文件的目录
        Map<String, String> mbzjMap = new HashMap<String, String>();
        for (int i = 0; i < ids.size(); i++) {
            TYwZs zs = zsMapper.selectZsById(ids.get(i));
            if (zs == null) {
                throw new BusinessException("证书查询失败!");
            }
            int zslx = zs.getZslx();
            String id = zs.getId();
            //无效之前生成的PDF
            invalidPdf(id);
            ZsDto zsDto = new ZsDto();
            //封装新的数据填充属性
            BeanUtils.copyProperties(zs, zsDto);
            //将操作记录和明细查询出来set进证书属性里
            List<CzjlVo> opers = zsMapper.selectOperLs(id);
            List<CzjlVo> operZs = zsMapper.selectOperZs(id);
            //该证书的所有操作记录
            opers.addAll(operZs);
            opers = ZsUtils.getOperAfterLastYx(opers, true);
            //改回正序.因为要按顺序setmodifyinfo属性
            opers.sort(Comparator.comparing(TYwZsCzjl::getCzsj));
            //只查询变更的操作记录 延续修改:只查询上次延续之后的变更信息
            if (!opers.isEmpty()) {
                List<Map<String, Object>> modifyinfoList = new ArrayList<>();
                for (int j = 0; j < opers.size(); j++) {
                    CzjlVo vo = opers.get(j);
                    Date czsj = vo.getCzsj();
                    String value = modifyInfo.getModifyInfo(vo.getMxlist());
                    //修改为按变更记录数动态生成变更页
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("Modifyinfo", String.valueOf(value));
                    map.put("Modifytime", czsj);
                    modifyinfoList.add(map);
                    *//*JavaReflect.setter(zsDto, "Modifyinfo" + String.valueOf(j + 1), value, String.class);
                    JavaReflect.setter(zsDto, "Modifytime" + String.valueOf(j + 1), czsj, Date.class);*//*
                }
                zsDto.setModifyinfoList(modifyinfoList);
            }
            // 更新证书信息
            TYwZsCzjl operate = updateCardprintInfo(user, id, keySn, signatureName);
            //将更新后的证书信息写入证面
            zs = zsMapper.selectZsById(id);
            BeanUtils.copyProperties(zs, zsDto);
            if (operate == null) {
                throw new BusinessException("操作记录查询失败!");
            }
            String operateId = "";
            operateId = operate.getId();
            Calendar cal = Calendar.getInstance();
            String year = "";
            String month = "";
            String day = "";
            Date fzrq = zs.getFzrq();//发证日期
            Date yxqq = zs.getYxqq();//有效期起
            Date yxqz = zs.getYxqz();//有效期止
            if (null != fzrq) {
                cal.setTime(fzrq);
                year = String.valueOf(cal.get(Calendar.YEAR));
                month = cal.get(Calendar.MONTH) + 1 + "";
                day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
                zsDto.setFzrq_y(year);
                zsDto.setFzrq_m(month);
                zsDto.setFzrq_d(day);
            }
            if (null != yxqq) {
                cal.setTime(yxqq);
                year = String.valueOf(cal.get(Calendar.YEAR));
                month = cal.get(Calendar.MONTH) + 1 + "";
                day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
                zsDto.setYxqq_y(year);
                zsDto.setYxqq_m(month);
                zsDto.setYxqq_d(day);
            }
            if (null != yxqz) {
                cal.setTime(yxqz);
                year = String.valueOf(cal.get(Calendar.YEAR));
                month = cal.get(Calendar.MONTH) + 1 + "";
                day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
                zsDto.setYxqz_y(year);
                zsDto.setYxqz_m(month);
                zsDto.setYxqz_d(day);
            }
            //查询证书盖章模板
            Wrapper<TYwZsMm> queryMm = Wrappers.<TYwZsMm>lambdaQuery()
                    .eq(TYwZsMm::getZslx, zslx)
                    .orderByAsc(TYwZsMm::getPxm, TYwZsMm::getMblx);
            List<TYwZsMm> templates = zsmbMapper.selectList(queryMm);
            if (templates.isEmpty()) {
                throw new BusinessException("证书类型为" + zslx + "的模板不存在");
            }
            TJcQyJbxx ent = qyxxMapper.searchById(zs.getQyid());
            Integer adCode = XzqhUtils.getPdfXzqh(ent.getXzqh());
            File zsPdfDir = new File(pdfFolder);
            if (!zsPdfDir.exists()) {
                zsPdfDir.mkdirs();
            }
            List<TYwZsMm> dyTemplateList = new ArrayList<TYwZsMm>();
            List<TYwZsMm> tdTemplateList = new ArrayList<TYwZsMm>();
            int idx = 0;
            for (int j = 0; j < templates.size(); j++) {
                TYwZsMm tmpTemp = templates.get(j);
                List<TJcFj> attachList = fjMapper.selectList(Wrappers.<TJcFj>lambdaQuery().eq(TJcFj::getFjid, tmpTemp.getId()));
                TJcFj fj = new TJcFj();
                if (attachList.size() > 0) {
                    fj = attachList.get(0);
                    tmpTemp.setAttachUrl(fj.getFjlj());
                }
                if (tmpTemp.getMblx().equals(3)) {// 打印模板
                    String pdfDir = pdfFolder + "/" + adCode.toString() + "/dy/" + dateStr;
                    File pdfDirFile = new File(pdfDir);
                    if (!pdfDirFile.exists()) {
                        pdfDirFile.mkdirs();
                    }
                    //药品广告和医疗器械广告增加附件
                    String fjpath = RuoYiConfig.getProfile();
                    if (zslx == 68 || zslx == 69 || zslx == 3 || zslx == 26) {
                        String type = (zslx == 3 || zslx == 26) ? "zcfj" : "ggfj";
                        Wrapper<TJcFj> query = Wrappers.<TJcFj>lambdaQuery()
                                .eq(TJcFj::getFjid, id)
                                .eq(TJcFj::getLx, type);
                        List<TJcFj> fjlist = fjMapper.selectList(query);
                        if (null != fjlist && !fjlist.isEmpty()) {
                            fjmap = new HashMap<String, String>();//附件材料
                            for (int k = 0; k < fjlist.size(); k++) {
                                TJcFj attach = fjlist.get(k);
                                fjmap.put(attach.getFjmc(), fjpath + File.separator + attach.getFjlj());
                            }
                        }
                    }

                    //region 生成正本PDF和盖章后的PDF
                    *//*String pdfZbPath = pdfDir + "/" + id + "_"
                            + timeStr + "_" + (j + 1) + "_temp.pdf";
                    //final List<TYwZsZsy> cardrecordlist = getRecordList(false, zslx); 事务标记
                    List<TYwZsZsy> cardrecordlist = getRecordList(false, zslx);
                    String pdfZbTemplatePath = contextDir + "/"
                            + fj.getFjlj();
                    createPdfByTemplate(zsDto, cardrecordlist,
                            pdfZbTemplatePath, pdfZbPath);
                    String fileName = addSign(pdfZbPath, tmpTemp.getGzwz(),
                            signatureName, keySn, zsDto, fjmap); // 打印模板pdf
                    //pdfZbPath生成pdf文件全路径
                    String path = "dy/" + dateStr + "/" + fileName + ".pdf";*//*
                    //endregion

                    //region new 生成正本OFD和盖章后的OFD
                    String ofdZbPath = pdfDir + "/" + id + "_"
                            + timeStr + "_" + (j + 1) + "_temp.ofd";
                    //final List<TYwZsZsy> cardrecordlist = getRecordList(false, zslx); 事务标记
                    List<TYwZsZsy> cardrecordlist = getRecordList(false, zslx);
                    String pdfZbTemplatePath = contextDir + "/"
                            + fj.getFjlj();
                    createOfdByTemplate(zsDto, cardrecordlist,
                            pdfZbTemplatePath, ofdZbPath);
                    //String fileName = id + "_" + timeStr + "_" + (j + 1);
                    String fileName = addSignOfd(ofdZbPath, tmpTemp.getGzwz(),
                            signatureName, keySn, zsDto, fjmap); // 打印模板odf temp要转成正式
                    //pdfZbPath生成pdf文件全路径
                    String path = "dy/" + dateStr + "/" + fileName + ".ofd";
                    //endregion

                    //保存PDF信息
                    TYwZsPdf zsPdf = new TYwZsPdf();
                    zsPdf.setCjsj(new Date());
                    zsPdf.setMc(tmpTemp.getMbmc());
                    zsPdf.setXzqh(adCode);
                    zsPdf.setLj(path);
                    zsPdf.setSfdsy(1);// 带水印
                    zsPdf.setPx(++idx);
                    zsPdf.setZsid(id);
                    zsPdf.setMbid(tmpTemp.getId());
                    zsPdf.setUserid(user.getUserId());
                    zsPdf.setUsermc(user.getUserName());
                    zsPdf.setZzlx(tmpTemp.getZzlx());
                    zsPdf.setGzwz(tmpTemp.getGzwz());
                    zsPdf.setZt("0");
                    zsPdf.setCzjlid(operateId);
                    pdfMapper.insert(zsPdf);
                    mbzjMap.put(zsPdf.getMc(), zsPdf.getId());

                } else if (tmpTemp.getMblx().equals(5)) {
                    String pdfDir = pdfFolder + "/" + adCode + "/dy/" + dateStr;
                    File pdfDirFile = new File(pdfDir);
                    if (!pdfDirFile.exists()) {
                        pdfDirFile.mkdirs();
                    }
                    String fyPdfPath = pdfDir + "/" + id + "_"
                            + timeStr + "_fy_temp.pdf";

                    String fyPdfTdPath = pdfDir + "/" + id
                            + "_" + timeStr + "_fy_td_temp.pdf";
                    if (tmpTemp.getZslx().equals(8)) {
                        List<TJcZsYlqxscbaZb> qxsclist = zsMapper.serarchCardprintQxscba(id);
                        if (qxsclist.size() > 0) {
                            for (int k = 0; k < qxsclist.size(); k++) {
                                TJcZsYlqxscbaZb bean = qxsclist.get(k);
                                cal.setTime((Date) bean.getDzrq());
                                String year1 = String.valueOf(cal.get(Calendar.YEAR));
                                String month1 = cal.get(Calendar.MONTH) + 1 + "";
                                String day1 = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
                                bean.setDzrq_y(year1);
                                bean.setDzrq_m(month1);
                                bean.setDzrq_d(day1);
                            }
                            zsDto.setQxsclist(qxsclist);
                        }
                    }
                    if (tmpTemp.getZslx().equals(6)) {
                        List<TJcZsYpscxkWt> fylist = zsMapper.searchCardprintYPSCfy1(id);
                        List<TJcZsYpscxkWt> listlen = zsMapper.searchCardprintYPSCfy1len(id);
                        if (null != fylist && fylist.size() > 0) {
                            for (int q = 0; q < fylist.size(); q++) {
                                TJcZsYpscxkWt bean = fylist.get(q);
                                String addr1 = bean.getRefcompaddr();//注册地址
                                if (null != listlen && listlen.size() > 0) {
                                    for (int k = 0; k < listlen.size(); k++) {
                                        TJcZsYpscxkWt lenbean = listlen.get(k);
                                        String addr = lenbean.getRefcompaddr();
                                        String len = lenbean.getLen();
                                        if (addr1.equals(addr)) {
                                            bean.setLen(len);
                                        }
                                    }
                                }
                            }
                            zsDto.setYpscfy1(fylist);
                        }
                        List<TJcZsYpscxkWt> fylist1 = zsMapper.searchCardprintYPSCfy2(id);
                        if (null != fylist1 && fylist1.size() > 0) {
                            for (int k = 0; k < fylist1.size(); k++) {
                                TJcZsYpscxkWt bean = fylist1.get(k);
                                //处理附页的委托有效期
                                Date entrustvalidate = bean.getEntrustvalidate();
                                bean.setWtyxq(DateUtils.parseDateToStr("yyyy-MM-dd", entrustvalidate));
                                String type = bean.getProtype();
                                if (StringUtils.isNotEmpty(type)) {
                                    type = type.substring(1, type.length());
                                    bean.setProtype(type);
                                }
                            }
                            zsDto.setYpscfy2(fylist1);
                        }
                    }
                    String fyTemplate = XmlUtil.createFyXML(zsDto,
                            contextDir + "/"
                                    + tmpTemp.getAttachUrl());
                    //套打注释
                    PdfUtil.createFyPdf(fyTemplate, fyPdfTdPath);
                    if (tmpTemp.getZslx().equals(103) && tmpTemp.getBjbs().equals(1)) {
                        //新的里面没有103
                        PdfUtil.addWatermark(fyPdfTdPath, fyPdfPath, contextDir + "/fysy.jpg");
                    } else if (tmpTemp.getZslx().equals(6) && tmpTemp.getBjbs().equals(1)) {
                        PdfUtil.addWatermark(fyPdfTdPath, fyPdfPath, contextDir + "/ypscfy.jpg");
                    } else {
                        PdfUtil.createFyPdf(fyTemplate, fyPdfPath);
                    }
                    //PdfUtil.createFyPdf(fyTemplate, fyPdfPath);
                    //String fyFileName = addSign(fyPdfPath, tmpTemp.getGzwz(),
                    //        signatureName, keySn, zsDto, fjmap);// 副页盖章
                    String fyFileName = addSignFy1(fyPdfPath, tmpTemp.getGzwz(),
                            signatureName, keySn, zsDto, fjmap, zsDto);// 副页盖章 PDF转OFD再盖
                    String fyPath = "dy/" + dateStr + "/" + fyFileName + ".ofd";
                    TYwZsPdf zsPdf = new TYwZsPdf();
                    zsPdf.setCjsj(new Date());
                    zsPdf.setMc(tmpTemp.getMbmc());
                    zsPdf.setXzqh(adCode);
                    zsPdf.setLj(fyPath);
                    zsPdf.setSfdsy(1);// 带水印
                    zsPdf.setPx(++idx);
                    zsPdf.setMbid(tmpTemp.getId());
                    zsPdf.setZsid(id);
                    zsPdf.setUserid(user.getUserId());
                    zsPdf.setUsermc(user.getUserName());
                    zsPdf.setZzlx(tmpTemp.getZzlx());
                    zsPdf.setGzwz(tmpTemp.getGzwz());
                    zsPdf.setZt("0");
                    zsPdf.setCzjlid(operateId);
                    pdfMapper.insert(zsPdf);
                    //副页套打注释
                    File sourceFile = new File(fyPdfTdPath);
                    if (sourceFile.exists()) {
                        sourceFile.delete();
                    }
                } else if (tmpTemp.getMblx().equals(6)) {// 变更打印模板
                    dyTemplateList.add(tmpTemp);
                } else if (tmpTemp.getMblx().equals(8)) {//批件打印模板 A4纸 //
                    String pdfDir = pdfFolder + "/" + adCode + "/dy/" + dateStr;
                    File pdfDirFile = new File(pdfDir);
                    if (!pdfDirFile.exists()) {
                        pdfDirFile.mkdirs();
                    }
                    String pdfZbPath = pdfDir + "/" + id + "_"
                            + timeStr + "_" + (j + 1) + "_temp.pdf";
                    if (StringUtils.isNotEmpty(zsDto.getFlm()) && zsDto.getFlm().contains("®")) {
                        zsDto.setFlm(zsDto.getFlm().replace("®", "&reg;"));
                    }
                    if (tmpTemp.getZslx().equals(46)) {
                        final List<TJcZsDylylqxscbapzZb> ylqxscbaDetails = zsMapper.searchCardprintDylylqxscbapzZb(id);
                        if (ylqxscbaDetails.size() > 0) {
                            for (int m = 0; m < ylqxscbaDetails.size(); m++) {
                                TJcZsDylylqxscbapzZb newbean = (TJcZsDylylqxscbapzZb) ylqxscbaDetails.get(m);
                                if (newbean.getCpmc().contains("&")) {
                                    newbean.setCpmc(newbean.getCpmc().replace("&", "&amp;"));
                                }
                            }
                            zsDto.setYlqxscbaList(ylqxscbaDetails);
                        }
                    } else if (tmpTemp.getZslx().equals(47)) {
                        final List<TJcZsDylylqxscwtbaZb> ylqxscwtbaDetails = zsMapper.searchCardprintDylylqxscwtbaZb(id);
                        if (ylqxscwtbaDetails.size() > 0) {
                            for (int m = 0; m < ylqxscwtbaDetails.size(); m++) {
                                TJcZsDylylqxscwtbaZb newbean = (TJcZsDylylqxscwtbaZb) ylqxscwtbaDetails.get(m);
                                if (newbean.getCpmc().contains("&")) {
                                    newbean.setCpmc(newbean.getCpmc().replace("&", "&amp;"));
                                }
                            }
                            zsDto.setYlqxscwtbaList(ylqxscwtbaDetails);
                        }
                    } else if (tmpTemp.getZslx().equals(48)) {
                        final List<TJcZsMzypjsypgyzmZb> mzypjsypgyDetails = zsMapper.searchCardprintMzypjsypgyzmZb(id);
                        if (mzypjsypgyDetails.size() > 0) {
                            for (int m = 0; m < mzypjsypgyDetails.size(); m++) {
                                TJcZsMzypjsypgyzmZb newbean = (TJcZsMzypjsypgyzmZb) mzypjsypgyDetails.get(m);
                                if (newbean.getPm().contains("&")) {
                                    newbean.setPm(newbean.getPm().replace("&", "&amp;"));
                                }
                            }
                            zsDto.setMzypjsypgyList(mzypjsypgyDetails);
                        }
                    } else if (tmpTemp.getZslx().equals(49)) {
                        final List<TJcZsTsypmcgyzmZb> tsypmcgyzmDetails = zsMapper.searchCardprintTsypmcgyzmZb(id);
                        if (tsypmcgyzmDetails.size() > 0) {
                            for (int m = 0; m < tsypmcgyzmDetails.size(); m++) {
                                TJcZsTsypmcgyzmZb newbean = (TJcZsTsypmcgyzmZb) tsypmcgyzmDetails.get(m);
                                if (newbean.getNscypmc().contains("&")) {
                                    newbean.setNscypmc(newbean.getNscypmc().replace("&", "&amp;"));
                                }
                            }
                            zsDto.setTsypmcgyzmList(tsypmcgyzmDetails);
                        }
                    } else if (tmpTemp.getZslx().equals(45)) {
                        final List<TJcZsMzyphjsypddscpjZb> mzyphjsypddscpjDetails = zsMapper.searchCardprintMzyphjsypddscpjZb(id);
                        if (mzyphjsypddscpjDetails.size() > 0) {
                            for (int m = 0; m < mzyphjsypddscpjDetails.size(); m++) {
                                TJcZsMzyphjsypddscpjZb newbean = (TJcZsMzyphjsypddscpjZb) mzyphjsypddscpjDetails.get(m);
                                if (newbean.getYpmc().contains("&")) {
                                    newbean.setYpmc(newbean.getYpmc().replace("&", "&amp;"));
                                }
                            }
                            zsDto.setMzyphjsypddscpj(mzyphjsypddscpjDetails);
                        }
                    } else if (tmpTemp.getZslx().equals(31)) {
                        final List<TJcZsYlqxwtscbaZb> gyEntcardPrintWtqxscba = zsMapper.serarchCardprintWtqxscba(id);
                        if (gyEntcardPrintWtqxscba.size() > 0) {
                            for (int m = 0; m < gyEntcardPrintWtqxscba.size(); m++) {
                                TJcZsYlqxwtscbaZb newbean = gyEntcardPrintWtqxscba.get(m);
                                if (newbean.getCpmc().contains("&")) {
                                    newbean.setCpmc(newbean.getCpmc().replace("&", "&amp;"));
                                }
                            }
                            zsDto.setWtqxsclist(gyEntcardPrintWtqxscba);
                        }
                    } else if (tmpTemp.getZslx().equals(63)) {
                        List<TJcZsYlqxlcsybaZb> ylqxlcsyba = zsMapper.searchCardprintTJcZsYlqxlcsybzZb(id, "1");
                        List<TJcZsYlqxlcsybaZb> ylqxlcsyba1 = zsMapper.searchCardprintTJcZsYlqxlcsybzZb(id, "2");
                        int len = 0;
                        int len1 = 0;
                        int size = 0;
                        if (null != ylqxlcsyba && ylqxlcsyba.size() > 0) {
                            len = ylqxlcsyba.size();
                        }
                        if (null != ylqxlcsyba1 && ylqxlcsyba1.size() > 0) {
                            len1 = ylqxlcsyba1.size();
                        }
                        TJcZsYlqxlcsybaZb tJcZsYlqxlcsybzZb = null;
                        TJcZsYlqxlcsybaZb tJcZsYlqxlcsybzZb1 = null;
                        if (len > len1) {
                            for (int k = 0; k < len - len1; k++) {
                                tJcZsYlqxlcsybzZb = new TJcZsYlqxlcsybaZb();
                                ylqxlcsyba1.add(tJcZsYlqxlcsybzZb);
                            }
                            size = len;
                        } else if (len1 > len) {
                            for (int k = 0; k < len1 - len; k++) {
                                tJcZsYlqxlcsybzZb = new TJcZsYlqxlcsybaZb();
                                ylqxlcsyba.add(tJcZsYlqxlcsybzZb);
                            }
                            size = len1;
                        } else if (len == len1) {
                            size = len;
                        }
                        if (size > 0) {
                            for (int k = 0; k < size; k++) {
                                tJcZsYlqxlcsybzZb = ylqxlcsyba.get(k);
                                tJcZsYlqxlcsybzZb1 = ylqxlcsyba1.get(k);
                                tJcZsYlqxlcsybzZb.setDh1(tJcZsYlqxlcsybzZb1.getDh());
                                tJcZsYlqxlcsybzZb.setDz1(tJcZsYlqxlcsybzZb1.getDz());
                                tJcZsYlqxlcsybzZb.setLxr1(tJcZsYlqxlcsybzZb1.getLxr());
                                tJcZsYlqxlcsybzZb.setMc1(tJcZsYlqxlcsybzZb1.getMc());
                            }
                        }
                        zsDto.setYlqxlcsyba(ylqxlcsyba);
                    } else if (tmpTemp.getZslx().equals(52)) {
                        final List<TJcZsYpckzxzZb> ypckzxzZbs = zsMapper.searchCardprintTJcZsYpckzxzZb(id);
                        if (null != ypckzxzZbs && ypckzxzZbs.size() > 0) {
                            for (int m = 0; m < ypckzxzZbs.size(); m++) {
                                TJcZsYpckzxzZb newbean = (TJcZsYpckzxzZb) ypckzxzZbs.get(m);
                                if (newbean.getCkywmc().contains("&")) {
                                    newbean.setCkywmc(newbean.getCkywmc().replace("&", "&amp;"));
                                }
                                if (zsDto.getYlzd16().contains("%")) {
                                    zsDto.setYlzd16(zsDto.getYlzd16().replace("%", "％"));
                                }
                                if (zsDto.getYlzd3().contains("&")) {
                                    zsDto.setYlzd3(zsDto.getYlzd3().replace("&", "&amp;"));
                                }
                                if (zsDto.getYlzd4().contains("&")) {
                                    zsDto.setYlzd4(zsDto.getYlzd4().replace("&", "&amp;"));
                                }
                                if (zsDto.getYlzd5().contains("&")) {
                                    zsDto.setYlzd5(zsDto.getYlzd5().replace("&", "&amp;"));
                                }
                                if (zsDto.getYlzd6().contains("&")) {
                                    zsDto.setYlzd6(zsDto.getYlzd6().replace("&", "&amp;"));
                                }
                            }
                            zsDto.setYpckzxz(ypckzxzZbs);
                        }
                    } else if (tmpTemp.getZslx().equals(65) || tmpTemp.getZslx().equals(70) || tmpTemp.getZslx().equals(71)) {
                        String ypckxszmgjzw = "";
                        String ypckxszmgjyw = "";
                        final List<TJcZsYpckxszmZb> newlist = zsMapper.searchCardprintTJcZsYpckxszmZb(id);
                        if (null != newlist && newlist.size() > 0) {
                            for (int k = 0; k < newlist.size(); k++) {
                                TJcZsYpckxszmZb bean = (TJcZsYpckxszmZb) newlist.get(k);
                                ypckxszmgjzw += bean.getJkgjzw() + ",";
                                ypckxszmgjyw += bean.getJkgjyw() + ",";
                            }
                        }
                        if (StringUtils.isNotEmpty(ypckxszmgjzw)) {
                            if (ypckxszmgjzw.contains("&")) {
                                ypckxszmgjzw = ypckxszmgjzw.replace("&", "&amp;");
                            }
                            ypckxszmgjzw = ypckxszmgjzw.substring(0, ypckxszmgjzw.length() - 1);
                            ypckxszmgjyw = ypckxszmgjyw.substring(0, ypckxszmgjyw.length() - 1);
                        }
                        zsDto.setYpckxszmgjzw(ypckxszmgjzw);
                        zsDto.setYpckxszmgjyw(ypckxszmgjyw);
                        if (zsDto.getYlzd6().contains("%")) {
                            zsDto.setYlzd6(zsDto.getYlzd6().replace("%", "％"));
                        }
                        if (zsDto.getYlzd7().contains("%")) {
                            zsDto.setYlzd7(zsDto.getYlzd7().replace("%", "％"));
                        }
                        if (zsDto.getGg().contains("%")) {
                            zsDto.setGg(zsDto.getGg().replace("%", "％"));
                        }
                        if (zsDto.getYlzd8().contains("%")) {
                            zsDto.setYlzd8(zsDto.getYlzd8().replace("%", "％"));
                        }
                        if (zsDto.getYlzd9().contains("%")) {
                            zsDto.setYlzd9(zsDto.getYlzd9().replace("%", "％"));
                        }
                        if (zsDto.getYlzd10().contains("%")) {
                            zsDto.setYlzd10(zsDto.getYlzd10().replace("%", "％"));
                        }
                    } else if (tmpTemp.getZslx().equals(66)) {
                        final List<TJcZsCkomylyZb> newlist = zsMapper.searchCardprintTJcZsCkomylyZbZs(id);
                        zsDto.setCkomyly(newlist);
                    } else if (tmpTemp.getZslx().equals(73)) {
                        final List<TJcZsYlqxcpckxszmZb> newlist = zsMapper.searchCardprintYlqxcpckxszmZbOrderByMC(id);
                        List<TJcZsYlqxcpckxszmZb> listlen = zsMapper.searchCardprintYlqxcpckxszmZb2(id);
                        if (null != newlist && newlist.size() > 0) {
                            for (int q = 0; q < newlist.size(); q++) {
                                TJcZsYlqxcpckxszmZb bean = (TJcZsYlqxcpckxszmZb) newlist.get(q);
                                String mc1 = bean.getMc();
                                String bh1 = bean.getBh();
                                String mcbh1 = mc1 + bh1;
                                if (null != listlen && listlen.size() > 0) {
                                    for (int k = 0; k < listlen.size(); k++) {
                                        TJcZsYlqxcpckxszmZb lenbean = (TJcZsYlqxcpckxszmZb) listlen.get(k);
                                        String mc = lenbean.getMc();
                                        String bh = lenbean.getBh();
                                        String len = lenbean.getLen();
                                        if (mcbh1.equals(mc + bh)) {
                                            bean.setLen(len);
                                            bean.setNum(lenbean.getNum());
                                        }
                                    }
                                }
                                if (bean.getMc().contains("%")) {
                                    bean.setMc(bean.getMc().replace("%", "％"));
                                }
                                if (bean.getMc().contains("&")) {
                                    bean.setMc(bean.getMc().replace("&", "&amp;"));
                                }
                                if (bean.getGg().contains("%")) {
                                    bean.setGg(bean.getGg().replace("%", "％"));
                                }
                                if (bean.getGg().contains("&")) {
                                    bean.setGg(bean.getGg().replace("&", "&amp;"));
                                }
                            }
                        }
                        replaceSpChar(zsDto);
                        zsDto.setYlqxcpckxszm(newlist);
                    }
                    String fyTemplate = XmlUtil.createFyXML(zsDto,
                            contextDir + "/"
                                    + tmpTemp.getAttachUrl());
                    //套打注释
                    String fyPdfTdPath = pdfDir + "/" + id + "_" + timeStr + "_" + (j + 1) + "_temp1.pdf";
                    PdfUtil.createFyPdf(fyTemplate, fyPdfTdPath);
                    //String serviceid = "";
                    if (zsDto.getZslx().equals(52)) {
                        PdfUtil.addWatermark1(fyPdfTdPath, pdfZbPath, contextDir + "/936bg.jpg");
                    } else {
                        PdfUtil.createFyPdf(fyTemplate, pdfZbPath);
                    }
                    //PdfUtil.createFyPdf(fyTemplate, pdfZbPath);
                    String pdfFileNameFy = addSignFy1(pdfZbPath,
                            tmpTemp.getGzwz(), signatureName, keySn, zsDto, fjmap, zsDto);// 副页盖章
                    String fyPath = "dy/" + dateStr + "/" + pdfFileNameFy
                            + ".ofd";
                    TYwZsPdf zsPdf = new TYwZsPdf();
                    zsPdf.setCjsj(new Date());
                    zsPdf.setMc(tmpTemp.getMbmc());
                    zsPdf.setXzqh(adCode);
                    zsPdf.setLj(fyPath);
                    zsPdf.setSfdsy(1);// 带水印
                    zsPdf.setPx(++idx);
                    zsPdf.setMbid(tmpTemp.getId());
                    zsPdf.setZsid(id);
                    zsPdf.setUserid(user.getUserId());
                    zsPdf.setUsermc(user.getUserName());
                    zsPdf.setZzlx(tmpTemp.getZzlx());
                    zsPdf.setGzwz(tmpTemp.getGzwz());
                    zsPdf.setZt("0");
                    zsPdf.setCzjlid(operateId);
                    pdfMapper.insert(zsPdf);
                    mbzjMap.put(zsPdf.getMc(), zsPdf.getId());
                } else if (tmpTemp.getMblx().equals(9)) {//材料项盖章
                    String url = RuoYiConfig.getCtzyFilePath();
                    String pdfDir = pdfFolder + "/" + adCode + "/dy/" + dateStr;
                    File pdfDirFile = new File(pdfDir);
                    if (!pdfDirFile.exists()) {
                        pdfDirFile.mkdirs();
                    }

                    String pdfZbPath = pdfDir + "/" + id + "_"
                            + timeStr + "_fy_tmp.pdf";
                    if (zslx == 75 || zslx == 76) {
                        String clxid = "";
                        if (zslx == 75) {
                            clxid = RuoYiConfig.getCtzyFileSc();
                        } else if (zslx == 76) {
                            clxid = RuoYiConfig.getCtzyFileBg();
                        }
                        //查询行政审批附件表
                        List<TJcFj> list = slaveService.selectXzspFj(clxid, id);
                        if (null != list && list.size() > 0) {
                            url = list.get(0).getFjlj();
                            //if(1==1){
                            //    url = "/ctzy/202107/18AB92FA001547B69AF5D6C93244E8BC_20210824163234.pdf";
                            FileUtils.copyFile(RuoYiConfig.getProfile() + url, pdfZbPath);
                            //OFD盖章 // TODO: 上传的文件转为OFD盖章后是否需要转回PDF
                            String pdfFileName = SignatureUtil.addSignPdf2Ofd(pdfZbPath, keySn, signatureName, tmpTemp.getGzwz());
                            String path = "dy/" + dateStr + "/" + id + "_" + timeStr + "_fy.ofd";
                            TYwZsPdf zsPdf = new TYwZsPdf();
                            zsPdf.setCjsj(new Date());
                            zsPdf.setMc(tmpTemp.getMbmc());
                            zsPdf.setXzqh(adCode);
                            zsPdf.setLj(path);
                            zsPdf.setSfdsy(1);// 带水印
                            zsPdf.setPx(++idx);
                            zsPdf.setZsid(id);
                            zsPdf.setMbid(tmpTemp.getId());
                            zsPdf.setUserid(user.getUserId());
                            zsPdf.setUsermc(user.getUserName());
                            zsPdf.setZzlx(tmpTemp.getZzlx());
                            zsPdf.setGzwz(tmpTemp.getGzwz());
                            zsPdf.setZt("0");
                            zsPdf.setCzjlid(operateId);
                            pdfMapper.insert(zsPdf);
                        }
                    }
                }
            }
            //生成变更页
            *//*createBgPdf(dyTemplateList, tdTemplateList, zsDto, pdfFolder,
                    contextDir, adCode, signatureName, keySn, idx, user,
                    operateId);*//* // 处理变更
            //生成变更页OFD
            if (zslx == 3 || zslx == 26) {
                createBgOfdSp(dyTemplateList, tdTemplateList, zsDto, pdfFolder,
                        contextDir, adCode, signatureName, keySn, idx, user,
                        operateId);
            } else {
                createBgOfdNew(dyTemplateList, tdTemplateList, zsDto, pdfFolder,
                        contextDir, adCode, signatureName, keySn, idx, user,
                        operateId);// 处理变更
            }
            //同步标 不能直接更新dto 会导致转义字符被保存
            TYwZs zs1 = zsMapper.selectById(zsDto.getId());
            zs1.setSjtbZsgs(1);
            zs1.setSjtbDa(1);
            zs1.setSjtbXzsp(1);
            zs1.setSjtbGj(1);
            zsMapper.updateById(zs1);
            //药品生产许可证盖完章需要将子表记录状态做修改
            if (zs.getZslx().equals(6)) {
                //updateypsczb(id);
            }
        }
    }*/
}
