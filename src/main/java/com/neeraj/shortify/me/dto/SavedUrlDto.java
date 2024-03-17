package com.neeraj.shortify.me.dto;

import java.time.LocalDateTime;

public record SavedUrlDto(String shortId, LocalDateTime expiresOn) {}