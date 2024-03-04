package com.neeraj.shortify.me.controller;

import com.neeraj.shortify.me.common.impl.SaveUrlReqBody;
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
    @GetMapping("/findall")
    public ResponseEntity<List<SavedUrls>> getUrls(){
        return ResponseEntity.ok(fetchSavedUrl.getData());
    }

//    @PostMapping("/")
//    public ResponseEntity<List<SavedUrls>> saveUrls(@RequestBody SaveUrlReqBody saveUrlReqBody){
//
//        return ResponseEntity.ok(fetchSavedUrl.getData());
//    }
}
