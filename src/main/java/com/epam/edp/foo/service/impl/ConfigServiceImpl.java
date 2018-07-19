package com.epam.edp.foo.service.impl;

import com.epam.edp.foo.service.ConfigService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Pavlo_Yemelianov
 */
@Service
public class ConfigServiceImpl implements ConfigService {
    @Value("${foo.config.default}")
    private String defaultConfig;
    @Value("${foo.config.profile}")
    private String profileConfig;
    @Value("${foo.config.mount}")
    private String mountConfig;
    @Value("${foo.config.reload}")
    private String reloadConfig;

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
}
