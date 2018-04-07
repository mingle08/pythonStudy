package com.imooc.smallapp.service;

import com.imooc.smallapp.entity.Area;

import java.util.List;

public interface AreaService {
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
    boolean insertArea(Area area);

    /**
     * 修改区域
     * @param area
     * @return
     */
    boolean updateArea(Area area);

    /**
     * 删除区域
     * @param areaId
     * @return
     */
    boolean deleteArea(int areaId);
}
