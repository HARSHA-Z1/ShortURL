package com.shortURL;

import com.shortURL.DTO.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UrlService {

    @Autowired
    UrlRepository urlRepository;

    @Autowired
    Encoding encoding;

    public String createShortUrl(String serviceUrl){

        Schema schema = new Schema();
        schema.setLongUrl(serviceUrl);

        urlRepository.save(schema);

        String shortUrl =  encoding.generateUrl(schema.getId());
        schema.setShortUrl(shortUrl);
        urlRepository.save(schema);

        return shortUrl;
    }

    public String getLongUrl(String pathVariable){
        Optional<Schema> optionalUrl = urlRepository.findByShortUrl(pathVariable);
        String longUrl = optionalUrl.map(Schema::getLongUrl)
                .orElseThrow(() -> new RuntimeException("Not found"));
        return longUrl;
    }
}

