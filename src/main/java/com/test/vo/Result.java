package com.test.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private Integer code;
    private String msg;
    private Boolean flag;
    private T data;

    public static <T> Result<T> success(T data) {
        return new Result<>(200, "success", true, data);
    }

    public static <T> Result<T> error(Integer code, String msg) {
        return new Result<>(code, msg, false, null);
    }
}