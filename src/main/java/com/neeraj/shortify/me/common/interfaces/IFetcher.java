package com.neeraj.shortify.me.common.interfaces;


public interface IFetcher<T> {
    public void apply(IContext<T> context);
}
