package com.ssrs.framework.web;


import com.ssrs.framework.ResponseData;
import com.ssrs.framework.web.util.AntiSQLFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controller父类
 *
 * @author ssrs
 */
public class BaseController {

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;

    /**
     * 成功的ApiResponses
     *
     * @return
     */
    public static <T> ApiResponses<T> success(T object) {
        return ApiResponses.<T>success(object);
    }

    /**
     * 成功的ApiResponses
     *
     * @return
     */
    public static <T> ApiResponses<T> success(String message) {
        return ApiResponses.<T>success(message, null);
    }

    /**
     * 成功的ApiResponses
     *
     * @return
     */
    public static <T> ApiResponses<T> success(String message, T object) {
        return ApiResponses.<T>success(message, object);
    }

    /**
     * 失败的ApiResponses
     *
     * @return
     */
    public static <T> ApiResponses<T> failure(String message) {
        ErrorCode errorCode = ErrorCode.builder().httpCode(ResponseData.FAILED)
                .message(message)
                .build();
        return ApiResponses.failure(errorCode, null);
    }

    /**
     * 失败的ApiResponses
     *
     * @return
     */
    public static <T> ApiResponses<T> failure(int status, String message) {
        ErrorCode errorCode = ErrorCode.builder().httpCode(status)
                .message(message)
                .build();
        return ApiResponses.failure(errorCode, null);
    }

    /**
     * 空的ApiResponses
     *
     * @return
     */
    public static ApiResponses<Void> empty() {
        return ApiResponses.empty();
    }

    /**
     * 获取安全参数(SQL ORDER BY 过滤)
     *
     * @param parameter
     * @return
     */
    protected String[] getParameterSafeValues(String[] parameter) {
        return AntiSQLFilter.getSafeValues(parameter);
    }

    protected String getParameterSafeValue(String parameter) {
        return AntiSQLFilter.getSafeValue(parameter);
    }

}
