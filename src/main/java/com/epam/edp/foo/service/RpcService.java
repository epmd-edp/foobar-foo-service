package com.epam.edp.foo.service;

/**
 * @author Pavlo_Yemelianov
 */
public interface RpcService {

    String callDumbClient();

    String callFeignClient();
}
