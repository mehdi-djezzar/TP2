package com.example.djezzame.channelmessaging;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.HashMap;



/**
 * Created by djezzame on 19/01/2018.
 */
public class LoginActivity extends Activity implements  View.OnClickListener,OnDownloadListener {


    private String odoo="odoo";


    private EditText edit_user, edit_mdp;

    private Button button;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button = (Button) findViewById(R.id.button_valider);

        button.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        edit_user=(EditText) findViewById(R.id.edit_user);
        edit_mdp=(EditText) findViewById(R.id.edit_mdp);

        switch (v.getId()) {
//Premiere connexion à valider
            case R.id.button_valider:
                HttpPostHandler http = new HttpPostHandler();
                http.addOnDownloadListener(this);
               // Toast.makeText(getApplicationContext(), "Bouton cliqué  Utlisateur :"+edit_user.getText()+" MDP : "+edit_mdp.getText()+"", Toast.LENGTH_SHORT).show();
                HashMap<String,String> paramsPost=new HashMap<>();
                paramsPost.put("username",edit_user.getText().toString());
                paramsPost.put("password",edit_mdp.getText().toString());


                http.execute(new PostRequest("http://www.raphaelbischof.fr/messaging/?function=connect",paramsPost));

                break;

        }


    }

    @Override
    public void onDownloadComplete(String downloadContent) {


        Gson gson=new Gson();

        Access a2=gson.fromJson(downloadContent,Access.class);
        //Ca marche  Toast.makeText(getApplicationContext(),"Reponse"+a2.getResponse(), Toast.LENGTH_SHORT).show();

        //System.out.println(downloadContent);
       // Toast.makeText(getApplicationContext(),downloadContent, Toast.LENGTH_SHORT).show();
//Stocker dans les sharedpreferences et le ressortir
        //crrer ficher
        SharedPreferences settings=getSharedPreferences(odoo,0);
        //editer le fichier
        SharedPreferences.Editor editor = settings.edit();
        //Inserer notre ligne avec un nom de clé
        editor.putString("kappa",a2.getAccesstoken());
        editor.commit();
//Recuper une string d'un shared preferences
        SharedPreferences test =getSharedPreferences(odoo,0);
        //recuperer lza bonne string correspondant à la value
        String recup=test.getString("kappa","0");
        Toast.makeText(getApplicationContext(),recup, Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(getApplicationContext(),ChannelListActivity.class);
        startActivity(intent);

//Demarrer une nouvelle activity


    }

    @Override
    public void onDownloadError(String error) {
        Toast.makeText(getApplicationContext(),"ERREUR", Toast.LENGTH_SHORT).show();

    }
}
