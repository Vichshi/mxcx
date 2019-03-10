package com.orange.sh.contract.type;

import lombok.Getter;

@Getter
public enum ErrorCode {

	SUCCESS(0, "success"),
    SERVER_ERROR(9999, "system error"),
    REQUEST_ERROR(400, "请求错误"),
    UNAUTHORIZED(401, "未授权"),
    NOT_ACCESSIBLE(403, "不可访问"),
    METHOD_NOT_ALLOWED(405, "方法不被允许"),
    UNSUPPORTED_MEDIA_TYPE(415, "不支持当前媒体类型"),
    TOKEN_LOSE_EFFICACY(1001,"您的登录令牌已失效，请重新登录"),
    //
    //
    ;

    private int code;

    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ErrorCode getByCode(int code) {

        for (ErrorCode errorCode : ErrorCode.values()) {
            if (errorCode.getCode() == code ) {
                return errorCode;
            }
        }

        return null;
    }
}
