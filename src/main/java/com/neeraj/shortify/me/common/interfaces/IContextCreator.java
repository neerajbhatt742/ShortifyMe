package com.neeraj.shortify.me.common.interfaces;


import java.util.List;

public interface IContextCreator<T> {
    List<IFetcher<T>> getFetchers();
    IMapper<T, ? extends IResponse<T>> getMapper();

    public default IResponse<T> apply(IContext<T> context){
        getFetchers().forEach(iFetcher -> iFetcher.apply(context));
        return getMapper().apply(context);
    }
}
