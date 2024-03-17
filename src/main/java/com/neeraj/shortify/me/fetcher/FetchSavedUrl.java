package com.neeraj.shortify.me.fetcher;

import com.neeraj.shortify.me.common.impl.SaveUrlReqBody;
import com.neeraj.shortify.me.common.interfaces.IContext;
import com.neeraj.shortify.me.common.interfaces.IFetcher;
import com.neeraj.shortify.me.model.ShortUrl;
import com.neeraj.shortify.me.repository.ISavedUrlsRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class FetchSavedUrl implements IFetcher<ShortUrl> {

    @Autowired
    ISavedUrlsRepo savedUrlsRepo;
    @Override
    public void apply(IContext<ShortUrl> context) {
        SaveUrlReqBody req = (SaveUrlReqBody)context.getRequest();
        Specification<ShortUrl> specification = (root, query, builder)-> builder.equal(root.get("redirectUrl"), req.getUrl());
        context.setData(savedUrlsRepo.findOne(specification).orElse(null));
    }
}
