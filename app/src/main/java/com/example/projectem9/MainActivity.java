package com.example.projectem9;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    SharedPreferences datosguardados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ESTO SIRVE PARA PODER GUARDAR DATOS EN ALGUN SITIO, DONDE LE DAMOS UN NOMBRE
        //QUE SERA LA KEY PARA PODER VER ESOS DATOS EN ALGUN MOMENTO
        datosguardados = this.getSharedPreferences("Ajustes", Context.MODE_PRIVATE);


        final EditText username = findViewById(R.id.et_username);
        final EditText password = findViewById(R.id.et_contraseña);



        final Button button = findViewById(R.id.btn_login);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Log.i("btn clicats", "el btn de login ha estat clicat");

                String text_username = username.getText() .toString();
                String text_password = password.getText() .toString();

                if(text_username.equals("admin") && text_password.equals("admin")){
                    //login OK
                    datosguardados.edit().putString("Usuario",text_username).commit();
                    datosguardados.edit().putString("password",text_password).commit();
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