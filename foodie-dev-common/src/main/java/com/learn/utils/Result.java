package com.learn.utils;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class Result {
    
    private int status;
    
    private String msg;
    
    private Object data;
    
    public Result(int status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
    
    public static Result ok(Object data) {
        return new Result(HttpStatus.OK.value(), "success", data);
    }

    public static Result ok() {
        return Result.ok(null);
    }
    
    public static Result errorMsg(String msg) {
        return new Result(HttpStatus.BAD_REQUEST.value(), msg, null);
    }
    
    public static Result errorMap(Object data) {
        return new Result(HttpStatus.BAD_REQUEST.value(), "error", data);
    }
    
    public static Result errorTokenMsg(String msg) {
        return new Result(HttpStatus.UNAUTHORIZED.value(), msg, null);
    }

}
