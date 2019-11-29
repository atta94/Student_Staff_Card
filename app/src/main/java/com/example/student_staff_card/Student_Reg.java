package com.example.student_staff_card;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Student_Reg extends AppCompatActivity {
    public static final int GET_FROM_GALLERY = 1;
    String encodedImage = "";
    Button Login;
    RadioButton rdmale, rdfemale;
    EditText firstname, lastname, contactnum, fathername, address;
    RadioGroup rggender;
    String gender = R.string.male + "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_student__reg );
        Login = findViewById ( R.id.std_reg );
        firstname = findViewById ( R.id.fname );
        lastname = findViewById ( R.id.lname );
        rdmale = findViewById ( R.id.radioM );
        rdfemale = findViewById ( R.id.radioF );
        contactnum = findViewById ( R.id.contact );
        fathername = findViewById ( R.id.fathername );
        address = findViewById ( R.id.address );
        rggender = findViewById ( R.id.radioGrp );
        rdfemale.setText ( R.string.female );
        rdmale.setText ( R.string.male );
        Login.setOnClickListener ( new View.OnClickListener () {
            int valid = 1;

            @Override
            public void onClick(View v) {
                String fname, lname, fathrname, conttnum, stdaddress;
                fname = firstname.getText ().toString ();
                lname = lastname.getText ().toString ();
                fathrname = fathername.getText ().toString ();
                conttnum = contactnum.getText ().toString ();
                stdaddress = address.getText ().toString ();

                if ((fname.equals ( "" ) || fname.equals ( null ))) {
                    firstname.setError ( R.string.errorusername + "" );
                    firstname.setBackgroundResource ( R.drawable.edittext_error );
                    valid = 0;
                }
                if (lname.equals ( "" ) || lname.equals ( null )) {
                    lastname.setError ( R.string.errorusername + "" );
                    lastname.setBackgroundResource ( R.drawable.edittext_error );
                    valid = 0;
                }
                if (fathrname.equals ( "" ) || fathrname.equals ( null )) {
                    fathername.setError ( R.string.errorfathername + "" );
                    fathername.setBackgroundResource ( R.drawable.edittext_error );
                    valid = 0;
                }
                if (conttnum.equals ( "" ) || conttnum.equals ( null )) {
                    contactnum.setError ( R.string.errorcontact + "" );
                    contactnum.setBackgroundResource ( R.drawable.edittext_error );
                    valid = 0;
                }
                if (stdaddress.equals ( "" ) || stdaddress.equals ( null )) {
                    address.setError ( R.string.erroraddress + "" );
                    address.setBackgroundResource ( R.drawable.edittext_error );
                    valid = 0;
                }

                if (valid == 1) {
                    int radid = rggender.getCheckedRadioButtonId ();
                    if (radid == 0) {
                        gender = R.string.male + "";
                    } else
                        gender = R.string.female + "";
                    API_Model api_model = RetrofitClient.getClient ().create ( API_Model.class );
                    RequestBody fstname = RequestBody.create ( MediaType.parse ( "multipart/form-data" ), firstname.getText ().toString () );
                    RequestBody lstname = RequestBody.create ( MediaType.parse ( "multipart/form-data" ), lastname.getText ().toString () );
                    RequestBody fthername = RequestBody.create ( MediaType.parse ( "multipart/form-data" ), fathername.getText ().toString () );
                    RequestBody gndr = RequestBody.create ( MediaType.parse ( "multipart/form-data" ), gender );
                    RequestBody adress = RequestBody.create ( MediaType.parse ( "multipart/form-data" ), address.getText ().toString () );
                    RequestBody cntctnum = RequestBody.create ( MediaType.parse ( "multipart/form-data" ), contactnum.getText ().toString () );

                    Call<ResponseBody> call = api_model.createstudentPost (
                            fstname, lstname, fthername, gndr, adress, cntctnum
                    );
                    call.enqueue ( new Callback<ResponseBody> () {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            Log.d ( "asd", "done" );
//                            String resp = response.body().toString();
//                            Toast.makeText(getApplicationContext(), resp.toString(), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {

                        }
                    } );


                }


            }


        } );

    }


}