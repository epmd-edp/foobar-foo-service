package com.epam.edp.foo.conroller;

import com.epam.edp.foo.service.AsyncService;
import com.epam.edp.foo.service.ConfigService;
import com.epam.edp.foo.service.RpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pavlo_Yemelianov
 */
@RestController
public class FooController {
    @Autowired
    private ConfigService configService;
    @Autowired
    private RpcService rpcService;
    @Autowired
    private AsyncService asyncService;

    @GetMapping(value = "/api/config/default")
    public String getDefaultConfig() {
        return configService.getDefaultConfig();
    }

    @GetMapping(value = "/api/config/profile")
    public String getProfileConfig() {
        return configService.getProfileConfig();
    }

    @GetMapping(value = "/api/config/mount")
    public String getMountConfig() {
        return configService.getMountConfig();
    }

    @GetMapping(value = "/api/config/reload")
    public String getReloadConfig() {
        return configService.getReloadConfig();
    }

    @GetMapping(value = "/api/config/secret")
    public String getSecretConfig() {
        return configService.getSecretConfig();
    }

    @GetMapping(value = "/api/rpc/dumb-client")
    public String callDumbClient() {
        return rpcService.callDumbClient();
    }

    @GetMapping(value = "/api/rpc/feign-client")
    public String callFeignClient() {
        return rpcService.callFeignClient();
    }

    @GetMapping(value = "/api/async/message")
    public String postMessage(@RequestParam String setting) {
        asyncService.postMessage(setting);
        return "message was send, check the bar service";
    }

}
