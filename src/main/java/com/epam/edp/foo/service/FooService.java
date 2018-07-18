package com.epam.edp.foo.service;

/**
 * @author Pavlo_Yemelianov
 */
public interface FooService {

    void postMessage(String body);

    String getDumbClientResponse();

    String getFeignClientResponse();
}
