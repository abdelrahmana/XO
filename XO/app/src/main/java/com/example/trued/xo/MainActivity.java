package com.example.trued.xo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    String name="" ;
    EditText  edit;
    handling_calling_onclick_within_fragement_ui UI = new fragement_game();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  getSupportFragmentManager().beginTransaction().replace(R.id.container,new fragement_game()).commit();
        Animation myinimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.pulse);
        ImageView m = (ImageView)findViewById(R.id.imageView);
        m.setAnimation(myinimation);

        final Button GO = (Button)findViewById(R.id.start_game);
        final TextView mytext = (TextView)findViewById(R.id.start_text);
           edit  =(EditText)findViewById(R.id.editText);
        mytext.animate().translationYBy(-1000f).setDuration(0);
        GO.animate().translationY(-1000f).setDuration(0);
        mytext.animate().translationYBy(0f).rotationYBy(340).rotationXBy(360).setDuration(700);
        GO.animate().translationYBy(0f).rotationYBy(340).rotationXBy(360).setDuration(700);
        GO.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
              String check_edit =  edit.getText().toString();
                if(check_edit.matches(""))
                {
                    Toast.makeText(MainActivity.this, "Please Enter Your Name First", Toast.LENGTH_SHORT).show();
                }
                else {
                    name = edit.getText().toString();
                    GOTOGame();
                }



            }
        });
        edit.addTextChangedListener(new TextWatcher() {
                                        @Override
                                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {


                                        }

                                        @Override
                                        public void onTextChanged(CharSequence s, int start, int before, int count) {

                                        }

                                        @Override
                                        public void afterTextChanged(Editable s) {

                                        }
                                    }


        );
    }

    private void GOTOGame() {
       // getSupportFragmentManager().beginTransaction().replace(R.id.container,new fragement_game()).commit();


            Intent myintent = new Intent((getBaseContext()),Game_X_O.class);
        myintent.putExtra("name",name);

        startActivity(myintent);
    }
    public void puthere(View v)
    {
        UI.puthere(v);
    }


}
