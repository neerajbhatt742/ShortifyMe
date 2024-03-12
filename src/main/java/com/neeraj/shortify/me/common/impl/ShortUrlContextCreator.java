package com.neeraj.shortify.me.common.impl;

import com.neeraj.shortify.me.common.interfaces.IContextCreator;
import com.neeraj.shortify.me.common.interfaces.IFetcher;
import com.neeraj.shortify.me.common.interfaces.IMapper;
import com.neeraj.shortify.me.common.interfaces.IResponse;
import com.neeraj.shortify.me.model.SavedUrls;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ShortUrlContextCreator implements IContextCreator<SavedUrls> {

    @Autowired
    IFetcher<SavedUrls> fetchSavedUrl;

    @Override
    public List<IFetcher<SavedUrls>> getFetchers() {
        return List.of(fetchSavedUrl);
    }

    @Override
    public IMapper<SavedUrls,IResponse<SavedUrls>> getMapper() {
        return null;
    }
}
