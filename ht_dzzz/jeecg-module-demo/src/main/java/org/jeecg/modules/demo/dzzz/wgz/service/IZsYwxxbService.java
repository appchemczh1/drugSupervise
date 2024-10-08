package org.jeecg.modules.demo.dzzz.wgz.service;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.demo.dzzz.certinfo.entity.*;
import org.jeecg.modules.demo.dzzz.wgz.entity.ZsYwxxb;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;

import org.jeecg.modules.demo.dzzz.wgz.mapper.ZsYwxxbMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: zs_ywxxb
 * @Author: jeecg-boot
 * @Date:   2024-06-27
 * @Version: V1.0
 */
public interface IZsYwxxbService extends IService<ZsYwxxb> {

    default List<ZsYwxxb> listByIds(String... ids) {
        if (ArrayUtils.isEmpty(ids)) return new ArrayList<>();
        LambdaQueryWrapper<ZsYwxxb> query = new LambdaQueryWrapper<>();
        query.in(ZsYwxxb::getId, Arrays.asList(ids).toArray());
        return list(query);
    }

    public void updateMain(ZsYwxxb certInfo, List<CertchildYpscZc> certchildYpscZcList, List<CertchildYpscWt> certchildYpscWtList, List<CertchildYpscSt> certchildYpscStList,
                           List<CertchildCkomyly> certchildCkomylies,List<CertchildMzyphjsypddsc> certchildMzyphjsypddscs,List<CertchildYlqxcpckxs> certchildYlqxcpckxs,
                           List<CertchildYlqxscbaZb> certchildYlqxscbaZbs,List<CertchildYlqxwtbaZb> certchildYlqxwlxsbaList,List<CertchildYpckxkz> certchildYpckxkzs,
                           List<CertchildYpckxszm> certchildYpckxszms,List<CertchildDylylqxscbapz> certchildDylylqxscbapzList,
                           List<CertchildYlqxwlxsba> certchildYlqxwlxsbas,List<CertchirdYlqxlcsyba> certchirdYlqxlcsybas);
    public void saveMain(ZsYwxxb certInfo, List<CertchildYpscZc> certchildYpscZcList, List<CertchildYpscWt> certchildYpscWtList, List<CertchildYpscSt> certchildYpscStList,
                         List<CertchildCkomyly> certchildCkomylies, List<CertchildMzyphjsypddsc> certchildMzyphjsypddscs, List<CertchildYlqxcpckxs> certchildYlqxcpckxs,
                         List<CertchildYlqxscbaZb> certchildYlqxscbaZbs, List<CertchildYlqxwtbaZb> certchildYlqxwlxsbaList, List<CertchildYpckxkz> certchildYpckxkzs,
                         List<CertchildYpckxszm> certchildYpckxszms, List<CertchildDylylqxscbapz> certchildDylylqxscbapzList,
                         List<CertchildYlqxwlxsba> certchildYlqxwlxsbas, List<CertchirdYlqxlcsyba> certchirdYlqxlcsybas
    );
    public void saveMainwh(ZsYwxxb certInfo, List<CertchildYpscZc> certchildYpscZcList, List<CertchildYpscWt> certchildYpscWtList, List<CertchildYpscSt> certchildYpscStList,
                         List<CertchildCkomyly> certchildCkomylies, List<CertchildMzyphjsypddsc> certchildMzyphjsypddscs, List<CertchildYlqxcpckxs> certchildYlqxcpckxs,
                         List<CertchildYlqxscbaZb> certchildYlqxscbaZbs, List<CertchildYlqxwtbaZb> certchildYlqxwlxsbaList, List<CertchildYpckxkz> certchildYpckxkzs,
                         List<CertchildYpckxszm> certchildYpckxszms, List<CertchildDylylqxscbapz> certchildDylylqxscbapzList,
                         List<CertchildYlqxwlxsba> certchildYlqxwlxsbas, List<CertchirdYlqxlcsyba> certchirdYlqxlcsybas
    );
    public void updateMainWH(ZsYwxxb certInfo,String zsid, List<CertchildYpscZc> certchildYpscZcList, List<CertchildYpscWt> certchildYpscWtList, List<CertchildYpscSt> certchildYpscStList,
                             List<CertchildCkomyly> certchildCkomylies,List<CertchildMzyphjsypddsc> certchildMzyphjsypddscs,List<CertchildYlqxcpckxs> certchildYlqxcpckxs,
                             List<CertchildYlqxscbaZb> certchildYlqxscbaZbs,List<CertchildYlqxwtbaZb> certchildYlqxwlxsbaList,List<CertchildYpckxkz> certchildYpckxkzs,
                             List<CertchildYpckxszm> certchildYpckxszms,List<CertchildDylylqxscbapz> certchildDylylqxscbapzList,
                             List<CertchildYlqxwlxsba> certchildYlqxwlxsbas,List<CertchirdYlqxlcsyba> certchirdYlqxlcsybas);
    public ZsYwxxb getByZsid(String zsid);

    public ResultBean getRealcodeByName(String fzgj);
    public ResultBean getSealcodeByKeySn(String keysn);

    default ZsYwxxb getLastRecordByZsid(String zsid) {
        return ((ZsYwxxbMapper) getBaseMapper()).getLastRecordByZsid(zsid);
    }

}
