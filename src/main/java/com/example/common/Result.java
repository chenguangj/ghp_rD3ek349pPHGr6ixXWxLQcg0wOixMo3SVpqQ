package com.example.common;

//返回给前端的一个实体类，这里面的属性值可以让前端知道这一次响应的具体效应和结果
public class Result<T> {
    private String code;//这个表示状态码，如-1表示失败
    private String msg;//这里面存的是失败的信息，这样可以让前台的页面可以显示出失败的信息，让前台可以看到，这个用来做弹窗就很好
    private T data;//这个使用的是泛型，这里面存的是具体的数据，由于是泛型，所以可以得到各种各样的信息，这个常常用来做成功之后的数据返回给前台

    private Result(T data) {
        this.data = data;
    }

    public Result() {
    }

    public static Result success() {
        Result tResult = new Result<>();
        tResult.setCode(ResultCode.SUCCESS.code);
        tResult.setMsg(ResultCode.SUCCESS.msg);
        return tResult;
    }

    public static <T> Result<T> success(T data) {
        Result<T> tResult = new Result<>(data);
        tResult.setCode(ResultCode.SUCCESS.code);
        tResult.setMsg(ResultCode.SUCCESS.msg);
        return tResult;
    }

    public static Result error() {
        Result tResult = new Result<>();
        tResult.setCode(ResultCode.ERROR.code);
        tResult.setMsg(ResultCode.ERROR.msg);
        return tResult;
    }

    public static Result error(String code, String msg) {
        Result tResult = new Result<>();
        tResult.setCode(code);
        tResult.setMsg(msg);
        return tResult;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
