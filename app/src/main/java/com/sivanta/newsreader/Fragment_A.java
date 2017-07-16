package com.sivanta.newsreader;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.sivanta.newsreader.Network.VolleySingleton;
import com.sivanta.newsreader.dto.Articles;
import com.sivanta.newsreader.dto.News;
import com.sivanta.newsreader.util.NetworkUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by chandan on 5/12/2017.
 */

public class Fragment_A extends android.support.v4.app.Fragment
{
    News news;
    ProgressBar progressBar;
    private String TAG ;
    private RecyclerView recyclerView;
    ArrayList<Articles> articlesArrayList;
    HashMap<String,String> params;
    Home home;
    String source;

   // String url="https://newsapi.org/v1/articles?source=the-hindu&sortBy=top&apiKey=22a7f031ea4d463b82d6bfffac2ec47c";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        Bundle bundle = getArguments();
        Log.d("arg", bundle.toString());
        source = bundle.getString("news").toString();

     /*   if (bundle!=null)
        {
            source=bundle.getString("news");

            Log.d("gotit",source);
        } */
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        progressBar= (ProgressBar) view.findViewById(R.id.progressBar);
        articlesArrayList = new ArrayList<>();
        recyclerView = (RecyclerView) view.findViewById(R.id.rlv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setVisibility(View.GONE);

        //
        // new GetNews().execute();
        // String s1=home.sourcList.get("source");

        //  Log.d("valueatA", String.valueOf(s1));
        // String uri = "https://newsapi.org/v1/articles?source="+source+"&sortBy=top&apiKey=22a7f031ea4d463b82d6bfffac2ec47c";
        if (!NetworkUtil.getConnectivityStatus(getActivity())) {
            progressBar.setVisibility(View.GONE);
            AlertDialog alertDialog = new AlertDialog.Builder(this.getContext()).create();
            alertDialog.setTitle("Alert");
            alertDialog.setMessage("You are offline!");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            alertDialog.show();


        }
                   RequestQueue requestQueue = VolleySingleton.getInstance().getRequestQueue();
            Log.d("urll", source);
            // String ss= "https://newsapi.org/v1/articles?source=cnn-news&sortBy=top&apiKey=22a7f031ea4d463b82d6bfffac2ec47c";

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, source, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    if (response.has("articles")) {
                        try {
                            JSONArray articles = response.getJSONArray("articles");
                            for (int i = 0; i < articles.length(); i++) {
                                JSONObject jsonObject = articles.getJSONObject(i);
                                String title = jsonObject.getString("title");
                                String urlToImage = jsonObject.getString("urlToImage");
                                String description = jsonObject.getString("description");
                                String publishedAt=jsonObject.getString("publishedAt");
                                String disUrl=jsonObject.getString("url");
                                articlesArrayList.add(new Articles(title,urlToImage,description,disUrl));
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    } else {
                        Log.e(TAG, "Couldn't get json value from server.");
                    }
                    NewsAdapter newsAdapter = new NewsAdapter(getActivity(), articlesArrayList);
                    recyclerView.setAdapter(newsAdapter);
                    progressBar.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);


                }

            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }

            }) {

            };
            requestQueue.add(jsonObjectRequest);

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
        protected Void doInBackground(Void... params)
        {
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
                        String description=jsonObject.getString("description");
                        articlesArrayList.add(new Articles(title,urlToImage,description));
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
           NewsAdapter newsAdapter =new NewsAdapter(getActivity(),articlesArrayList);
            recyclerView.setAdapter(newsAdapter);
        }
    }*/

}

