package com.neutech.enumeration;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum BusinessStoreStatusEnum {

    UNAUDITED(1,"未审核"),
    NORMAL(2,"正常"),
    BAN(3,"已封禁");


    private Integer statusCode;
    private String statusMessage;

    public static BusinessStoreStatusEnum getInstance(Integer statusCode){
        for (BusinessStoreStatusEnum value : values()) {
            if (value.statusCode.equals(statusCode)){
                return value;
            }
        }
        return null;
    }


    BusinessStoreStatusEnum(Integer statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }
}
