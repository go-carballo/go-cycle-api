package com.biciman.go.web.controller;

import com.biciman.go.domain.service.GoBicimanAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final String platform;

    private final GoBicimanAiService aiService;
    public HelloController(@Value("${spring.application.name}") String platform, GoBicimanAiService aiService1) {
        this.platform = platform;
        this.aiService = aiService1;
    }


    @GetMapping("/hello")
    public String hello(){
        return this.aiService.generateGreeting(platform);
    }
}
