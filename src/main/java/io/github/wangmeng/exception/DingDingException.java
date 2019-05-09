package io.github.wangmeng.exception;

import lombok.Data;

@Data
public class DingDingException extends RuntimeException{

    protected String msg;

    public DingDingException(String msg){
        this.msg = msg;
    }
}
