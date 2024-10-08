package org.jeecg.modules.demo.dzzz.homepage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.jeecg.modules.demo.dzzz.homepage.entity.Area;


import java.util.List;

@Mapper
public interface AreaMapper {

    @Select("SELECT id, areacode, areaname, parentid FROM cert_area")
    List<Area> selectAllAreas();
}