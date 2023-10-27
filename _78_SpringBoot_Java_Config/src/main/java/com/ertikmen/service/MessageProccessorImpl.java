package com.ertikmen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MessageProccessorImpl  implements MessageProccessor{

    private SelectService selectService;

    @Autowired
    public MessageProccessorImpl(@Qualifier("aService") SelectService selectService){
        this.selectService=selectService;
    }

    public void setSelectService(SelectService selectService) {
        this.selectService = selectService;
    }

    @Override
    public void processingMsg(String message) {
        selectService.sendMsg(message);
    }
}
