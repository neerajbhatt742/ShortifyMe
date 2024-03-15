package com.neeraj.shortify.me.response;

import com.neeraj.shortify.me.common.interfaces.IResponse;
import com.neeraj.shortify.me.model.SavedUrls;
import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ShortUrlResponse implements IResponse<SavedUrls> {
    private SavedUrls data;
    private HttpStatus responseStatus;
    ShortUrlResponse(){
        responseStatus = HttpStatus.CREATED;
    }
}
