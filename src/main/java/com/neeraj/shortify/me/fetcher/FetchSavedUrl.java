package com.neeraj.shortify.me.fetcher;

import com.neeraj.shortify.me.common.interfaces.IContext;
import com.neeraj.shortify.me.common.interfaces.IFetcher;
import com.neeraj.shortify.me.model.SavedUrls;
import com.neeraj.shortify.me.repository.ISavedUrlsRepo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@Getter
public class FetchSavedUrl implements IFetcher<SavedUrls> {

    @Autowired
    ISavedUrlsRepo savedUrlsRepo;
    @Override
    public void apply(IContext<SavedUrls> context) {
        context.getData().addAll(savedUrlsRepo.findAll());
    }
}
