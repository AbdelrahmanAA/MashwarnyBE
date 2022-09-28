package com.developerxgroup.mashwarny.restcontroller.p2.p3;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyAopController2 {
    @RequestMapping(method = RequestMethod.GET, path = "/hello2")
    public ResponseEntity<?> getHello2(@RequestParam("name") String username) {
        return ResponseEntity.ok("Hello, " + username);
    }

}
