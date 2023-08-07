package com.jeesite.common.constant;

import lombok.Getter;

@Getter
public enum Status {
    OK(200, "操作成功"),
    UNKNOWN_ERROR(500, "服务内部错误");
    private Integer code;
    private String message;
    Status(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
