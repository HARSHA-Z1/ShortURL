package com.shortURL;

import com.shortURL.DTO.URL;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class UrlController {
    UrlService urlService;
    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }
    @PostMapping("/shorten")
    public URL shortUrl(@RequestBody URL url){
        return new URL("http://localhost:8080/"+urlService.createShortUrl(url.getUrl()));
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<Void>  longUrl(@PathVariable String shortUrl){
        try {
            String longUrl = urlService.getLongUrl(shortUrl);
            return ResponseEntity.status(HttpStatus.FOUND)
                    .header("Location", longUrl)
                    .build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}