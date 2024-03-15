package com.neeraj.shortify.me.repository;

import com.neeraj.shortify.me.model.SavedUrls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ISavedUrlsRepo extends JpaRepository<SavedUrls, Long>, JpaSpecificationExecutor<SavedUrls> {
}
