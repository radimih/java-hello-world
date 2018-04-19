package com.it2g.helloworld;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Hello World!";
    }

    @RequestMapping(
            value = "/api/product",
            method = {RequestMethod.GET},
            params = {"id"},
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Map GetProduct(@RequestParam(value = "id") int id) {
        return Collections.singletonMap("response", id);
    }
}
