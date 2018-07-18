package com.epam.edp.foo.conroller;

import com.epam.edp.foo.dto.Response;
import com.epam.edp.foo.service.FooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pavlo_Yemelianov
 */
@RestController
public class FooController {

    @Value("${foo.config.default}")
    private String defaultProperties;

    @Value("${foo.config.profile}")
    private String profileProperties;

    @Autowired
    private FooService fooService;

    @GetMapping(value = "/message")
    void postMessage(@RequestParam String body) {
        fooService.postMessage(body);
    }

    @GetMapping(value = "/api/response")
    public Response getResponse(){
        Response response = new Response();
        return response;
    }

    @GetMapping(value = "/api/properties/default")
    public String getDefaultProperties() {
        return defaultProperties;
    }

    @GetMapping(value = "/api/properties/profile")
    public String getDeveloperProperties() {
        return profileProperties;
    }
}
