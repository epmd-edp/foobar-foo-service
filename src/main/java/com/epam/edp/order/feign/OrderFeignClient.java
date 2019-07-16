package com.epam.edp.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Pavlo_Yemelianov
 */
@FeignClient(name = "order-service", url = "http://order-service:8080")
public interface OrderFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/order-service/time")
    String getTime();
}
