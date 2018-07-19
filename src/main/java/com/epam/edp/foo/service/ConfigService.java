package com.epam.edp.foo.service;

/**
 * @author Pavlo_Yemelianov
 */
public interface ConfigService {
    String getDefaultConfig();

    String getProfileConfig();

    String getMountConfig();

    String getReloadConfig();

    String getSecretConfig();
}
