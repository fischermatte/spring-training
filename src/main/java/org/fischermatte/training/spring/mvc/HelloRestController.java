package org.fischermatte.training.spring.mvc;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloRestController {
    @RequestMapping(path = "/api/hello", method = RequestMethod.GET)
    @ResponseBody
    public String getHello(@RequestParam(required = false, name = "name") String name) {
        System.out.println("hello mr. " + name);
        return "hello";
    }
}
