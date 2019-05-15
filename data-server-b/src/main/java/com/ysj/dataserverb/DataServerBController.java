package com.ysj.dataserverb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/aaa")
public class DataServerBController {

    @GetMapping(value = "/getData")
    public String getDataFromB(@RequestParam String userType) {
        log.info("data-server-b: getDataFromB()");
        return "data from data-server-b";
    }
}
