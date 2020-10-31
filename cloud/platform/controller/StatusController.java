package com.cloud.platform.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class StatusController {
    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String success() {
        return "Post Success!";
    }
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String error() {
        return "Something Wrong!";
    }

}
