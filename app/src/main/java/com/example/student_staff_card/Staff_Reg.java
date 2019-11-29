package com.example.student_staff_card;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class Staff_Reg extends AppCompatActivity {
    Button register;
    EditText frstnam, lastname, address, contact;
    RadioGroup rggender;
    RadioButton rdmale, rdfemale;
    Spinner spdepartment, spdesignation;
    int radid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_staff__reg );

        frstnam = findViewById ( R.id.fname );
        lastname = findViewById ( R.id.lname );
        rdmale = findViewById ( R.id.radioM );
        rdfemale = findViewById ( R.id.radioF );
        spdepartment = findViewById ( R.id.dprtmentspinner );
        spdesignation = findViewById ( R.id.designationspinner );
        register = findViewById ( R.id.staff_btn );
        contact = findViewById ( R.id.contact );
        address = findViewById ( R.id.address );


        register.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                String gender = R.string.male + "";

                int valid = 1;
                String fname, lname, adres, contactnum;
                fname = frstnam.getText ().toString ();
                lname = lastname.getText ().toString ();
                adres = address.getText ().toString ();
                contactnum = contact.getText ().toString ();
                if (fname.equals ( "" ) || fname.equals ( null )) {
                    frstnam.setError ( R.string.errorname + "" );
                    frstnam.setBackgroundResource ( R.drawable.edittext_error );
                    valid = 0;
                }
                if (lname.equals ( "" ) || lname.equals ( null )) {
                    lastname.setBackgroundResource ( R.drawable.edittext_error );
                    lastname.setError ( R.string.errorname + "" );
                    valid = 0;
                }

                if (adres.equals ( "" ) || adres.equals ( null )) {
                    address.setError ( R.string.erroraddress + "" );
                    address.setBackgroundResource ( R.drawable.edittext_error );
                    valid = 0;
                }
                if (contactnum.equals ( "" ) || contactnum.equals ( null )) {
                    contact.setError ( R.string.errorcontact + "" );
                    contact.setBackgroundResource ( R.drawable.edittext_error );
                    valid = 0;
                }

                if (valid == 1) {

                  radid = rggender.getCheckedRadioButtonId ();

                    if (radid == 0) {
                        rdmale = findViewById ( radid );
                        gender = rdmale.getText ().toString ();
                        //gender = R.string.male+"";
                    } else {
                        rdmale = findViewById ( radid );
                        gender = rdmale.getText ().toString ();
                        //
                    }

                    API_Model api_model = RetrofitClient.getClient ().create ( API_Model.class );
                    RequestBody fstname = RequestBody.create ( MediaType.parse ( "multipart/form-data" ), frstnam.getText ().toString () );
                    RequestBody lstname = RequestBody.create ( MediaType.parse ( "multipart/form-data" ), lastname.getText ().toString () );
                    RequestBody gndr = RequestBody.create ( MediaType.parse ( "multipart/form-data" ), gender );
                    RequestBody adress = RequestBody.create ( MediaType.parse ( "multipart/form-data" ), address.getText ().toString () );
                    RequestBody cntctnum = RequestBody.create ( MediaType.parse ( "multipart/form-data" ), contact.getText ().toString () );
                    RequestBody deprtment = RequestBody.create ( MediaType.parse ( "multipart/form-data" ), spdepartment.getSelectedItem ().toString () );
                    RequestBody desgnation = RequestBody.create ( MediaType.parse ( "multipart/form-data" ), spdesignation.getSelectedItem ().toString () );


                    Call<ResponseBody> call = api_model.createstaffPost ( fstname, lstname,
                            deprtment, desgnation, adress, cntctnum, gndr );

                    call.enqueue ( new Callback<ResponseBody> () {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            Log.d ( "asd", "done" );
//                            String resp = response.body ().toString ();
//                            Toast.makeText ( getApplicationContext (), resp.toString (), Toast.LENGTH_SHORT ).show ();
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Toast.makeText ( getApplicationContext (), t.getMessage (), Toast.LENGTH_SHORT ).show ();
                        }
                    } );
                }
            }

        } );

    }

}
