package com.sivanta.newsreader.Network;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.sivanta.newsreader.MaterialTest.MyApplication;

/**
 * Created by chandan on 5/15/2017.
 */

public class VolleySingleton
{
    private static VolleySingleton volleySingleton=null;
    private static RequestQueue requestQueue;
    private static ImageLoader imageLoader;
    private VolleySingleton()
    {
        requestQueue=Volley.newRequestQueue(MyApplication.getAppContext());
        imageLoader=new ImageLoader(requestQueue, new ImageLoader.ImageCache() {
            private LruCache<String,Bitmap> cache=new LruCache<>((int)(Runtime.getRuntime().maxMemory()/1024)/8);

            @Override
            public Bitmap getBitmap(String url) {

                return cache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                 cache.put(url,bitmap);

            }
        });
    }
    public static VolleySingleton getInstance()
    {
        if(volleySingleton==null)
        {
            volleySingleton=new VolleySingleton();
        }
        return volleySingleton;
    }
    public static RequestQueue getRequestQueue()
    {
        return requestQueue;
    }
    public static ImageLoader getImageLoader()
    {
        return imageLoader;
    }
}
