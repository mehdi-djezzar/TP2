package com.example.djezzame.channelmessaging;

import java.util.HashMap;

/**
 * Created by djezzame on 19/01/2018.
 */
public class PostRequest {

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public HashMap<String, String> getParams() {
        return params;
    }

    public void setParams(HashMap<String, String> params) {
        this.params = params;
    }

    private String URL;
    private HashMap<String,String > params;



}

