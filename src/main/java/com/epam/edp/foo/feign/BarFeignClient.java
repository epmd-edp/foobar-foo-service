package com.epam.edp.foo.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Pavlo_Yemelianov
 */
@FeignClient("bar-service")
public interface BarFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/setting")
    String getSetting();
}
