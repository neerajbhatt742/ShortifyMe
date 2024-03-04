package com.neeraj.shortify.me.repository;

import com.neeraj.shortify.me.model.SavedUrls;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISavedUrlsRepo extends JpaRepository<SavedUrls, Long> {
}
