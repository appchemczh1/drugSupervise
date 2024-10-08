package org.jeecg.modules.demo.dzzz.dept.service;

import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.demo.dzzz.dept.entity.SDept;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Description: s_dept
 * @Author: jeecg-boot
 * @Date:   2024-07-11
 * @Version: V1.0
 */
public interface ISDeptService extends IService<SDept> {

    /**
     * 根据部门名称查询部门信息
     * @param deptName
     * @return
     */
    SDept getDeptByName(String deptName);

    /**
     * 根据部门ID查询部门信息
     * @param deptId
     * @return
     */
    SDept getDeptById(@Param("deptId") String deptId);

}
