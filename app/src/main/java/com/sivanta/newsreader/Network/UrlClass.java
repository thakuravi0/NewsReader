package com.sivanta.newsreader.Network;

import com.sivanta.newsreader.dto.Source;

/**
 * Created by chandan on 5/17/2017.
 */

public class UrlClass
{
   public static String bbc_url="https://newsapi.org/v1/articles?source=bbc-news&sortBy=top&apiKey=22a7f031ea4d463b82d6bfffac2ec47c";
    public static String ccn_url="https://newsapi.org/v1/articles?source=cnn&sortBy=top&apiKey=22a7f031ea4d463b82d6bfffac2ec47c";
    public static String hindu_url="https://newsapi.org/v1/articles?source=the-hindu&sortBy=top&apiKey=22a7f031ea4d463b82d6bfffac2ec47c";
    public static String newyorkTime_url="https://newsapi.org/v1/articles?source=the-new-york-times&sortBy=top&apiKey=22a7f031ea4d463b82d6bfffac2ec47c";
    public static String telegraph_url="https://newsapi.org/v1/articles?source=the-telegraph&sortBy=top&apiKey=22a7f031ea4d463b82d6bfffac2ec47c";
    public static String time=" https://newsapi.org/v1/articles?source=time&sortBy=top&apiKey=22a7f031ea4d463b82d6bfffac2ec47c";
    // ArrayList<String> urlList=new ArrayList();
    static Source source;
   final static String[] urlArray={bbc_url,ccn_url,hindu_url,newyorkTime_url,telegraph_url,telegraph_url,time};


   public  String getInti(int pos)
   {


       return urlArray[pos];

   }


}
