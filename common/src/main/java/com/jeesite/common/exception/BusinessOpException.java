package com.jeesite.common.exception;

import com.jeesite.common.constant.Status;
import lombok.Getter;

@Getter
public class BusinessOpException extends BaseException {

    public BusinessOpException(Status status) {
        super(status);
    }

    public BusinessOpException(Integer code, String message) {
        super(code, message);
    }
}