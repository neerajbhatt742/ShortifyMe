package com.neeraj.shortify.me.common.interfaces;

import java.util.List;

public interface IFetcher<T> {
    public void apply(IContext<T> context);
}
