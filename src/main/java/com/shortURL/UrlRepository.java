package com.shortURL;
import com.shortURL.DTO.Schema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<Schema, Long> {
    Optional<Schema> findByShortUrl(String shortUrl);
    Optional<Schema> findByLongUrl(String longUrl);
}