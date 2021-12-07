package com.test.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private Integer code;
    private String msg;
    private boolean success;
    private Object data;

    public static Result success(Object data) {
        return new Result(200, "success", true, data);
    }

    public static Result error(Integer code, String msg) {
        return new Result(code, msg, false, null);
    }

}
