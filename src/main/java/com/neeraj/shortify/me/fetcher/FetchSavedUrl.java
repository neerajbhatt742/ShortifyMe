package com.neeraj.shortify.me.fetcher;

import com.neeraj.shortify.me.common.impl.SaveUrlReqBody;
import com.neeraj.shortify.me.common.interfaces.IContext;
import com.neeraj.shortify.me.common.interfaces.IFetcher;
import com.neeraj.shortify.me.model.SavedUrls;
import com.neeraj.shortify.me.repository.ISavedUrlsRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class FetchSavedUrl implements IFetcher<SavedUrls> {

    @Autowired
    ISavedUrlsRepo savedUrlsRepo;
    @Override
    public void apply(IContext<SavedUrls> context) {
        SaveUrlReqBody req = (SaveUrlReqBody)context.getRequest();
        Specification<SavedUrls> specification = (root, query, builder)-> builder.equal(root.get("redirectUrl"), req.getUrl());
        context.getData().addAll(savedUrlsRepo.findAll(specification));
    }
}
