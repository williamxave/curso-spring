package com.williambohn.cursomc.controller.exception;

import java.io.Serializable;

//Classe auxiliar pra mostrar o erro e json bunitinho
public class StandarteError implements Serializable{
    private static final long serialVerionUID = 1l;
    
    private Integer status;
    private String msg;
    private Long timeStamp;


    public StandarteError(Integer status, String msg, Long timeStamp) {
        this.status = status;
        this.msg = msg;
        this.timeStamp = timeStamp;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }


}
