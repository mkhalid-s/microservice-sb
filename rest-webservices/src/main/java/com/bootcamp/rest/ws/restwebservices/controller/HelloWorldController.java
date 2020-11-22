package com.bootcamp.rest.ws.restwebservices.controller;

import com.bootcamp.rest.ws.restwebservices.bean.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.ServerRequest;

import java.util.Locale;

@RestController
public class HelloWorldController {

    /*@Autowired
    private MessageSource resourceBundleMessageSource;*/

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/hello-world")
    public String helloWorldMethod() {
        return "Hello World";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBeanMethod() {
        return new HelloWorldBean("Hello World!");
    }

    @GetMapping("/hello-world/{msg}")
    public HelloWorldBean helloWordBeanPathVar(@PathVariable String msg) {
        return new HelloWorldBean(String.format("Hello World! , %s", msg));
    }

    /*@GetMapping("/hello-world-int")
    public String helloWordBeanPathVarI18n(@RequestHeader(name = HttpHeaders.ACCEPT_LANGUAGE , required = false) Locale locale) {
        return resourceBundleMessageSource.getMessage("gm.message", null, locale);
    }*/

    @GetMapping("/hello-world-int")
    public String helloWordBeanPathVarI18n2() {
        return messageSource.getMessage("gm.message", null, LocaleContextHolder.getLocale());
    }
}
