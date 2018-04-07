package com.imooc.smallapp.controller;

import com.imooc.smallapp.entity.Area;
import com.imooc.smallapp.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/superadmin")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping("/area/list")
    private Map<String, Object> areaList(){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Area> areaList = areaService.queryArea();
        modelMap.put("areaList", areaList);
        return modelMap;
    }

    @GetMapping("/area/{areaId}")
    private  Map<String, Object> getAreaById(@PathVariable Integer areaId){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Area area = areaService.queryAreaById(areaId);
        modelMap.put("area", area);
        return modelMap;
    }

    @PostMapping("/area")
    private Map<String, Object> insertArea(@RequestBody Area area){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", areaService.insertArea(area));
        return modelMap;
    }

    @PutMapping("/area")
    private  Map<String, Object> updateArea(@RequestBody Area area){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", areaService.updateArea(area));
        return modelMap;
    }

    @DeleteMapping("/area/{areaId}")
    private  Map<String, Object> deleteArea(@PathVariable Integer areaId){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", areaService.deleteArea(areaId));
        return modelMap;
    }
}
