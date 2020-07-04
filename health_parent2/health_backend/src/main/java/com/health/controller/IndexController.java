package com.health.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: JoinCao
 * @CreateDate: 2020-04-16
 */
@RestController
public class IndexController {
    @GetMapping("index")
    public Map index() {
        Map map = new HashMap<>();
        //return "传智播客";
        map.put("properties", "传智播客");
        return map;
    }
}
