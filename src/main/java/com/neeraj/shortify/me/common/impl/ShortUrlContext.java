package com.neeraj.shortify.me.common.impl;

import com.neeraj.shortify.me.common.interfaces.IContext;
import com.neeraj.shortify.me.model.SavedUrls;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ShortUrlContext implements IContext<SavedUrls> {
    List<SavedUrls> data;
}
