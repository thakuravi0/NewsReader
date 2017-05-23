package com.sivanta.newsreader.Network;

import java.util.ArrayList;

/**
 * Created by chandan on 5/17/2017.
 */

public class UrlAdapter
{
ArrayList<String> arrayList=new ArrayList();
    public String getSource() {
        return source;
    }

    public void setSource(int posiotion) {

        this.source = sourceList[posiotion];
    }

    String source;



    String[] sourceList={"bbc-news","cnn","the-hindu","the-new-york-times","the-telegraph","the-times-of-india","time"};


    /*String bbc="https://newsapi.org/v1/articles?source=bbc-news&sortBy=top&apiKey=22a7f031ea4d463b82d6bfffac2ec47c";
    String ccn=" https://newsapi.org/v1/articles?source=cnn&sortBy=top&apiKey=22a7f031ea4d463b82d6bfffac2ec47c";
    String the_hindu=" https://newsapi.org/v1/articles?source=the-hindu&sortBy=top&apiKey=22a7f031ea4d463b82d6bfffac2ec47c";
    String the_nework_time="https://newsapi.org/v1/articles?source=the-new-york-times&sortBy=top&apiKey=22a7f031ea4d463b82d6bfffac2ec47c";
    String the_telegraph=" https://newsapi.org/v1/articles?source=the-telegraph&sortBy=top&apiKey=22a7f031ea4d463b82d6bfffac2ec47c";
    String time_of_india="https://newsapi.org/v1/articles?source=the-times-of-india&sortBy=top&apiKey=22a7f031ea4d463b82d6bfffac2ec47c";
    String times="https://newsapi.org/v1/articles?source=time&sortBy=top&apiKey=22a7f031ea4d463b82d6bfffac2ec47c"; */


}
