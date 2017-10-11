package org.key.sample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @ResponseBody
    @RequestMapping("/")
    public String home() {
        return "Hello world!";
    }

    @ResponseBody
    @RequestMapping("/dummy")
    public String dummy() {
        throw new RuntimeException("Dummy test error");
    }

}
