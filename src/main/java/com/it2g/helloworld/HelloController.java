package com.it2g.helloworld;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@EnableJpaRepositories("com.it2g")
@EntityScan("com.it2g")
public class HelloController {

    @Autowired
    @Qualifier("dataSource")
    DataSource dataSource;

    @Autowired
    ProductRepository productRepository;

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
    public Map GetProduct(@RequestParam(value = "id") long id) {
        Product pr = productRepository.findOne(id);
        return Collections.singletonMap("response", pr.getName());
    }
}
