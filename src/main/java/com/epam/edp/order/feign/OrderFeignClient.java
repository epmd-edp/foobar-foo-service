package com.epam.edp.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Pavlo_Yemelianov
 */
@FeignClient("order-service")
public interface OrderFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/order-service/time")
    String getTime();
}
