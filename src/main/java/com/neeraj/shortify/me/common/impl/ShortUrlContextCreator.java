package com.neeraj.shortify.me.common.impl;

import com.neeraj.shortify.me.common.interfaces.IContextCreator;
import com.neeraj.shortify.me.common.interfaces.IFetcher;
import com.neeraj.shortify.me.common.interfaces.IMapper;
import com.neeraj.shortify.me.model.ShortUrl;
import com.neeraj.shortify.me.response.ShortUrlResponse;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
public class ShortUrlContextCreator implements IContextCreator<ShortUrl> {

    @Autowired
    IFetcher<ShortUrl> fetchSavedUrl;
    @Autowired
    IMapper<ShortUrl, ShortUrlResponse> mapToShortUrl;

    @Override
    public List<IFetcher<ShortUrl>> getFetchers() {
        return List.of(fetchSavedUrl);
    }

    @Override
    public IMapper<ShortUrl, ShortUrlResponse> getMapper() {
        return mapToShortUrl;
    }
}
