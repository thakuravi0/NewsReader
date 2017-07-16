package com.sivanta.newsreader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.sivanta.newsreader.Network.VolleySingleton;
import com.sivanta.newsreader.dto.Articles;

import java.util.List;

/**
 * Created by chandan on 5/12/2017.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder>
{
    Context context;
    private List<Articles> articlesList;
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        Articles articles=articlesList.get(position);
         holder.title.setText(articles.getTitle());
        String imgUrl=articles.getUrlToImage();
        if(imgUrl!=null)
        {
            VolleySingleton.getImageLoader().get(imgUrl, new ImageLoader.ImageListener() {
                @Override
                public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                    holder.imv.setImageBitmap(response.getBitmap());
                }

                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
        }
       // Picasso.with(context).load(Uri.parse(articles.getUrlToImage())).into(holder.imv);
        holder.title.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
              //  Toast.makeText(v.getContext(),"tittle has clicked",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(v.getContext(),ChildActivity.class);
                intent.putExtra("title",articlesList.get(position).getTitle().toString());
                intent.putExtra("urlToImage",articlesList.get(position).getUrlToImage().toString());
                intent.putExtra("description",articlesList.get(position).getDescription().toString());
                intent.putExtra("disUrl",articlesList.get(position).getDisUrl().toString());
                ActivityOptionsCompat option=ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) v.getContext(),holder.imv,holder.imv.getTransitionName());
                v.getContext().startActivity(intent,option.toBundle());


            }
        });





    }

    @Override
    public int getItemCount()
    {
        return articlesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView title;
        ImageView imv;
    public MyViewHolder(View itemView)
         {
        super(itemView);
        title=(TextView)itemView.findViewById(R.id.title);
        imv= (ImageView) itemView.findViewById(R.id.imv);

       }


    }

    public NewsAdapter(Context context , List<Articles> articlesList) {
        this.articlesList = articlesList;
        this.context=context;
    }
}
