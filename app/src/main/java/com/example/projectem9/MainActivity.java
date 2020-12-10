package com.example.projectem9;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List list = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.btn_login);

        final EditText username = findViewById(R.id.et_username);
        final EditText password = findViewById(R.id.et_contraseña);

        //final TextView comprovador = findViewById(R.id.tv_login_validador);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Log.i("btn clicats", "el btn de login ha estat clicat");

                String text_username = username.getText() .toString();
                String text_password = password.getText() .toString();

                if(text_username.equals("admin") && text_password.equals("admin")){
                    //login OK
                    goToMenu();
                }else{
                    //login KO
                   Toast.makeText(getApplicationContext(),"ERROR",Toast.LENGTH_SHORT).show();
                    goToMenu();
                }
            }
        });


    }

    public void goToMenu(){
        Intent intentMenu = new Intent(this, Menu.class);
        startActivity(intentMenu);
;    }


}