package com.sivanta.newsreader.dto;

/**
 * Created by chandan on 5/12/2017.
 */

public class Articles
{
    private String title;
    private String description;
    private String disUrl;
    private String urlToImage;
    private String publishedAt;


    public Articles(String title, String urlToImage,String description,String disUrl) {
        this.title = title;
        this.urlToImage = urlToImage;
        this.description=description;
       // this.publishedAt=publishedAt;
        this.disUrl=disUrl;
    }



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

    public String getDisUrl() {
        return disUrl;
    }

    public void setDisUrl(String disUrl) {
        this.disUrl = disUrl;
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
