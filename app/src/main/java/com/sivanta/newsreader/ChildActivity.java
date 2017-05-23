package com.sivanta.newsreader;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ChildActivity extends AppCompatActivity {
    ImageView imageView;
    TextView titleTv;
    TextView disTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        imageView= (ImageView) findViewById(R.id.imageView);
        titleTv= (TextView) findViewById(R.id.titletv);
        disTv= (TextView) findViewById(R.id.distv);
         Intent intent=getIntent();
        String title=intent.getStringExtra("title");
        String urlToImage=intent.getStringExtra("urlToImage");
        String description=intent.getStringExtra("description");
        titleTv.setText(title);
        Picasso.with(this).load(Uri.parse(urlToImage)).into(imageView);
        disTv.setText(description);
    }
}
