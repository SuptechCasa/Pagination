package com.uae.pagination.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("public")
    public String publicTest(){
        return "Espace publique";
    }
    @GetMapping("user")
    public String userTest(){
        return "Espace user";
    }
    @GetMapping("admin")
    public String adminTest(){
        return "Espace admin";
    }
}
