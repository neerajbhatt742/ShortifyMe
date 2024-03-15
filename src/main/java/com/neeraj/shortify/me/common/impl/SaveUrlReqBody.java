package com.neeraj.shortify.me.common.impl;

import com.neeraj.shortify.me.common.interfaces.IRequestBody;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveUrlReqBody implements IRequestBody {
    String url;
}
