package com.ertikmen.service;

import org.springframework.stereotype.Service;

@Service("cService")
public class CService implements SelectService{
    @Override
    public void sendMsg(String message) {
        System.out.println("Service C: "+message);
    }
}
