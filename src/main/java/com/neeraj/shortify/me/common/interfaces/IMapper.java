package com.neeraj.shortify.me.common.interfaces;


public interface IMapper<A,T> {
    public T apply(IContext<A> context);
}
