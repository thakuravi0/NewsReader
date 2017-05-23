package com.sivanta.newsreader.dto;

import java.util.ArrayList;

/**
 * Created by chandan on 5/12/2017.
 */

public class News
{
    private ArrayList<Articles> articles;

    public ArrayList<Articles> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Articles> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "News{" +
                "articles=" + articles +
                '}';
    }
}
