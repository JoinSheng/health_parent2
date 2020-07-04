package com.health.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 封装返回结果
 */
@Data//lombok插件注解
@NoArgsConstructor//lombok插件注解
public class Result<T> implements Serializable {
    private boolean flag;//执行结果，true为执行成功 false为执行失败
    private String message;//返回结果信息
    private T data;//返回数据

    /**
     * 响应失败
     *
     * @param message
     */
    public Result(String message) {
        this.flag = false;
        this.message = "响应失败";
    }

    /**
     * 响应成功
     *
     * @param data
     */
    public Result(T data) {
        this.flag = true;
        this.message = "响应成功";
        this.data = data;
    }

    /**
     * 自定义响应结果
     *
     * @param flag
     * @param message
     * @param data
     */
    public Result(boolean flag, String message, T data) {
        this.flag = flag;
        this.message = message;
        this.data = data;
    }
}
