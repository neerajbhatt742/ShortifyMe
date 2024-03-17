package com.neeraj.shortify.me.response;

import com.neeraj.shortify.me.common.interfaces.IResponse;
import com.neeraj.shortify.me.dto.SavedUrlDto;
import com.neeraj.shortify.me.model.ShortUrl;
import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ShortUrlResponse implements IResponse<ShortUrl> {
    private SavedUrlDto data;
    private HttpStatus responseStatus;
    private String message;
    ShortUrlResponse(){
        responseStatus = HttpStatus.CREATED;
    }
}
