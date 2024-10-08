package org.jeecg.modules.demo.dzzz.certinfo.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.demo.dzzz.attachinfo.entity.Attachinfo;
import org.jeecg.modules.demo.dzzz.certWarning.dto.YxqWarnReqDto;
import org.jeecg.modules.demo.dzzz.certWarning.dto.YxqWarnResDto;
import org.jeecg.modules.demo.dzzz.certWarning.dto.WgzWarnReqDto;
import org.jeecg.modules.demo.dzzz.certWarning.dto.WgzWarnResDto;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildYpscSt;
import org.jeecg.modules.demo.dzzz.certmatadataversion.entity.CertMetadata;
import org.jeecg.modules.demo.dzzz.certmode.entity.CertMode;
import org.jeecg.modules.demo.dzzz.certtyperole.entity.CerttypeRole;
import org.jeecg.modules.demo.dzzz.certzminfo.entity.CertZminfo;
import org.jeecg.modules.demo.dzzz.wgz.entity.ZsYwxxb;

/**
 * @Description: 电子证照源数据
 * @Author: jeecg-boot
 * @Date:   2024-03-27
 * @Version: V1.0
 */
public interface CertInfoMapper extends BaseMapper<CertInfo> {

    public List<CertchildYpscSt> selectByMainId(@Param("mainId") String mainId);

    public List<CertMetadata> queryCertMetadateById(@Param("certtypeid") String certtypeid,@Param("status") String status);
    public List<CertMetadata> queryCertMetadateByIdelse(@Param("certtypeid") String certtypeid,@Param("status") String status);

    Attachinfo getAttachByCertid(@Param("id") String id,@Param("certmodetype") String certmodetype,@Param("isgz") String isgz);
    CertMode getCertModeByCertid(@Param("id") String id);
    List<CerttypeRole> getCertroles(@Param("certtypeid") String certtypeid,@Param("roleids") String roleids);
    CertZminfo getzminfodata(@Param("id") String id);
    List<ZsYwxxb> selectAll(@Param("sql1") String sql,@Param("sql2") String sql2,@Param("weiba") String weiba);
    int countselectAll(@Param("sql1") String sql,@Param("sql2") String sql2);

    CertInfo getByzsid(@Param("zsid")String zsid);

    /**
     * 查询预警的证书列表-分页
     * @param dto
     * @param page
     * @return
     */
    IPage<YxqWarnResDto> selectYxqWarningPageList(@Param("dto") YxqWarnReqDto dto, @Param("page") IPage page);

    /**
     * 查询预警的证书列表
     * @param dto
     * @return
     */
    List<YxqWarnResDto> selectYxqWarningList(@Param("dto") YxqWarnReqDto dto);

    /**
     * 查询预警的证书列表-分页
     * @param dto
     * @param page
     * @return
     */
    IPage<WgzWarnResDto> selectWgzWarningPageList(@Param("dto") WgzWarnReqDto dto, @Param("page") IPage page);

    /**
     * 查询预警的证书列表
     * @param dto
     * @return
     */
    List<WgzWarnResDto> selectWgzWarningList(@Param("dto") WgzWarnReqDto dto);

    /**
     * 查询信用办需要的数据
     * @return
     */
    List<CertInfo> xybData();

    /**
     * 审批系统用-根据参数获取附件
     * @param id
     * @return
     */
    Attachinfo getAttachByParamsForSp(@Param("id") String id);

    /**
     * 审批系统用-根据参数获取附件List
     * @param id
     * @return
     */
    List<Attachinfo> getAttachListByParamsForSp(@Param("id") String id);

}
