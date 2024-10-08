package org.jeecg.modules.demo.dzzz.wgz.service.impl;

import org.jeecg.common.util.UUIDGenerator;
import org.jeecg.modules.demo.dzzz.certinfo.entity.*;
import org.jeecg.modules.demo.dzzz.certinfo.mapper.*;
import org.jeecg.modules.demo.dzzz.certtype.service.ICertTypeService;
import org.jeecg.modules.demo.dzzz.wgz.entity.ZsYwxxb;
import org.jeecg.modules.demo.dzzz.wgz.mapper.ZsYwxxbMapper;
import org.jeecg.modules.demo.dzzz.wgz.service.IZsYwxxbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * @Description: zs_ywxxb
 * @Author: jeecg-boot
 * @Date:   2024-06-27
 * @Version: V1.0
 */
@Service
public class ZsYwxxbServiceImpl extends ServiceImpl<ZsYwxxbMapper, ZsYwxxb> implements IZsYwxxbService {

    @Autowired
    private ICertTypeService iCertTypeService;
    @Autowired
    private CertchildYpscZcMapper certchildYpscZcMapper;
    @Autowired
    private CertchildYpscWtMapper certchildYpscWtMapper;
    @Autowired
    private CertchildYpscStMapper certchildYpscStMapper;
    @Autowired
    private ZsYwxxbMapper zsYwxxbMapper;
    @Autowired
    private CertchildYlqxwlxsbaMapper certchildYlqxwlxsbaMapper;
    @Autowired
    private CertchildDylylqxscbapzMapper certchildDylylqxscbapzMapper;

    @Autowired
    CertchildCkomylyMapper certchildCkomylyMapper;
    @Autowired
    CertchildMzyphjsypddscMapper certchildMzyphjsypddscMapper;
    @Autowired
    CertchildYlqxcpckxsMapper certchildYlqxcpckxsMapper;
    @Autowired
    CertchildYlqxscbaZbMapper certchildYlqxscbaZbMapper;
    @Autowired
    CertchildYlqxwtbaZbMapper certchildYlqxwtbaZbMapper;
    @Autowired
    CertchirdYlqxlcsybaMapper certchirdYlqxlcsybaMapper;
    @Autowired
    CertchildYpckxkzMapper certchildYpckxkzMapper;
    @Autowired
    CertchildYpckxszmMapper certchildYpckxszmMapper;
    @Autowired
    CertchildYpscGmpMapper certchildYpscGmpMapper;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateMain(ZsYwxxb certInfo, List<CertchildYpscZc> certchildYpscZcList, List<CertchildYpscWt> certchildYpscWtList, List<CertchildYpscSt> certchildYpscStList,
                           List<CertchildCkomyly> certchildCkomylies,List<CertchildMzyphjsypddsc> certchildMzyphjsypddscs,List<CertchildYlqxcpckxs> certchildYlqxcpckxs,
                           List<CertchildYlqxscbaZb> certchildYlqxscbaZbs,List<CertchildYlqxwtbaZb> certchildYlqxwlxsbaList,List<CertchildYpckxkz> certchildYpckxkzs,
                           List<CertchildYpckxszm> certchildYpckxszms,List<CertchildDylylqxscbapz> certchildDylylqxscbapzList,
                           List<CertchildYlqxwlxsba> certchildYlqxwlxsbas,List<CertchirdYlqxlcsyba> certchirdYlqxlcsybas) {
        zsYwxxbMapper.updateById(certInfo);
        //1.先删除子表数据
        certchildYpscZcMapper.deleteByMainId(certInfo.getZsid(),certInfo.getId(),"3");
        certchildYpscWtMapper.deleteByMainId(certInfo.getZsid(),certInfo.getId(),"3");
        certchildYpscStMapper.deleteByMainId(certInfo.getZsid(),certInfo.getId(),"3");
        certchildCkomylyMapper.deleteByMainId(certInfo.getZsid(),certInfo.getId(),"3");
        certchildMzyphjsypddscMapper.deleteByMainId(certInfo.getZsid(),certInfo.getId(),"3");
        certchildYlqxcpckxsMapper.deleteByMainId(certInfo.getZsid(),certInfo.getId(),"3");
        certchildYlqxscbaZbMapper.deleteByMainId(certInfo.getZsid(),certInfo.getId(),"3");
        certchildYlqxwtbaZbMapper.deleteByMainId(certInfo.getZsid(),certInfo.getId(),"3");
        certchildYlqxwlxsbaMapper.deleteByMainId(certInfo.getZsid(),certInfo.getId(),"3");
        certchirdYlqxlcsybaMapper.deleteByMainId(certInfo.getZsid(),certInfo.getId(),"3");
        certchildYpckxkzMapper.deleteByMainId(certInfo.getZsid(),certInfo.getId(),"3");
        certchildYpckxszmMapper.deleteByMainId(certInfo.getZsid(),certInfo.getId(),"3");
        certchildDylylqxscbapzMapper.deleteByMainId(certInfo.getZsid(),certInfo.getId(),"3");
        //2.子表数据重新插入
        if (certchildYpscZcList != null && certchildYpscZcList.size() > 0) {
            for (CertchildYpscZc entity : certchildYpscZcList) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                entity.setId(UUIDGenerator.generate());
                certchildYpscZcMapper.insert(entity);
            }
        }
        if (certchildYpscWtList != null && certchildYpscWtList.size() > 0) {
            for (CertchildYpscWt entity : certchildYpscWtList) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                entity.setId(UUIDGenerator.generate());
                certchildYpscWtMapper.insert(entity);
            }
        }
        if (certchildYpscStList != null && certchildYpscStList.size() > 0) {
            for (CertchildYpscSt entity : certchildYpscStList) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                entity.setId(UUIDGenerator.generate());
                certchildYpscStMapper.insert(entity);
            }
        }
        if(certchildYlqxwlxsbas!=null && certchildYlqxwlxsbas.size()>0) {
            for(CertchildYlqxwlxsba entity:certchildYlqxwlxsbas) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                entity.setId(UUIDGenerator.generate());
                certchildYlqxwlxsbaMapper.insert(entity);
            }
        }
        if(certchildYlqxscbaZbs!=null && certchildYlqxscbaZbs.size()>0) {
            for(CertchildYlqxscbaZb entity:certchildYlqxscbaZbs) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                entity.setId(UUIDGenerator.generate());
                certchildYlqxscbaZbMapper.insert(entity);
            }
        }
        if(certchildCkomylies!=null && certchildCkomylies.size()>0) {
            for(CertchildCkomyly entity:certchildCkomylies) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                entity.setId(UUIDGenerator.generate());
                certchildCkomylyMapper.insert(entity);
            }
        }
        if(certchildMzyphjsypddscs!=null && certchildMzyphjsypddscs.size()>0) {
            for(CertchildMzyphjsypddsc entity:certchildMzyphjsypddscs) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                entity.setId(UUIDGenerator.generate());
                certchildMzyphjsypddscMapper.insert(entity);
            }
        }
        if(certchildYlqxcpckxs!=null && certchildYlqxcpckxs.size()>0) {
            for(CertchildYlqxcpckxs entity:certchildYlqxcpckxs) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                entity.setId(UUIDGenerator.generate());
                certchildYlqxcpckxsMapper.insert(entity);
            }
        }
        if(certchildYlqxwlxsbaList!=null && certchildYlqxwlxsbaList.size()>0) {
            for(CertchildYlqxwtbaZb entity:certchildYlqxwlxsbaList) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                entity.setId(UUIDGenerator.generate());
                certchildYlqxwtbaZbMapper.insert(entity);
            }
        }
        if(certchildYpckxkzs!=null && certchildYpckxkzs.size()>0) {
            for(CertchildYpckxkz entity:certchildYpckxkzs) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                entity.setId(UUIDGenerator.generate());
                certchildYpckxkzMapper.insert(entity);
            }
        }
        if(certchildYpckxszms!=null && certchildYpckxszms.size()>0) {
            for(CertchildYpckxszm entity:certchildYpckxszms) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                entity.setId(UUIDGenerator.generate());
                certchildYpckxszmMapper.insert(entity);
            }
        }
        if(certchildDylylqxscbapzList!=null && certchildDylylqxscbapzList.size()>0) {
            for(CertchildDylylqxscbapz entity:certchildDylylqxscbapzList) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setZt(BigDecimal.valueOf(3));
                entity.setXzspid(certInfo.getId());
                entity.setId(UUIDGenerator.generate());
                certchildDylylqxscbapzMapper.insert(entity);
            }
        }
        if(certchirdYlqxlcsybas!=null && certchirdYlqxlcsybas.size()>0) {
            for(CertchirdYlqxlcsyba entity:certchirdYlqxlcsybas) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                entity.setId(UUIDGenerator.generate());
                certchirdYlqxlcsybaMapper.insert(entity);
            }
        }
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateMainWH(ZsYwxxb certInfo,String zsid, List<CertchildYpscZc> certchildYpscZcList, List<CertchildYpscWt> certchildYpscWtList, List<CertchildYpscSt> certchildYpscStList,
                           List<CertchildCkomyly> certchildCkomylies,List<CertchildMzyphjsypddsc> certchildMzyphjsypddscs,List<CertchildYlqxcpckxs> certchildYlqxcpckxs,
                           List<CertchildYlqxscbaZb> certchildYlqxscbaZbs,List<CertchildYlqxwtbaZb> certchildYlqxwlxsbaList,List<CertchildYpckxkz> certchildYpckxkzs,
                           List<CertchildYpckxszm> certchildYpckxszms,List<CertchildDylylqxscbapz> certchildDylylqxscbapzList,
                           List<CertchildYlqxwlxsba> certchildYlqxwlxsbas,List<CertchirdYlqxlcsyba> certchirdYlqxlcsybas) {
        zsYwxxbMapper.updateById(certInfo);
        //1.先删除子表数据
        certchildYpscZcMapper.deleteByMainId(certInfo.getZsid(),certInfo.getId(),"3");
        certchildYpscWtMapper.deleteByMainId(certInfo.getZsid(),certInfo.getId(),"3");
        certchildYpscStMapper.deleteByMainId(certInfo.getZsid(),certInfo.getId(),"3");
        certchildCkomylyMapper.deleteByMainId(certInfo.getZsid(),certInfo.getId(),"3");
        certchildMzyphjsypddscMapper.deleteByMainId(certInfo.getZsid(),certInfo.getId(),"3");
        certchildYlqxcpckxsMapper.deleteByMainId(certInfo.getZsid(),certInfo.getId(),"3");
        certchildYlqxscbaZbMapper.deleteByMainId(certInfo.getZsid(),certInfo.getId(),"3");
        certchildYlqxwtbaZbMapper.deleteByMainId(certInfo.getZsid(),certInfo.getId(),"3");
        certchildYlqxwlxsbaMapper.deleteByMainId(certInfo.getZsid(),certInfo.getId(),"3");
        certchirdYlqxlcsybaMapper.deleteByMainId(certInfo.getZsid(),certInfo.getId(),"3");
        certchildYpckxkzMapper.deleteByMainId(certInfo.getZsid(),certInfo.getId(),"3");
        certchildYpckxszmMapper.deleteByMainId(certInfo.getZsid(),certInfo.getId(),"3");
        certchildDylylqxscbapzMapper.deleteByMainId(certInfo.getZsid(),certInfo.getId(),"3");
        //==========维护的也删掉
        certchildYpscZcMapper.deleteByMainId(zsid,certInfo.getId(),"3");
        certchildYpscWtMapper.deleteByMainId(zsid,certInfo.getId(),"3");
        certchildYpscStMapper.deleteByMainId(zsid,certInfo.getId(),"3");
        certchildCkomylyMapper.deleteByMainId(zsid,certInfo.getId(),"3");
        certchildMzyphjsypddscMapper.deleteByMainId(zsid,certInfo.getId(),"3");
        certchildYlqxcpckxsMapper.deleteByMainId(zsid,certInfo.getId(),"3");
        certchildYlqxscbaZbMapper.deleteByMainId(zsid,certInfo.getId(),"3");
        certchildYlqxwtbaZbMapper.deleteByMainId(zsid,certInfo.getId(),"3");
        certchildYlqxwlxsbaMapper.deleteByMainId(zsid,certInfo.getId(),"3");
        certchirdYlqxlcsybaMapper.deleteByMainId(zsid,certInfo.getId(),"3");
        certchildYpckxkzMapper.deleteByMainId(zsid,certInfo.getId(),"3");
        certchildYpckxszmMapper.deleteByMainId(zsid,certInfo.getId(),"3");
        certchildDylylqxscbapzMapper.deleteByMainId(zsid,certInfo.getId(),"3");
        //2.子表数据重新插入
        if (certchildYpscZcList != null && certchildYpscZcList.size() > 0) {
            for (CertchildYpscZc entity : certchildYpscZcList) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                entity.setId(UUIDGenerator.generate());
                certchildYpscZcMapper.insert(entity);
            }
        }
        if (certchildYpscWtList != null && certchildYpscWtList.size() > 0) {
            for (CertchildYpscWt entity : certchildYpscWtList) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                entity.setId(UUIDGenerator.generate());

                certchildYpscWtMapper.insert(entity);
            }
        }
        if (certchildYpscStList != null && certchildYpscStList.size() > 0) {
            for (CertchildYpscSt entity : certchildYpscStList) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                entity.setId(UUIDGenerator.generate());

                certchildYpscStMapper.insert(entity);
            }
        }
        if(certchildYlqxwlxsbas!=null && certchildYlqxwlxsbas.size()>0) {
            for(CertchildYlqxwlxsba entity:certchildYlqxwlxsbas) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                entity.setId(UUIDGenerator.generate());

                certchildYlqxwlxsbaMapper.insert(entity);
            }
        }
        if(certchildYlqxscbaZbs!=null && certchildYlqxscbaZbs.size()>0) {
            for(CertchildYlqxscbaZb entity:certchildYlqxscbaZbs) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                entity.setId(UUIDGenerator.generate());

                certchildYlqxscbaZbMapper.insert(entity);
            }
        }
        if(certchildCkomylies!=null && certchildCkomylies.size()>0) {
            for(CertchildCkomyly entity:certchildCkomylies) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                entity.setId(UUIDGenerator.generate());

                certchildCkomylyMapper.insert(entity);
            }
        }
        if(certchildMzyphjsypddscs!=null && certchildMzyphjsypddscs.size()>0) {
            for(CertchildMzyphjsypddsc entity:certchildMzyphjsypddscs) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                entity.setId(UUIDGenerator.generate());

                certchildMzyphjsypddscMapper.insert(entity);
            }
        }
        if(certchildYlqxcpckxs!=null && certchildYlqxcpckxs.size()>0) {
            for(CertchildYlqxcpckxs entity:certchildYlqxcpckxs) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                entity.setId(UUIDGenerator.generate());

                certchildYlqxcpckxsMapper.insert(entity);
            }
        }
        if(certchildYlqxwlxsbaList!=null && certchildYlqxwlxsbaList.size()>0) {
            for(CertchildYlqxwtbaZb entity:certchildYlqxwlxsbaList) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                entity.setId(UUIDGenerator.generate());

                certchildYlqxwtbaZbMapper.insert(entity);
            }
        }
        if(certchildYpckxkzs!=null && certchildYpckxkzs.size()>0) {
            for(CertchildYpckxkz entity:certchildYpckxkzs) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                entity.setId(UUIDGenerator.generate());

                certchildYpckxkzMapper.insert(entity);
            }
        }
        if(certchildYpckxszms!=null && certchildYpckxszms.size()>0) {
            for(CertchildYpckxszm entity:certchildYpckxszms) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                entity.setId(UUIDGenerator.generate());

                certchildYpckxszmMapper.insert(entity);
            }
        }
        if(certchildDylylqxscbapzList!=null && certchildDylylqxscbapzList.size()>0) {
            for(CertchildDylylqxscbapz entity:certchildDylylqxscbapzList) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setZt(BigDecimal.valueOf(3));
                entity.setXzspid(certInfo.getId());
                entity.setId(UUIDGenerator.generate());

                certchildDylylqxscbapzMapper.insert(entity);
            }
        }
        if(certchirdYlqxlcsybas!=null && certchirdYlqxlcsybas.size()>0) {
            for(CertchirdYlqxlcsyba entity:certchirdYlqxlcsybas) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                entity.setId(UUIDGenerator.generate());

                certchirdYlqxlcsybaMapper.insert(entity);
            }
        }
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveMain(ZsYwxxb certInfo, List<CertchildYpscZc> certchildYpscZcList, List<CertchildYpscWt> certchildYpscWtList, List<CertchildYpscSt> certchildYpscStList,
                         List<CertchildCkomyly> certchildCkomylies, List<CertchildMzyphjsypddsc> certchildMzyphjsypddscs, List<CertchildYlqxcpckxs> certchildYlqxcpckxs,
                         List<CertchildYlqxscbaZb> certchildYlqxscbaZbs, List<CertchildYlqxwtbaZb> certchildYlqxwlxsbaList, List<CertchildYpckxkz> certchildYpckxkzs,
                         List<CertchildYpckxszm> certchildYpckxszms, List<CertchildDylylqxscbapz> certchildDylylqxscbapzList,
                         List<CertchildYlqxwlxsba> certchildYlqxwlxsbas, List<CertchirdYlqxlcsyba> certchirdYlqxlcsybas
    ) {
        zsYwxxbMapper.insert(certInfo);
        if (certchildYpscZcList != null && certchildYpscZcList.size() > 0) {
            for (CertchildYpscZc entity : certchildYpscZcList) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setId(UUIDGenerator.generate());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                certchildYpscZcMapper.insert(entity);
            }
        }
        if (certchildYpscWtList != null && certchildYpscWtList.size() > 0) {
            for (CertchildYpscWt entity : certchildYpscWtList) {
                //外键设置
                entity.setId(UUIDGenerator.generate());
                entity.setZsid(certInfo.getZsid());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                certchildYpscWtMapper.insert(entity);
            }
        }
        if (certchildYpscStList != null && certchildYpscStList.size() > 0) {
            for (CertchildYpscSt entity : certchildYpscStList) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setId(UUIDGenerator.generate());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                certchildYpscStMapper.insert(entity);
            }
        }
        if(certchildYlqxwlxsbas!=null && certchildYlqxwlxsbas.size()>0) {
            for(CertchildYlqxwlxsba entity:certchildYlqxwlxsbas) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setId(UUIDGenerator.generate());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                certchildYlqxwlxsbaMapper.insert(entity);
            }
        }
        if(certchildYlqxscbaZbs!=null && certchildYlqxscbaZbs.size()>0) {
            for(CertchildYlqxscbaZb entity:certchildYlqxscbaZbs) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setId(UUIDGenerator.generate());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                certchildYlqxscbaZbMapper.insert(entity);
            }
        }
        if(certchildCkomylies!=null && certchildCkomylies.size()>0) {
            for(CertchildCkomyly entity:certchildCkomylies) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setId(UUIDGenerator.generate());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                certchildCkomylyMapper.insert(entity);
            }
        }
        if(certchildMzyphjsypddscs!=null && certchildMzyphjsypddscs.size()>0) {
            for(CertchildMzyphjsypddsc entity:certchildMzyphjsypddscs) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setId(UUIDGenerator.generate());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                certchildMzyphjsypddscMapper.insert(entity);
            }
        }
        if(certchildYlqxcpckxs!=null && certchildYlqxcpckxs.size()>0) {
            for(CertchildYlqxcpckxs entity:certchildYlqxcpckxs) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setId(UUIDGenerator.generate());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                certchildYlqxcpckxsMapper.insert(entity);
            }
        }
        if(certchildYlqxwlxsbaList!=null && certchildYlqxwlxsbaList.size()>0) {
            for(CertchildYlqxwtbaZb entity:certchildYlqxwlxsbaList) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setId(UUIDGenerator.generate());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                certchildYlqxwtbaZbMapper.insert(entity);
            }
        }
        if(certchildYpckxkzs!=null && certchildYpckxkzs.size()>0) {
            for(CertchildYpckxkz entity:certchildYpckxkzs) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setId(UUIDGenerator.generate());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                certchildYpckxkzMapper.insert(entity);
            }
        }
        if(certchildYpckxszms!=null && certchildYpckxszms.size()>0) {
            for(CertchildYpckxszm entity:certchildYpckxszms) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setId(UUIDGenerator.generate());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                certchildYpckxszmMapper.insert(entity);
            }
        }
        if(certchildDylylqxscbapzList!=null && certchildDylylqxscbapzList.size()>0) {
            for(CertchildDylylqxscbapz entity:certchildDylylqxscbapzList) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setId(UUIDGenerator.generate());
                entity.setZt(BigDecimal.valueOf(3));
                entity.setXzspid(certInfo.getId());
                certchildDylylqxscbapzMapper.insert(entity);
            }
        }
        if(certchirdYlqxlcsybas!=null && certchirdYlqxlcsybas.size()>0) {
            for(CertchirdYlqxlcsyba entity:certchirdYlqxlcsybas) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setId(UUIDGenerator.generate());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                certchirdYlqxlcsybaMapper.insert(entity);
            }
        }
    }

    @Override
    public void saveMainwh(ZsYwxxb certInfo, List<CertchildYpscZc> certchildYpscZcList, List<CertchildYpscWt> certchildYpscWtList, List<CertchildYpscSt> certchildYpscStList, List<CertchildCkomyly> certchildCkomylies, List<CertchildMzyphjsypddsc> certchildMzyphjsypddscs, List<CertchildYlqxcpckxs> certchildYlqxcpckxs, List<CertchildYlqxscbaZb> certchildYlqxscbaZbs, List<CertchildYlqxwtbaZb> certchildYlqxwlxsbaList, List<CertchildYpckxkz> certchildYpckxkzs, List<CertchildYpckxszm> certchildYpckxszms, List<CertchildDylylqxscbapz> certchildDylylqxscbapzList, List<CertchildYlqxwlxsba> certchildYlqxwlxsbas, List<CertchirdYlqxlcsyba> certchirdYlqxlcsybas) {
        zsYwxxbMapper.insert(certInfo);
        if (certchildYpscZcList != null && certchildYpscZcList.size() > 0) {
            for (CertchildYpscZc entity : certchildYpscZcList) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setId(UUIDGenerator.generate());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                certchildYpscZcMapper.insert(entity);
            }
        }
        if (certchildYpscWtList != null && certchildYpscWtList.size() > 0) {
            for (CertchildYpscWt entity : certchildYpscWtList) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setId(UUIDGenerator.generate());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                certchildYpscWtMapper.insert(entity);
            }
        }
        if (certchildYpscStList != null && certchildYpscStList.size() > 0) {
            for (CertchildYpscSt entity : certchildYpscStList) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setId(UUIDGenerator.generate());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                certchildYpscStMapper.insert(entity);
            }
        }
        if(certchildYlqxwlxsbas!=null && certchildYlqxwlxsbas.size()>0) {
            for(CertchildYlqxwlxsba entity:certchildYlqxwlxsbas) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setId(UUIDGenerator.generate());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                certchildYlqxwlxsbaMapper.insert(entity);
            }
        }
        if(certchildYlqxscbaZbs!=null && certchildYlqxscbaZbs.size()>0) {
            for(CertchildYlqxscbaZb entity:certchildYlqxscbaZbs) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setId(UUIDGenerator.generate());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                certchildYlqxscbaZbMapper.insert(entity);
            }
        }
        if(certchildCkomylies!=null && certchildCkomylies.size()>0) {
            for(CertchildCkomyly entity:certchildCkomylies) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setId(UUIDGenerator.generate());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                certchildCkomylyMapper.insert(entity);
            }
        }
        if(certchildMzyphjsypddscs!=null && certchildMzyphjsypddscs.size()>0) {
            for(CertchildMzyphjsypddsc entity:certchildMzyphjsypddscs) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setId(UUIDGenerator.generate());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                certchildMzyphjsypddscMapper.insert(entity);
            }
        }
        if(certchildYlqxcpckxs!=null && certchildYlqxcpckxs.size()>0) {
            for(CertchildYlqxcpckxs entity:certchildYlqxcpckxs) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setId(UUIDGenerator.generate());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                certchildYlqxcpckxsMapper.insert(entity);
            }
        }
        if(certchildYlqxwlxsbaList!=null && certchildYlqxwlxsbaList.size()>0) {
            for(CertchildYlqxwtbaZb entity:certchildYlqxwlxsbaList) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setId(UUIDGenerator.generate());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                certchildYlqxwtbaZbMapper.insert(entity);
            }
        }
        if(certchildYpckxkzs!=null && certchildYpckxkzs.size()>0) {
            for(CertchildYpckxkz entity:certchildYpckxkzs) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setId(UUIDGenerator.generate());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                certchildYpckxkzMapper.insert(entity);
            }
        }
        if(certchildYpckxszms!=null && certchildYpckxszms.size()>0) {
            for(CertchildYpckxszm entity:certchildYpckxszms) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setId(UUIDGenerator.generate());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                certchildYpckxszmMapper.insert(entity);
            }
        }
        if(certchildDylylqxscbapzList!=null && certchildDylylqxscbapzList.size()>0) {
            for(CertchildDylylqxscbapz entity:certchildDylylqxscbapzList) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setId(UUIDGenerator.generate());
                entity.setZt(BigDecimal.valueOf(3));
                entity.setXzspid(certInfo.getId());
                certchildDylylqxscbapzMapper.insert(entity);
            }
        }
        if(certchirdYlqxlcsybas!=null && certchirdYlqxlcsybas.size()>0) {
            for(CertchirdYlqxlcsyba entity:certchirdYlqxlcsybas) {
                //外键设置
                entity.setZsid(certInfo.getZsid());
                entity.setId(UUIDGenerator.generate());
                entity.setZt("3");
                entity.setXzspid(certInfo.getId());
                certchirdYlqxlcsybaMapper.insert(entity);
            }
        }
    }

    @Override
    public ZsYwxxb getByZsid(String zsid) {
        return zsYwxxbMapper.getByZsid(zsid);
    }

    @Override
    public ResultBean getRealcodeByName(String fzgj) {
        return zsYwxxbMapper.getRealcodeByName(fzgj);
    }

    @Override
    public ResultBean getSealcodeByKeySn(String keysn) {
        return zsYwxxbMapper.getSealcodeByKeySn(keysn);
    }
}
