package com.example.djezzame.channelmessaging;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.HashMap;

/**
 * Created by djezzame on 05/02/2018.
 */
public class ChannelListActivity extends Activity implements  View.OnClickListener,OnDownloadListener  {
    private String odoo="odoo";
    private ListView lvMyListView;
    private String[] listItems;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel);
        HashMap<String,String> paramsPost=new HashMap<>();
        SharedPreferences test =getSharedPreferences(odoo,0);
        //recuperer lza bonne string correspondant à la value
        String recup=test.getString("kappa","0");
        paramsPost.put("accesstoken",recup);
        HttpPostHandler http = new HttpPostHandler();
        http.addOnDownloadListener(this);
        http.execute(new PostRequest("http://www.raphaelbischof.fr/messaging/?function=getchannels",paramsPost));
    }

    public void onDownloadComplete(String downloadContent) {
        Toast.makeText(getApplicationContext(),downloadContent, Toast.LENGTH_SHORT).show();

        //Deserialisation gson des channel pour les mettres dans la classe channel
        Gson gson = new Gson();
        Channel a1 = gson.fromJson(downloadContent, Channel.class);






    }

    @Override
    public void onDownloadError(String error) {

    }


    @Override
    public void onClick(View v) {

    }
}
