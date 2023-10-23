package com.nhn.k8sstudy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelmController {

    @Value("${helm.message}")
    private String helmMessage;
    @GetMapping("/helm")
    public String getHelmMessage() {
        return helmMessage;
    }
}
