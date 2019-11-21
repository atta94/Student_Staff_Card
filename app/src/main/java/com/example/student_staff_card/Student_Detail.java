package com.example.student_staff_card;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Student_Detail extends AppCompatActivity {

    ImageView stuimage;
    TextView stuname, stuno;
    String sname, sno;
    int simage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_student_detail );

        stuimage = findViewById ( R.id.imageView );
        stuname = findViewById ( R.id.studentname );
        stuno = findViewById ( R.id.studentno );

        sname = getIntent ().getStringExtra ( "studentname" );
        sno = getIntent ().getStringExtra ( "studentno" );
        simage = getIntent ().getIntExtra ( "studentimage", 0 );

        stuname.setText ( sname );
        stuno.setText ( sno );
        stuimage.setImageResource ( simage );
    }
}
