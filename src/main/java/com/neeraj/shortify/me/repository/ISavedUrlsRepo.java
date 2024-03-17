package com.neeraj.shortify.me.repository;

import com.neeraj.shortify.me.dto.SavedUrlDto;
import com.neeraj.shortify.me.model.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ISavedUrlsRepo extends JpaRepository<ShortUrl, Long>, JpaSpecificationExecutor<ShortUrl> {
//    @Query("select new SavedUrlDto(shortId, expiresOn, visitHistory.size) from ShortUrl where id = :id")
//    @Query("""
//                select new SavedUrlDto(s.shortId, s.expiresOn)
//                from ShortUrl as s where s.id =:id
//           """)
//    SavedUrlDto getSavedUrlDtoById(@Param("id") Long id);

}
