package com.app.network.beans;

import com.google.gson.annotations.SerializedName;

/**
 * @author:create by ys
 * 时间:2021/7/5 14
 * 邮箱 894417048@qq.com
 */
public class BaseResponse<T> {

    @SerializedName("showapi_res_code")
    private int code;
    @SerializedName("showapi_res_error")
    private String erroMsg;
    @SerializedName("showapi_res_id")
    private String apiId;
    @SerializedName("showapi_res_body")
    private T result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErroMsg() {
        return erroMsg;
    }

    public void setErroMsg(String erroMsg) {
        this.erroMsg = erroMsg;
    }

    public String getApiId() {
        return apiId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}