package com.mjtal.mongo_demo.controller;

import com.mjtal.mongo_demo.common.R;
import com.mjtal.mongo_demo.service.GetHightService;
import com.mjtal.mongo_demo.service.impl.GetHightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gethigh")
public class GetHighController {
    @Autowired
    private GetHightService getHightService;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        return "ok";
    }

    @GetMapping("/stright")
    public R getHight(@RequestParam double lon,
                      @RequestParam double lat){
        double aDouble = getHightService.queryHigh(lon, lat);
        if (aDouble!=0d){
            return R.ok().put("code",200).put("high",aDouble);
        }else {
            return R.error(404,"没有找到高程信息");
        }
    }
}
