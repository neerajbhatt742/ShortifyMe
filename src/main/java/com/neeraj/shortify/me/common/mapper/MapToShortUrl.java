package com.neeraj.shortify.me.common.mapper;

import com.neeraj.shortify.me.common.interfaces.IContext;
import com.neeraj.shortify.me.common.interfaces.IMapper;
import com.neeraj.shortify.me.model.SavedUrls;
import com.neeraj.shortify.me.response.ShortUrlResponse;

import java.util.List;

public class MapToShortUrl implements IMapper<SavedUrls, ShortUrlResponse> {

    @Override
    public ShortUrlResponse apply(IContext<SavedUrls> context) {
        List<SavedUrls> savedUrls = context.getData();
        savedUrls.stream().map(SavedUrls::getRedirectUrl);

        return null;
    }
}
