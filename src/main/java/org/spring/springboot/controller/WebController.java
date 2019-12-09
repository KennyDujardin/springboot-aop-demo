package org.spring.springboot.controller;

import org.spring.springboot.service.KtvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebController {

    @Autowired
    KtvService ktvService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getHomePage(Model model) {
        return "index";
    }

    @RequestMapping(value = "/oddPage", method = RequestMethod.GET)
    public String getOddResult(Model model) {
        return "result";
    }

    @GetMapping(value = "/method1")
    public String testMethod1() {
        ktvService.methodDance();
        ktvService.methodDance();
        ktvService.methodDance();
        return "finished";
    }

    @GetMapping(value = "/method2")
    public String testMethod2() {
        ktvService.methodSing();
        return "finished";
    }
}
