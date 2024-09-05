package com.spring.mvcproject.racinggame.engine;

import org.springframework.stereotype.Component;

@Component("electricEngine")
public class ElectricEngine implements Engine{

    @Override
    public String start(){
        return "Electric Engine is staring...";
    }
}
