package com.neeraj.shortify.me.common.impl;

import com.neeraj.shortify.me.common.interfaces.IContext;
import com.neeraj.shortify.me.common.interfaces.IRequestBody;
import com.neeraj.shortify.me.model.ShortUrl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShortUrlContext implements IContext<ShortUrl> {
    ShortUrl data;
    IRequestBody request;
}
