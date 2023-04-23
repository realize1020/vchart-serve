package com.example.demo.common;

import lombok.Data;

@Data
public class Result<T> {

    //返回码
    private Integer code;

    //返回消息
    private String message;

    //返回数据
    private T data;

    public Result(){}

    // 返回数据
    protected static <T> Result<T> data(T data) {
        Result<T> result = new Result<T>();
        if (data != null)
            result.setData(data);
        return result;
    }

    public static <T> Result<T> data(T body, Integer code, String message) {
        Result<T> result = data(body);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static <T> Result<T> data(T body, ResultCodeEnum resultCodeEnum) {
        Result<T> result = data(body);
        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());
        return result;
    }

    public static<T> Result<T> success(){
        return Result.success(null);
    }

    /**
     * 操作成功
     * @param data  baseCategory1List
     * @param <T>
     * @return
     */
    public static<T> Result<T> success(T data){
        Result<T> result = data(data);
        return data(data, ResultCodeEnum.SUCCESS);
    }

    public static<T> Result<T> success(String message){
        Result<T> result = data(null,ResultCodeEnum.SUCCESS.getCode(),message);
        return data(null,ResultCodeEnum.SUCCESS.getCode(),message);
    }

    public static<T> Result<T> fail(){
        return Result.fail(null);
    }

    /**
     * 操作失败
     * @param data
     * @param <T>
     * @return
     */
    public static<T> Result<T> fail(T data){
        Result<T> result = data(data);
        return data(data, ResultCodeEnum.FAIL);
    }
    public static<T> Result<T> fail(String message){
        Result<T> result = data(null,ResultCodeEnum.FAIL.getCode(),message);
        return data(null,ResultCodeEnum.FAIL.getCode(),message);
    }

    public Result<T> message(String msg){
        this.setMessage(msg);
        return this;
    }

    public Result<T> code(Integer code){
        this.setCode(code);
        return this;
    }
}
