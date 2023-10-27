package com.ertikmen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MessageProccessorImpl  implements MessageProccessor{
    @Autowired
    @Qualifier("bService")
    private SelectService selectService;


//    public MessageProccessorImpl(@Qualifier("aService") SelectService selectService){
//        this.selectService=selectService;
//    }

    public void setSelectService(SelectService selectService) {
        this.selectService = selectService;
    }

    @Override
    public void processingMsg(String message) {
        selectService.sendMsg(message);
    }
}
