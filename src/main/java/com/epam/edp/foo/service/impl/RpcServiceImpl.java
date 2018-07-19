package com.epam.edp.foo.service.impl;

import com.epam.edp.foo.feign.BarFeignClient;
import com.epam.edp.foo.service.RpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Pavlo_Yemelianov
 */
@Service
public class RpcServiceImpl implements RpcService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private BarFeignClient barFeignClient;

    @Retryable(
            value = {Exception.class},
            maxAttempts = 4,
            backoff = @Backoff(delay = 1000)
    )
    public String callDumbClient() {
        return restTemplate.getForEntity("http://bar-service:8080/api/setting", String.class).getBody();
    }

    public String callFeignClient() {
        return barFeignClient.getSetting();
    }
}
