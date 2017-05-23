package com.sivanta.newsreader;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.sivanta.newsreader.Network.UrlAdapter;
import com.sivanta.newsreader.Network.UrlClass;
import com.sivanta.newsreader.Network.UrlClassB;

import java.util.HashMap;

public class Home extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Toolbar toolbar;
    TabLayout tabLayout;
    UrlAdapter urlAdapter;
   // String source;
  Bundle bundle;
   UrlClass urlClass;
    UrlClassB urlClassB;
   // static ArrayList<String> urlList;
    ViewPager viewPager;
    ViewPageAdapter viewPagerAdapter;
   public HashMap<String,String> sourcList;
    public HashMap<String,String> sourcListB;
    String[] category = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        urlAdapter=new UrlAdapter();
    //    urlList=new ArrayList<>();
        sourcList=new HashMap<String, String>();
        sourcListB=new HashMap<String, String>();
       urlClass =new UrlClass();
        urlClassB=new UrlClassB();
        bundle=new Bundle();

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        category = getResources().getStringArray(R.array.News_source);
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.News_source, android.R.layout.simple_spinner_item);

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(this);

       // String bb=bundle.getString("news");
        //Log.d("sos",bb);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);






    }
    private void setupViewPager(ViewPager viewPager,Bundle bundle) {
        viewPagerAdapter = new ViewPageAdapter(getSupportFragmentManager());
        Fragment_A fragment_a=new Fragment_A();
        fragment_a.setArguments(bundle);
        Fragment_B fragment_b=new Fragment_B();
        fragment_b.setArguments(bundle);
        viewPagerAdapter.addFragments(fragment_a, "Live Response");
        viewPagerAdapter.addFragments(fragment_b, "Latest Headlines");
        viewPager.setAdapter(viewPagerAdapter);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String urlv=urlClass.getInti(position);
        Log.d("getValue",urlv );
        switch (position)
        {
         /*   case 0: sourcList.put("source",UrlClass.getInti(position).get(position));
                sourcListB.put("sourceB", UrlClassB.getInti(position).get(position));
                Log.d("getHell",sourcList.put("source",UrlClass.getInti(position).get(position)));
                Log.d("getHell",sourcList.put("source",UrlClassB.getInti(position).get(position)));
                String s=sourcList.get("source");
                String sB=sourcListB.get("sourceB");
                bundle.putString("news",s);
                bundle.putString("newsB",sB);
                Log.d("getValues",s);
                Log.d("getValuesB",sB);
                Toast.makeText(getApplication(),"bbc news",Toast.LENGTH_SHORT).show();
                break; */
            case 1: sourcList.put("source",urlClass.getInti(position));
                sourcListB.put("sourceB",urlClassB.getInti(position));
                Log.d("hhh",urlClassB.getInti(position));
                Log.d("getHell",sourcList.put("source",urlClass.getInti(position)));
                Log.d("getHellB",sourcListB.put("sourceB",urlClassB.getInti(position)));
                String s1=sourcList.get("source");
                String sB1=sourcListB.get("sourceB");
                bundle.putString("news",s1);
                bundle.putString("newsB",sB1);
                Log.d("getValues",s1);
                Log.d("getValuesB",sB1);
                Toast.makeText(getApplication(),"ccn news",Toast.LENGTH_SHORT).show();
                break;
            case 2: sourcList.put("source",urlClass.getInti(position));
                sourcListB.put("sourceB",urlClassB.getInti(position));
                String s2=sourcList.get("source");
                String sB2=sourcListB.get("sourceB");
                bundle.putString("news",s2);
                bundle.putString("newsB",sB2);
                break;
            case 3: sourcList.put("source",urlClass.getInti(position));
                sourcListB.put("sourceB",urlClassB.getInti(position));
                String s3=sourcList.get("source");
                String sB3=sourcListB.get("sourceB");
                bundle.putString("news",s3);
                bundle.putString("newsB",sB3);
                break;
            case 4:sourcList.put("source",urlClass.getInti(position));
                sourcListB.put("sourceB",urlClassB.getInti(position));
                String s4=sourcList.get("source");
                String sB4=sourcListB.get("sourceB");
                bundle.putString("news",s4);
                bundle.putString("newsB",sB4);
                break;
            default: sourcList.put("source",urlClass.getInti(position));
                sourcListB.put("sourceB", urlClassB.getInti(position));
                Log.d("getHell",sourcList.put("source",urlClass.getInti(position)));
                Log.d("getHellB",sourcListB.put("sourceB",urlClassB.getInti(position)));
                String s=sourcList.get("source");
                String sB=sourcListB.get("sourceB");
                bundle.putString("news",s);
                bundle.putString("newsB",sB);
                Log.d("getValues",s);
                Log.d("getValuesB",sB);
                Toast.makeText(getApplication(),"bbc news",Toast.LENGTH_SHORT).show();
                break;
        }
        //  returnUrl(position);
        setupViewPager(viewPager,bundle);
        tabLayout.setupWithViewPager(viewPager);
        String ss= (String) bundle.get("news");
        Log.d("sss",ss);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



   }



