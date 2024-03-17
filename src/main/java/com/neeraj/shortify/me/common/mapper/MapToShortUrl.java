package com.neeraj.shortify.me.common.mapper;

import com.neeraj.shortify.me.common.UrlShortner;
import com.neeraj.shortify.me.common.impl.SaveUrlReqBody;
import com.neeraj.shortify.me.common.interfaces.IContext;
import com.neeraj.shortify.me.common.interfaces.IMapper;
import com.neeraj.shortify.me.dto.SavedUrlDto;
import com.neeraj.shortify.me.model.ShortUrl;
import com.neeraj.shortify.me.repository.ISavedUrlsRepo;
import com.neeraj.shortify.me.response.ShortUrlResponse;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Component
@Slf4j
public class MapToShortUrl implements IMapper<ShortUrl, ShortUrlResponse> {

    @Autowired
    ISavedUrlsRepo savedUrlsRepo;
    @Override
    public ShortUrlResponse apply(IContext<ShortUrl> context) {
        ShortUrl shortUrl = context.getData();
        SaveUrlReqBody req = (SaveUrlReqBody) context.getRequest();
        if(!Objects.isNull(shortUrl)){
            SavedUrlDto dto = mapToDto(shortUrl);
            return ShortUrlResponse.builder()
                    .data(dto)
                    .responseStatus(HttpStatus.OK)
                    .build();
        }
        String shortId = UrlShortner.getShortUrl(req.getUrl());
        ShortUrl savedUrl = ShortUrl.builder()
                .shortId(shortId)
                .redirectUrl(req.getUrl())
                .createdOn(LocalDateTime.now())
                .expiresOn(LocalDateTime.now().plusDays(30))
                .build();
        savedUrl = savedUrlsRepo.save(savedUrl);
        SavedUrlDto dto = mapToDto(savedUrl);
        return ShortUrlResponse.builder()
                .data(dto)
                .responseStatus(HttpStatus.CREATED)
                .build();
    }

    @Transactional(readOnly = true)
    public SavedUrlDto mapToDto(ShortUrl shortUrl){
        return new SavedUrlDto(shortUrl.getShortId(), shortUrl.getExpiresOn());
    }
}
