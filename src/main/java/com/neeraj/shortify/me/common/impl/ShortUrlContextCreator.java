package com.neeraj.shortify.me.common.impl;

import com.neeraj.shortify.me.common.interfaces.IContextCreator;
import com.neeraj.shortify.me.common.interfaces.IFetcher;
import com.neeraj.shortify.me.common.interfaces.IMapper;
import com.neeraj.shortify.me.common.interfaces.IResponse;
import com.neeraj.shortify.me.model.SavedUrls;
import com.neeraj.shortify.me.response.ShortUrlResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
public class ShortUrlContextCreator implements IContextCreator<SavedUrls> {

    @Autowired
    IFetcher<SavedUrls> fetchSavedUrl;
    @Autowired
    IMapper<SavedUrls, ShortUrlResponse> mapToShortUrl;

    @Override
    public List<IFetcher<SavedUrls>> getFetchers() {
        return List.of(fetchSavedUrl);
    }

    @Override
    public IMapper<SavedUrls, ShortUrlResponse> getMapper() {
        return mapToShortUrl;
    }
}
