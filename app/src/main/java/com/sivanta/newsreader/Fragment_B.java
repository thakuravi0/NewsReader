package com.sivanta.newsreader;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.sivanta.newsreader.Network.VolleySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by chandan on 5/12/2017.
 */

public class Fragment_B extends android.support.v4.app.Fragment
{
    String TAG;
    String url;

    ArrayList<Model> modelArrayList;
  //  private String url="https://newsapi.org/v1/articles?source=the-times-of-india&sortBy=latest&apiKey=22a7f031ea4d463b82d6bfffac2ec47c";
    RecyclerView rlv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Bundle bundle=getArguments();
        Log.d("argB",bundle.toString());
        url=bundle.getString("newsB").toString();

        View view= inflater.inflate(R.layout.fragment_b,container,false);
        modelArrayList=new ArrayList<>();

        rlv= (RecyclerView) view.findViewById(R.id.rlv);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this.getActivity());
        rlv.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(rlv.getContext(),
                                                                              linearLayoutManager.getOrientation());
        rlv.addItemDecoration(dividerItemDecoration);
        RequestQueue requestQueue= VolleySingleton.getRequestQueue();
        Log.d("urllB",url);
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET,url, null, new Response.Listener<JSONObject>() {
                          @Override
                          public void onResponse(JSONObject response) {
                              if(response.has("articles"))
                              {
                                  try {
                                      JSONArray articles=response.getJSONArray("articles");
                                      for (int i=0;i<articles.length();i++)
                                      {
                                          JSONObject jsonObject=articles.getJSONObject(i);
                                          String title=jsonObject.getString("title");
                                          String urlToImage=jsonObject.getString("urlToImage");
                                          String description=jsonObject.getString("description");
                                          modelArrayList.add(new Model(title,urlToImage,description));
                                      }

                                  } catch (JSONException e) {
                                      e.printStackTrace();
                                  }}
                              else {
                                  Log.e(TAG, "Couldn't get json value from server.");
                              }
                              NewsAdapter2 newsAdapter2=new NewsAdapter2(getActivity(),modelArrayList);
                              rlv.setAdapter(newsAdapter2);
                          }


                      }, new Response.ErrorListener() {
                          @Override
                          public void onErrorResponse(VolleyError error) {

                          }
                      });
        requestQueue.add(jsonObjectRequest);
      //  new GetNews().execute();
        return view;
    }

 /*  private class GetNews extends AsyncTask<Void,Void,Void>
   {

       @Override
       protected void onPreExecute() {
           super.onPreExecute();
           Toast.makeText(getActivity(), "Json Data is downloading", Toast.LENGTH_LONG).show();
       }

       @Override
       protected Void doInBackground(Void... params) {
           HttpHandler hh = new HttpHandler();
           // Making a request to url and getting response
           String jsonStr = hh.makeServiceCall(url);
           if (jsonStr != null)
           {
               // Gson gson=new Gson();
               // news= gson.fromJson(jsonStr, News.class);
               try {
                   JSONObject object=new JSONObject(jsonStr);
                   JSONArray articles =object.getJSONArray("articles");
                   for (int i=0;i<articles.length();i++)
                   {
                       JSONObject jsonObject=articles.getJSONObject(i);
                       String title=jsonObject.getString("title");
                       String urlToImage=jsonObject.getString("urlToImage");
                       modelArrayList.add(new Model(title,urlToImage));
                   }

               } catch (JSONException e) {
                   e.printStackTrace();
               }
           }
           else {
               Log.e(TAG, "Couldn't get json from server.");
           }
           return null;
       }

       @Override
       protected void onPostExecute(Void aVoid) {
           super.onPostExecute(aVoid);
           NewsAdapter2 newsAdapter2=new NewsAdapter2(getActivity(),modelArrayList);
           rlv.setAdapter(newsAdapter2);
       }
   }*/
}
