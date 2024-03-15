package com.neeraj.shortify.me.common.mapper;

import com.neeraj.shortify.me.common.UrlShortner;
import com.neeraj.shortify.me.common.impl.SaveUrlReqBody;
import com.neeraj.shortify.me.common.interfaces.IContext;
import com.neeraj.shortify.me.common.interfaces.IMapper;
import com.neeraj.shortify.me.model.SavedUrls;
import com.neeraj.shortify.me.repository.ISavedUrlsRepo;
import com.neeraj.shortify.me.response.ShortUrlResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
@Slf4j
public class MapToShortUrl implements IMapper<SavedUrls, ShortUrlResponse> {

    public  MapToShortUrl(){
        log.info("bean created MapToShortUrl");
    }

    @Autowired
    ISavedUrlsRepo savedUrlsRepo;
    @Override
    public ShortUrlResponse apply(IContext<SavedUrls> context) {
        List<SavedUrls> savedUrls = context.getData();
        SaveUrlReqBody req = (SaveUrlReqBody) context.getRequest();
        if(!savedUrls.isEmpty()){
            SavedUrls shortUrl = savedUrls.stream().findAny().get();
            return ShortUrlResponse.builder()
                    .data(shortUrl)
                    .responseStatus(HttpStatus.OK)
                    .build();
        }
        String shortUrl = UrlShortner.getShortUrl(req.getUrl());
        SavedUrls savedUrl = SavedUrls.builder()
                .shortId(shortUrl)
                .redirectUrl(req.getUrl()).build();
        savedUrl = savedUrlsRepo.save(savedUrl);
        return ShortUrlResponse.builder()
                .data(savedUrl)
                .responseStatus(HttpStatus.CREATED)
                .build();
    }
}
