package com.neeraj.shortify.me.common.interfaces;

import java.util.List;

public interface IMapper<A,T> {
    public T apply(IContext<A> context);
}
