package com.neeraj.shortify.me.common.interfaces;

import java.util.List;

public interface IContext<T> {
    T getData();
    void setData(T data);
    IRequestBody getRequest();
    void setRequest(IRequestBody request);
}
