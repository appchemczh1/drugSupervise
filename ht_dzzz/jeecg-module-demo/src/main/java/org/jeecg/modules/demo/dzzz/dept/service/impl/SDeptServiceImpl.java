package org.jeecg.modules.demo.dzzz.dept.service.impl;

import org.jeecg.modules.demo.dzzz.dept.entity.SDept;
import org.jeecg.modules.demo.dzzz.dept.mapper.SDeptMapper;
import org.jeecg.modules.demo.dzzz.dept.service.ISDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: s_dept
 * @Author: jeecg-boot
 * @Date:   2024-07-11
 * @Version: V1.0
 */
@Service
public class SDeptServiceImpl extends ServiceImpl<SDeptMapper, SDept> implements ISDeptService {

    @Autowired
    private SDeptMapper deptMapper;

    @Override
    public SDept getDeptByName(String deptName) {
        return deptMapper.getDeptByName(deptName);
    }

    @Override
    public SDept getDeptById(String deptId) {
        return deptMapper.getDeptById(deptId);
    }

}
