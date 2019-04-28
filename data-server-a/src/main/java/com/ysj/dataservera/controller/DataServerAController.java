package com.ysj.dataservera.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/aaa")
public class DataServerAController {

    @GetMapping("/getData")
    public String getDataFromA() {
        log.info("data-server-a: getDataFromA()");
        return "data from data-server-a";
    }
}
