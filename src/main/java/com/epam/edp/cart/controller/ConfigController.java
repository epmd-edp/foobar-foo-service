package com.epam.edp.cart.controller;

import com.epam.edp.cart.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigController {

    @Autowired
    private ConfigService configService;

    @GetMapping("/default")
    public String getDefaultConfig() {
        return configService.getDefaultConfig();
    }

    @GetMapping("/profile")
    public String getProfileConfig() {
        return configService.getProfileConfig();
    }

    @GetMapping("/mount")
    public String getMountConfig() {
        return configService.getMountConfig();
    }

    @GetMapping("/reload")
    public String getReloadConfig() {
        return configService.getReloadConfig();
    }

    @GetMapping("/secret")
    public String getSecretConfig() {
        return configService.getSecretConfig();
    }
}
