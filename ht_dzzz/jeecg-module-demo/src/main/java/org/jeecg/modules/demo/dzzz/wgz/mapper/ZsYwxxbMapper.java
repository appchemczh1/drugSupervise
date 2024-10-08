package org.jeecg.modules.demo.dzzz.wgz.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.jeecg.modules.demo.dzzz.certinfo.entity.ResultBean;
import org.jeecg.modules.demo.dzzz.wgz.entity.ZsYwxxb;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Description: zs_ywxxb
 * @Author: jeecg-boot
 * @Date: 2024-06-27
 * @Version: V1.0
 */
public interface ZsYwxxbMapper extends BaseMapper<ZsYwxxb> {

	ZsYwxxb getByZsid(@Param("zsid") String zsid);

	ResultBean getRealcodeByName(@Param("fzjg") String fzgj);

	ResultBean getSealcodeByKeySn(@Param("keysn") String keysn);

	@Select("SELECT * FROM ZS_YWXXB WHERE YXZT='10' AND ZSID=#{zsid} ORDER BY FZRQ DESC,GZTIME DESC,SYNCTIME DESC LIMIT 1")
	ZsYwxxb getLastRecordByZsid(@Param("zsid") String zsid);

}
