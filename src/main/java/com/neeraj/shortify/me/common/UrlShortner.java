package com.neeraj.shortify.me.common;

import org.springframework.util.StringUtils;

public class UrlShortner {
    public static String getShortUrl(String url){
        if(StringUtils.hasText("http")){
            url = StringUtils.replace(url, "http", "");
        }
        return url;
    }
}
