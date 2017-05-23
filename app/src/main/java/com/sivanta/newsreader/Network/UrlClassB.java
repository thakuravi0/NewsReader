package com.sivanta.newsreader.Network;

/**
 * Created by chandan on 5/20/2017.
 */

public class UrlClassB {
    public static String bbc_url="https://newsapi.org/v1/articles?source=bbc-sport&sortBy=top&apiKey=22a7f031ea4d463b82d6bfffac2ec47c";
    public static String ccn_url="https://newsapi.org/v1/articles?source=cnbc&sortBy=top&apiKey=22a7f031ea4d463b82d6bfffac2ec47c";
   public static String hindu_url="https://newsapi.org/v1/articles?source=the-hindu&sortBy=latest&apiKey=22a7f031ea4d463b82d6bfffac2ec47c";
    public static String newyorkTime_url=" https://newsapi.org/v1/articles?source=new-york-magazine&sortBy=latest&apiKey=22a7f031ea4d463b82d6bfffac2ec47c";
    public static String telegraph_url="https://newsapi.org/v1/articles?source=the-telegraph&sortBy=latest&apiKey=22a7f031ea4d463b82d6bfffac2ec47c";
    public static String time="https://newsapi.org/v1/articles?source=time&sortBy=latest&apiKey=22a7f031ea4d463b82d6bfffac2ec47c";
    final static String[] urlArray={bbc_url,ccn_url,hindu_url,newyorkTime_url,telegraph_url,telegraph_url,time};


    public  String getInti(int pos)
    {


        return urlArray[pos];

    }
}
