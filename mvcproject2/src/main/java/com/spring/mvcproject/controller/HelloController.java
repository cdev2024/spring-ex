package com.spring.mvcproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class HelloController {

    // http://localhost:8080/hello
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    // http://localhost:8080/requestMappingGetTest
    @RequestMapping(value="/requestMappingGetTest", method= RequestMethod.GET)
    public String requestMappingGetTest(Model model){
        model.addAttribute("textFromControler", "World");
        model.addAttribute("textFromController2", "JJJJJJJJ");
        return "requestHello";
    }

    // [오류] http://localhost:8080/requestPramTest
    // http://localhost:8080/requestPramTest?b=anyString
    // http://localhost:8080/requestPramTest?a=1&b=anyString&c=false
    @RequestMapping("/requestPramTest")
    public String requestPramTest(
            @RequestParam(name="a", required = false, defaultValue = "0") int a,
            @RequestParam("b") String b,
            @RequestParam(name="c", defaultValue = "true") boolean c
    ){
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        return "hello";
    }

    // http://localhost:8080/requestParamMapTest?param1=value1&param2=value2&param3=value3
    @RequestMapping("/requestParamMapTest")
    public String requestParamMapText(
            @RequestParam Map<String,String> map){
        for(Map.Entry<String, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        return "hello";
    }

    // [오류] http://localhost:8080/pathVariableTest
    // [오류] http://localhost:8080/pathVariableTest/spring/test/complete
    // http://localhost:8080/pathVariableTest/spring/test/2024
    @RequestMapping("/pathVariableTest/{a}/{b}/{c}")
    public String pathVariableTest(
            @PathVariable(value="a") String a,
            @PathVariable String b,
            @PathVariable int c
    ){
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        return "hello";
    }
}
