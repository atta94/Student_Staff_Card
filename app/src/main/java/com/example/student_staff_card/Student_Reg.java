package com.example.student_staff_card;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Student_Reg extends AppCompatActivity {
    public static final int GET_FROM_GALLERY = 1;
    ImageView std_img;
    EditText fname, lname, fathername, contact, address;
    Button std_reg;
    String encodedImage = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_student__reg );

        std_img = (ImageView) findViewById ( R.id.imageView );
        fname = (EditText) findViewById ( R.id.fname );
        lname = (EditText) findViewById ( R.id.lname );
        fathername = (EditText) findViewById ( R.id.fathername );
        contact = (EditText) findViewById ( R.id.contact );
        address = (EditText) findViewById ( R.id.address );

        std_reg = (Button) findViewById ( R.id.std_reg );

        std_img.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivityForResult (
                        new Intent (
                                Intent.ACTION_PICK,
                                android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI
                        ),
                        GET_FROM_GALLERY
                );
            }
        } );
    }


}
