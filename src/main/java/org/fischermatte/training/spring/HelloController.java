package org.fischermatte.training.spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String getHello() {
        System.out.println("say hello....");
        return "hello";
    }
}
