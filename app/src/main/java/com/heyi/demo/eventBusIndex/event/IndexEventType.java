package com.heyi.demo.eventBusIndex.event;

public class IndexEventType {

    private String message;

    public IndexEventType(String message){
        this.message = message;
    }

    public String IndexEventType(){
        return message;
    }

}
