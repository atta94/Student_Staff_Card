package com.example.student_staff_card;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Staff_Detail extends AppCompatActivity {

    ImageView staffimage;
    TextView staffname, staffno;
    String sname, sno;
    int simage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_staff__detail );

        staffimage = findViewById ( R.id.imageView );
        staffname = findViewById ( R.id.studentname );
        staffno = findViewById ( R.id.studentno );

        sname = getIntent ().getStringExtra ( "staffname" );
        sno = getIntent ().getStringExtra ( "staffno" );
        simage = getIntent ().getIntExtra ( "staffimage", 0 );

        staffname.setText ( sname );
        staffno.setText ( sno );
        staffimage.setImageResource ( simage );
    }
}
