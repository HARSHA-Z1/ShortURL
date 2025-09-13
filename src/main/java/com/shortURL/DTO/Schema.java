package com.shortURL.DTO;
import com.shortURL.DTO.URL;
import jakarta.persistence.*;

@Entity
public class Schema {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "schema_seq")
    @SequenceGenerator(name = "schema_seq", sequenceName = "schema_id_seq", initialValue = 1000, allocationSize = 1)
    private Long id;
    @Column(length = 2000)
    private String longUrl;
    private String shortUrl;


    public Long getId() {
        return id;
    }
    public String getLongUrl() {
        return longUrl;
    }
    public String getShortUrl() {
        return shortUrl;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }
    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
}
