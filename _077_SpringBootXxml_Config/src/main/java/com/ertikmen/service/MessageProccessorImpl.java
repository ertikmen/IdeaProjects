package com.ertikmen.service;

public class MessageProccessorImpl  implements MessageProccessor{

    private SelectService selectService;

    public void setSelectService(SelectService selectService) {
        this.selectService = selectService;
    }

    @Override
    public void processingMsg(String message) {
        selectService.sendMsg(message);
    }
}
