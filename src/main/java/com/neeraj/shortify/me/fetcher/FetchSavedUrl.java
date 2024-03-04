package com.neeraj.shortify.me.fetcher;

import com.neeraj.shortify.me.common.interfaces.IFetcher;
import com.neeraj.shortify.me.model.SavedUrls;
import com.neeraj.shortify.me.repository.ISavedUrlsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FetchSavedUrl implements IFetcher<SavedUrls> {

    @Autowired
    ISavedUrlsRepo savedUrlsRepo;
    @Override
    public List<SavedUrls> getData() {
        return savedUrlsRepo.findAll();
    }
}
