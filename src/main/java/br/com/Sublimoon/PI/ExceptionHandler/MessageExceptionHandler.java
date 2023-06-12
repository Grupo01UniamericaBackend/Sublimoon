package br.com.Sublimoon.PI.ExceptionHandler;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class MessageExceptionHandler {

    @Getter @Setter
    private Date timestamp;
    @Getter @Setter
    private Integer status;
    @Getter @Setter
    private String message;

    public MessageExceptionHandler(Date timestamp, Integer status, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
    }


}
