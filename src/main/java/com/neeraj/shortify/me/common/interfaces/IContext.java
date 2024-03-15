package com.neeraj.shortify.me.common.interfaces;

import java.util.List;

public interface IContext<T> {
    List<T> getData();
    IRequestBody getRequest();
    void setRequest(IRequestBody request);
}
