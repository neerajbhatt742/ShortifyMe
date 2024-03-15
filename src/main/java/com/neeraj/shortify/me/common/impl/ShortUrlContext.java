package com.neeraj.shortify.me.common.impl;

import com.neeraj.shortify.me.common.interfaces.IContext;
import com.neeraj.shortify.me.common.interfaces.IRequestBody;
import com.neeraj.shortify.me.model.SavedUrls;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ShortUrlContext implements IContext<SavedUrls> {
    List<SavedUrls> data;
    IRequestBody request;

    public ShortUrlContext(){
        data = new ArrayList<>();
    }
}
