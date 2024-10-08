package org.jeecg.modules.demo.dzzz.dataExchange.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertInfo;
import org.jeecg.modules.demo.dzzz.certtype.entity.CertType;
import org.jeecg.modules.demo.dzzz.certtype.mapper.CertTypeMapper;
import org.jeecg.modules.demo.dzzz.constant.YwConstant;
import org.jeecg.modules.demo.dzzz.dataExchange.dto.SscjDataReqDto;
import org.jeecg.modules.demo.dzzz.dataExchange.entity.TYwSjXyb;
import org.jeecg.modules.demo.dzzz.dataExchange.entity.TYwSjXybQyZz;
import org.jeecg.modules.demo.dzzz.dataExchange.exception.YwException;
import org.jeecg.modules.demo.dzzz.dataExchange.mapper.TYwSjXybMapper;
import org.jeecg.modules.demo.dzzz.dataExchange.mapper.TYwSjXybQyZzMapper;
import org.jeecg.modules.demo.dzzz.dataExchange.service.ITYwSjXybService;
import org.jeecg.modules.demo.dzzz.information.entity.Information;
import org.jeecg.modules.demo.dzzz.information.mapper.InformationMapper;
import org.jeecg.modules.demo.dzzz.util.BeanUtils;
import org.jeecg.modules.demo.dzzz.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: t_yw_sj_xyb
 * @Author: jeecg-boot
 * @Date:   2024-07-29
 * @Version: V1.0
 */
@Service
@Slf4j
public class TYwSjXybServiceImpl extends ServiceImpl<TYwSjXybMapper, TYwSjXyb> implements ITYwSjXybService {

    @Autowired
    private CertTypeMapper certTypeMapper;
    @Autowired
    private InformationMapper informationMapper;
    @Autowired
    private TYwSjXybQyZzMapper tYwSjXybQyZzMapper;

    @Override
    public void saveXyb(SscjDataReqDto dto, CertInfo certInfo) {
        try {
            // 湖北省药品监督管理局，落地信用办表
            if (null != certInfo && YwConstant.SSCJ_JG_ID.equals(certInfo.getFzjgid())) {
                // 查询证书类型
                CertType certType = certTypeMapper.selectById(certInfo.getCerttypeid());
                String certTypeName = certType.getCerttypename();
                String zszt = certInfo.getZszt();
                String shxydm = certInfo.getShxydm();

                TYwSjXyb xyb = new TYwSjXyb();
                BeanUtils.copyProperties(certInfo, xyb);
                // 基本事项编码
                if (YwConstant.FSXYPJYXKZ.equals(certTypeName) || YwConstant.FSXYPSCXKZ.equals(certTypeName)) {
                    xyb.setSxbm(YwConstant.SSCJ_SXBM.get(certTypeName + "-" + zszt));
                } else {
                    xyb.setSxbm(YwConstant.SSCJ_SXBM.get(certTypeName));
                }
                // 如果基本事项编码为空，直接跳过
                if (StringUtils.isEmpty(xyb.getSxbm())) {
                    log.info("基本事项编码为空，跳过信用办此次保存~");
                    return;
                }
                xyb.setXkxdrlb(YwConstant.SSCJ_XK_XDRLB);
                xyb.setXkwsh(certInfo.getZsbh());
                xyb.setXkxklb(YwConstant.SSCJ_XK_XKLB);
                xyb.setXkxkzs(certTypeName);
                xyb.setXkxkws(certTypeName);
                xyb.setYwlx(zszt);
                xyb.setXkxdrgszc(shxydm);
                String frdb = certInfo.getFddbr();

                // 查询企业信息
                LambdaQueryWrapper<Information> queryWrapper = new LambdaQueryWrapper<>();
                queryWrapper.eq(Information :: getEntzzjgdm, shxydm);
                Information information = informationMapper.selectList(queryWrapper).stream().findFirst().orElse(null);;
                if (null != information) {
                    xyb.setXkfrzhlx("身份证");
                    xyb.setXkfrzhhm(information.getEntby14());
                    if (StringUtils.isEmpty(frdb)) {
                        frdb = information.getCorpname();
                    }
                }
                String xknr = "";
                if (YwConstant.YLQXGZSCZYXKJDS.equals(certTypeName) || YwConstant.YPGGSCZYXKJDS.equals(certTypeName)
                        || YwConstant.DELYLQXZCZ.equals(certTypeName)) {
                    xknr = certInfo.getChanping();
                } else if (YwConstant.YLJGZJTJSYPJPF.equals(certTypeName)) {
                    xknr = certInfo.getYlzd2();
                } else if (YwConstant.FSXYPSYXKZ.equals(certTypeName)) {
                    xknr = certInfo.getYlzd6();
                } else if (YwConstant.HLWYPXXFWXZGZS.equals(certTypeName)) {
                    xknr = certInfo.getYlzd9();
                } else {
                    xknr = certInfo.getFw();
                }
                xyb.setXknr(xknr);
                xyb.setXkFrdb(frdb);
                xyb.setXkXkjg(YwConstant.SSCJ_JG_NAME);
                xyb.setXkxkjgdm(YwConstant.SSCJ_JG_DM);
                xyb.setXkLydw(xyb.getXkXkjg());
                xyb.setXkYxqz(certInfo.getYxqz());
                xyb.setXkXdrMc(certInfo.getQymc());
                xyb.setYwid(certInfo.getId());
                xyb.setDataUpStatus("1");
                xyb.setXkZt("1");
                xyb.setCreateTime(DateUtils.getTodayStr());
                xyb.setSync(null);
                this.save(xyb);

                // 保存信用办企业资质证书信息
                // TODO saveXybQyzz(xyb);

            } else if (null != dto) {
                // 地市，落地信用办表
                TYwSjXyb xyb = new TYwSjXyb();
                BeanUtils.copyProperties(dto, xyb);
                xyb.setXkFrdb(dto.getFddbr());
                xyb.setXkXkjg(dto.getFzjg());
                xyb.setXkLydw(dto.getFzjg());
                xyb.setYxqz(dto.getJzrq());
                xyb.setXkYxqz(dto.getJzrq());
                xyb.setXkXdrMc(dto.getQymc());
                xyb.setYwid(dto.getId());
                xyb.setDataUpStatus("1");
                xyb.setXkZt("1");
                xyb.setCreateTime(DateUtils.getTodayStr());
                if (YwConstant.YPJYXKZ.equals(xyb.getXkxkzs())) {
                    xyb.setSxbm(YwConstant.SSCJ_SXBM.get(YwConstant.YPJYXKZ));
                } else {
                    xyb.setSxbm(YwConstant.SSCJ_SXBM.get(YwConstant.YLQX));
                }
                this.save(xyb);

                // 保存信用办企业资质证书信息
                // TODO saveXybQyzz(xyb);
            }
        } catch (YwException e) {
            log.error("保存信用办记录出错~", e);
            throw new YwException("保存信用办记录出错~");
        }
    }

    /**
     * 保存信用办企业资质证书信息
     * @param xyb
     */
    private void saveXybQyzz(TYwSjXyb xyb) {
        TYwSjXybQyZz qyZz = new TYwSjXybQyZz();
        BeanUtils.copyProperties(xyb, qyZz);
        qyZz.setId(null);
        qyZz.setZsmc(xyb.getXkxkws());
        qyZz.setZslbdj(xyb.getXkxklb());
        qyZz.setFzjg(xyb.getXkXkjg());
        qyZz.setSjlydwmc(xyb.getXkXkjg());
        qyZz.setSjlydwdm(xyb.getXkxkjgdm());
        qyZz.setCreateTime(DateUtils.getTodayStr());
        qyZz.setXybId(xyb.getId());
        tYwSjXybQyZzMapper.insert(qyZz);
    }

}
