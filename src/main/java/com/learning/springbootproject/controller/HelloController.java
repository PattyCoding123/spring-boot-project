package com.learning.springbootproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Using the @RestController annotation will automatically
 * cause the HTTP Implementation functions to return the
 * Response body.
 * */
@RestController
public class HelloController {

    /* The helloWorld function is bound to an API endpoint
     * we set in the annotation for @RequestMapping(value="{val}")
     *
     * However, since @RequestMapping is verbose, you can do
     * @{HTTP_Verb}Mapping("{url_endpoint}")
     * */
    @GetMapping("/")
    public String helloWorld() {
        return "Hello World! This is Patrick's First API.";
    }
}
