package com.example.student_staff_card;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.app.DownloadManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Student_Detail extends AppCompatActivity {

    ImageView stuimage;
    TextView stuid, stufname, stulname, stufathername, stuno, stugender, stuaddress;
    Button approve_btn, del_btn;

    String sid, sstatus, sfname, slname, sfathername, sgender, saddress, sno;
    int simage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_student_detail );

//        stuimage = findViewById ( R.id.imageView );
        stuid = findViewById ( R.id.stu_id );
        stufname = findViewById ( R.id.studentfname );
        stulname = findViewById ( R.id.studentlname );
        stufathername = findViewById ( R.id.studentfather );
        stuno = findViewById ( R.id.studentcontact );

        stugender = findViewById ( R.id.studentgender );
        stuaddress = findViewById ( R.id.studentaddress );

        approve_btn = findViewById ( R.id.btn_approve );
        del_btn = findViewById ( R.id.btn_delete );

//        simage = getIntent ().getIntExtra ( "studentimage", 0 );\

        sid = getIntent ().getStringExtra ( "studentid" );
        sstatus = getIntent ().getStringExtra ( "studentstatus" );

        sfname = getIntent ().getStringExtra ( "studentfname" );
        slname = getIntent ().getStringExtra ( "studentlname" );
        sfathername = getIntent ().getStringExtra ( "studentfathername" );
        sno = getIntent ().getStringExtra ( "studentcontact" );
        sgender = getIntent ().getStringExtra ( "studentgender" );
        saddress = getIntent ().getStringExtra ( "studentaddress" );

//        stuimage.setImageResource ( simage );
        stuid.setText ( sid );
        stufname.setText ( sfname );
        stulname.setText ( slname );
        stufathername.setText ( sfathername );
        stuno.setText ( sno );
        stugender.setText ( sgender );
        stuaddress.setText ( saddress );

        if (sstatus.equals ( "Accepted" )) {
            approve_btn.setVisibility ( View.GONE );
            del_btn.setVisibility ( View.GONE );

        }


        approve_btn.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

///////////////
                Retrofit retrofit = new Retrofit.Builder ()
//                .baseUrl ( "http://192.168.11.5:8080/api/students" )

                        .baseUrl ( "http://192.168.137.1:8080/api/" )
                        .addConverterFactory ( GsonConverterFactory.create () )
                        .build ();

                final API_Model api_model = retrofit.create ( API_Model.class );


                Call<Students> call = api_model.poststudents ( "students/update/" + sid );

                call.enqueue ( new Callback<Students> () {
                    @Override
                    public void onResponse(Call<Students> call, Response<Students> response) {
                        response.errorBody ();
                        Log.d ( "asd", "approved" );

                    }

                    @Override
                    public void onFailure(Call<Students> call, Throwable t) {
                        Toast.makeText ( getApplicationContext (), t.getMessage (), Toast.LENGTH_LONG ).show ();
                    }
                } );
                /////////////////////////////

            }
        } );
/////////
        del_btn.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

///////////////
                Retrofit retrofit = new Retrofit.Builder ()
//                .baseUrl ( "http://192.168.11.5:8080/api/students" )

                        .baseUrl ( "http://192.168.137.1:8080/api/" )
                        .addConverterFactory ( GsonConverterFactory.create () )
                        .build ();

                final API_Model api_model = retrofit.create ( API_Model.class );

                Call<Students> call = api_model.delstudents ( "students/" + sid );

                call.enqueue ( new Callback<Students> () {
                    @Override
                    public void onResponse(Call<Students> call, Response<Students> response) {
                        Log.d ( "asd", "delete" );
//
                    }

                    @Override
                    public void onFailure(Call<Students> call, Throwable t) {
                        Log.d ( "asd", "failure" );
                        Toast.makeText ( getApplicationContext (), t.getMessage (), Toast.LENGTH_LONG ).show ();
                    }
                } );
//                /////////////////////////////
//
            }
        } );
    }}



