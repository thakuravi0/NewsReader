package com.sivanta.newsreader;

/**
 * Created by chandan on 5/13/2017.
 */

public class Model
{
    private String title;
    private String description;

    public Model(String title, String urlToImage,String description) {
        this.title = title;
        this.urlToImage = urlToImage;
        this.description=description;
    }

    private String url;
    private String urlToImage;
    private String publishedAt;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }
}
