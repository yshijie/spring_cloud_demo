package com.ysj.dataserverb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/aaa")
public class DataServerBController {

    @RequestMapping("/getData")
    public String getDataFromB() {
        log.info("data-server-b: getDataFromB()");
        return "data from data-server-b";
    }
}
