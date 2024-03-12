package com.neeraj.shortify.me.common.interfaces;

import org.springframework.http.HttpStatus;

import java.util.List;

public interface IResponse<T> {
    public HttpStatus getResponseStatus();
}
