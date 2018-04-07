package com.imooc.smallapp.dao;

import com.imooc.smallapp.entity.Area;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;


public interface AreaDao {
    /**
     * 获取区域列表
     * @return
     */
    List<Area> queryArea();

    /**
     * 根据id查询某个区域
     * @param areaId
     * @return
     */
    Area queryAreaById(int areaId);

    /**
     * 新增区域
     * @param area
     * @return
     */
    int insertArea(Area area);

    /**
     * 修改区域
     * @param area
     * @return
     */
    int updateArea(Area area);

    /**
     * 删除区域
     * @param areaId
     * @return
     */
    int deleteArea(int areaId);
}
