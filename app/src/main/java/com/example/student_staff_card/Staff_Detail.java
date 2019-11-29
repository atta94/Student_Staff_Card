package com.example.student_staff_card;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Staff_Detail extends AppCompatActivity {

    ImageView staffimage;
    TextView stafffname, stafflname, staffdep, staffdes, staffaddress, staffgender, staffno;
    String sid, sstatus, sfname, slname, sdep, sdes, saddress, sgender, sno;
    int simage;
    Button del_btn, approve_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_staff__detail );

//        staffimage = findViewById ( R.id.imageView );
        stafffname = findViewById ( R.id.stafffname );
        stafflname = findViewById ( R.id.stafflname );
        staffno = findViewById ( R.id.staffcontact );
        staffgender = findViewById ( R.id.staffgender );
        staffdep = findViewById ( R.id.staffdepartment );
        staffdes = findViewById ( R.id.staffdesignation );
        staffaddress = findViewById ( R.id.staffaddress );

        del_btn = findViewById ( R.id.btn_delete );
        approve_btn = findViewById ( R.id.btn_approve );

//        simage = getIntent ().getIntExtra ( "staffimage", 0 );
        sid = getIntent ().getStringExtra ( "staffid" );
        sstatus = getIntent ().getStringExtra ( "staffstatus" );

        sfname = getIntent ().getStringExtra ( "stafffname" );
        slname = getIntent ().getStringExtra ( "stafflname" );
        sgender = getIntent ().getStringExtra ( "staffgender" );
        sno = getIntent ().getStringExtra ( "staffno" );
        sdep = getIntent ().getStringExtra ( "staffdep" );
        sdes = getIntent ().getStringExtra ( "staffdes" );
        saddress = getIntent ().getStringExtra ( "staffaddress" );

//        staffimage.setImageResource ( simage );
        stafffname.setText ( sfname );
        stafflname.setText ( slname );
        staffno.setText ( sno );
        staffgender.setText ( sgender );
        staffdep.setText ( sdep );
        staffdes.setText ( sdes );
        staffaddress.setText ( saddress );


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


                Call<Staff> call = api_model.approvestaff ( "staff/update/" + sid );

                call.enqueue ( new Callback<Staff> () {
                    @Override
                    public void onResponse(Call<Staff> call, Response<Staff> response) {
                        response.errorBody ();
                        Log.d ( "asd", "approved" );

                    }

                    @Override
                    public void onFailure(Call<Staff> call, Throwable t) {
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

                Call<Staff> call = api_model.delstaff ( "staff/" + sid );

                call.enqueue ( new Callback<Staff> () {
                    @Override
                    public void onResponse(Call<Staff> call, Response<Staff> response) {
                        Log.d ( "asd", "delete" );
//
                    }

                    @Override
                    public void onFailure(Call<Staff> call, Throwable t) {
                        Log.d ( "asd", "failure" );
                        Toast.makeText ( getApplicationContext (), t.getMessage (), Toast.LENGTH_LONG ).show ();
                    }
                } );
//                /////////////////////////////
//
            }
        } );
    }}
