package com.epam.edp.cart.service.impl;

import com.epam.edp.cart.service.ConfigService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Pavlo_Yemelianov
 */
@Service
public class ConfigServiceImpl implements ConfigService {

    @Value("${config.default}")
    private String defaultConfig;
    @Value("${config.profile}")
    private String profileConfig;
    @Value("${config.mount}")
    private String mountConfig;
    @Value("${config.reload}")
    private String reloadConfig;
    @Value("${config.secret}")
    private String secretConfig;

    public String getDefaultConfig() {
        return defaultConfig;
    }

    public String getProfileConfig() {
        return profileConfig;
    }

    public String getMountConfig() {
        return mountConfig;
    }

    public String getReloadConfig() {
        return reloadConfig;
    }

    public String getSecretConfig() {
        return secretConfig;
    }

}
