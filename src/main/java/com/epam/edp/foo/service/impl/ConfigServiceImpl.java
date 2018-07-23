package com.epam.edp.foo.service.impl;

import com.epam.edp.foo.service.ConfigService;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;
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
    @Value("${foo.config.secret}")
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

    public String getDynamicConfig() {
        DynamicStringProperty property = DynamicPropertyFactory.getInstance().getStringProperty("foo.config.dynamic", "default");
        return property.get();
    }
}
