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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

//
//    public Button login;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate ( savedInstanceState );
//
//        setContentView ( R.layout.activity_login );
//
//        login= findViewById ( R.id.login );
//
//
//
//        login.setOnClickListener (
//                new View.OnClickListener () {
//                    @Override
//                    public void onClick(View v) {
//
//                        Intent i = new Intent ( getApplicationContext (), Student_Staff_Home.class );
//                        startActivity ( i );
//
//                    }
//                } );
//
//
//    }
//}

   public EditText eduser, edpassword;
    public Button login;
    String username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );

        setContentView ( R.layout.activity_login );
        eduser=findViewById(R.id.user);
        edpassword=findViewById(R.id.password);
        login= findViewById ( R.id.login );
        eduser.setHint(R.string.username);
        edpassword.setHint(R.string.password);



        login.setOnClickListener (
                new View.OnClickListener () {
                    @Override
                    public void onClick(View v) {


                        username=eduser.getText().toString();
                        password=edpassword.getText().toString();
                        int loginvalid=0;
                        if((username.equals("") || username.equals(null))){
                            eduser.setError(R.string.errorusername+"");
//                            eduser.setBackgroundResource(R.drawable.edittext_error);
                            loginvalid=1;
                        }
                        if((password.equals("") || password.equals(null))){

                            edpassword.setError(R.string.errorpassword+"");
//                            edpassword.setBackgroundResource(R.drawable.edittext_error);

                            loginvalid=1;
                        }
                        if(loginvalid==0) {

                            API_Model api_model= RetrofitClient.getClient().create(API_Model.class);
                            RequestBody user = RequestBody.create(MediaType.parse("multipart/form-data"), username);
                            RequestBody psword = RequestBody.create( MediaType.parse("multipart/form-data"), password);
                            Call<ResponseBody> call = api_model.loginadmin(user, psword);

                            call.enqueue(new Callback<ResponseBody> () {
                                @Override
                                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                                    if(response.code()==200){
                                        Intent i = new Intent ( getApplicationContext (), Student_Staff_Home.class );
                                        startActivity ( i );
                                    }
                                    else{
                                        Toast.makeText(getApplicationContext(),"Un-Authorised User", Toast.LENGTH_SHORT).show();
                                    }
                                }

                                @Override
                                public void onFailure(Call<ResponseBody> call, Throwable t) {
                                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });




                        }


                    }
                } );


    }
}