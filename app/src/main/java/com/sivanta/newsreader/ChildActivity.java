package com.sivanta.newsreader;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ChildActivity extends AppCompatActivity {
    ImageView imageView;
    TextView titleTv;
    TextView disTv;
    TextView disUrlTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        imageView= (ImageView) findViewById(R.id.imageView);
        titleTv= (TextView) findViewById(R.id.titletv);
        disTv= (TextView) findViewById(R.id.distv);
        disUrlTv= (TextView) findViewById(R.id.disUrlTv);
         final Intent intent=getIntent();
        String title=intent.getStringExtra("title");
        String urlToImage=intent.getStringExtra("urlToImage");
        String description=intent.getStringExtra("description");
        final String disUrl=intent.getStringExtra("disUrl");
        titleTv.setText(title);
        disUrlTv.setText(disUrl);
        Picasso.with(this).load(Uri.parse(urlToImage)).into(imageView);
        disTv.setText(description);

        disUrlTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          Intent i =new Intent(ChildActivity.this,ViewActivity.class);
                i.putExtra("disUrl",disUrl);
       }
        });
    }
}
