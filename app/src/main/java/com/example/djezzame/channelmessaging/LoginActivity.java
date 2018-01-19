package com.example.djezzame.channelmessaging;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by djezzame on 19/01/2018.
 */
public class LoginActivity extends Activity implements  View.OnClickListener {


    private EditText edit_user,edit_mdp;

    private Button button;

    @Override
    public void onCreate (Bundle savedInstanceState )
    {
        super.onCreate(savedInstanceState);
        button= (Button) findViewById(R.id.button);
        button.setOnClickListener(this) ;

    }
    @Override
    public void onClick(View v)

    {
        EditText editText = (EditText) findViewById(R.id.edit_user);
        switch(v.getId()) {

            case R.id.button:

        }


    }



}
