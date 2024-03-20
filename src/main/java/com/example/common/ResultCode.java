package com.example.common;

public enum ResultCode {
    SUCCESS("0", "成功"),
    ERROR("-1", "系统异常"),
    PARAM_ERROR("1001", "参数异常"),
    USER_EXIST_ERROR("2001", "用户已存在"),
    USER_ACCOUNT_ERROR("2002", "账号或密码错误"),
    USER_NOT_EXIST_ERROR("2003", "未找到用户"),
    Time_ERROR("3001", "当前名称的场地设置的时间在另一个同名场地设置的时间的中间，错误"),
    PARAM_LOST_ERROR("2004", "参数缺失"),
    PARAM_PASSWORD_ERROR("2005", "原密码输入错误"),
    ;

    public String code;
    public String msg;

    ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
