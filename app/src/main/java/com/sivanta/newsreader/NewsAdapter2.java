package com.sivanta.newsreader;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.sivanta.newsreader.Network.VolleySingleton;

import java.util.List;

/**
 * Created by chandan on 5/13/2017.
 */

public class NewsAdapter2 extends RecyclerView.Adapter<NewsAdapter2.MyViewHolder>
{
    Context context;
    private List<Model> modelList;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.hrow_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Model model=modelList.get(position);
        holder.htitle.setText(model.getTitle());
        String imvUrl=model.getUrlToImage();
        if(imvUrl!=null)
        {
        VolleySingleton.getImageLoader().get(imvUrl, new ImageLoader.ImageListener() {
            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
              holder.himv.setImageBitmap(response.getBitmap());
            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }
            });
        }
       // Picasso.with(context).load(Uri.parse(model.getUrlToImage())).resize(70,70).into(holder.himv);
        holder.htitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"tittle has clicked",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(v.getContext(),ChildActivity.class);
                intent.putExtra("title",modelList.get(position).getTitle().toString());
                intent.putExtra("urlToImage",modelList.get(position).getUrlToImage().toString());
                intent.putExtra("description",modelList.get(position).getDescription().toString());
                v.getContext().startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView htitle;
        ImageView himv;
        public MyViewHolder(View itemView)
        {
            super(itemView);
            htitle=(TextView)itemView.findViewById(R.id.htitle);
            himv= (ImageView) itemView.findViewById(R.id.himv);
        }

    }

    public NewsAdapter2(Context context , List<Model> modelList) {
        this.modelList = modelList;
        this.context=context;
    }
}