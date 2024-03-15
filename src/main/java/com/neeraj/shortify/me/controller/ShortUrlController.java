package com.neeraj.shortify.me.controller;

import com.neeraj.shortify.me.common.impl.SaveUrlReqBody;
import com.neeraj.shortify.me.common.impl.ShortUrlContext;
import com.neeraj.shortify.me.common.interfaces.IContext;
import com.neeraj.shortify.me.common.interfaces.IContextCreator;
import com.neeraj.shortify.me.common.interfaces.IResponse;
import com.neeraj.shortify.me.fetcher.FetchSavedUrl;
import com.neeraj.shortify.me.model.SavedUrls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/urls")
public class ShortUrlController {

    @Autowired
    FetchSavedUrl fetchSavedUrl;

    @Autowired
    IContextCreator<SavedUrls> shortUrlContextCreator;

    @GetMapping("/findall")
    public ResponseEntity<String> getUrls(){
        fetchSavedUrl.apply(new ShortUrlContext());
        return ResponseEntity.ok("checking");
    }

    @PostMapping("/")
    public ResponseEntity<Object> shortUrl(@RequestBody SaveUrlReqBody saveUrlReqBody){
        IContext<SavedUrls> context = new ShortUrlContext();
        context.setRequest(saveUrlReqBody);
        IResponse<SavedUrls> response = shortUrlContextCreator.apply(context);
        return new ResponseEntity<>(response.getData(), response.getResponseStatus());
    }
}
