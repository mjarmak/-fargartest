package com.jarmak.fargartest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestContoller {

    @GetMapping(path = "/test")
    public String test() {
        return "ok";
    }

}
