package com.epam.edp.foo.conroller;

import com.epam.edp.foo.service.FooService;
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
    private FooService fooService;

    @GetMapping(value = "/message")
    void postMessage(@RequestParam String body) {
        fooService.postMessage(body);
    }

}
