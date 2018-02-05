package com.example.djezzame.channelmessaging;

/**
 * Created by djezzame on 05/02/2018.
 */
public class Access {

    private  String response;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAccesstoken() {
        return accesstoken;
    }

    public void setAccesstoken(String accesstoken) {
        this.accesstoken = accesstoken;
    }

    private String code;
    private String accesstoken;
}
