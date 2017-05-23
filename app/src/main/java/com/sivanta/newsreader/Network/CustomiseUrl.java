package com.sivanta.newsreader.Network;

import java.util.HashMap;

/**
 * Created by chandan on 5/18/2017.
 */

public class CustomiseUrl {
    public static String getUrl(HashMap<String,String> sourceList)
    {
        return "https://newsapi.org/v1/articles?source=the-hindu&sortBy=top&apiKey=22a7f031ea4d463b82d6bfffac2ec47c";
    }
}
