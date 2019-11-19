package com.example.student_staff_card;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {


    public Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );

        setContentView ( R.layout.activity_login );

        login= findViewById ( R.id.login );



        login.setOnClickListener (
                new View.OnClickListener () {
                    @Override
                    public void onClick(View v) {

                        Intent i = new Intent ( getApplicationContext (), Home.class );
                        startActivity ( i );

                    }
                } );


    }
}
