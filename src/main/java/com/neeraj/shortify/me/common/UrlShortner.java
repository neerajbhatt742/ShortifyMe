package com.neeraj.shortify.me.common;

import com.google.common.hash.Hashing;
import io.micrometer.common.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

public class UrlShortner {
    public static String getShortUrl(String url){
        if(StringUtils.isNotEmpty(url)){
            return encodeUrl(url);
        }
        return null;
    }

    private static String encodeUrl(String url) {
        return Hashing
                .murmur3_32_fixed()
                .hashString(url.concat(LocalDateTime.now().toString()), StandardCharsets.UTF_8)
                .toString();
    }
}
