package com.neeraj.shortify.me.response;

import com.neeraj.shortify.me.common.interfaces.IResponse;
import com.neeraj.shortify.me.model.SavedUrls;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
public class ShortUrlResponse implements IResponse<SavedUrls> {
    private String shortUrl;
    private HttpStatus responseStatus;
    ShortUrlResponse(){
        responseStatus = HttpStatus.CREATED;
    }
}
