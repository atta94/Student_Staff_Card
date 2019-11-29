package com.example.student_staff_card;

import java.util.List;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Url;

public interface API_Model {


    @Multipart
    @POST("students")
    Call<ResponseBody> createstudentPost(
            @Part("First_name ") RequestBody Firstname,
            @Part("Last_name") RequestBody Lastname,
            @Part("Father_name") RequestBody Fathername,
            @Part("gender") RequestBody gender,
            @Part("adress") RequestBody address,
            @Part("contact") RequestBody contact

    );


    @Multipart
    @POST("staff")
    Call<ResponseBody> createstaffPost(
            @Part("First_name") RequestBody FirstName,
            @Part("Last_name") RequestBody Lastname,
            @Part("Department_id") RequestBody Departmetn,
            @Part("Designation_id") RequestBody Designation,
            @Part("Adress") RequestBody address,
            @Part("Contact") RequestBody Contact,
            @Part("gender_id") RequestBody gander

    );
    @Multipart
    @POST("login")
    Call<ResponseBody> loginadmin(
            @Part("email") RequestBody Email,
            @Part("password") RequestBody Password
    );
////////
@GET("students")
    Call<List<Students>> getstudents();


    @GET("staff")
    Call<List<Staff>> getstaff();

    @POST()
    Call<Students> poststudents(@Url String id);


    @DELETE()
    Call<Students> delstudents(@Url String id);

    @POST()
    Call<Staff> approvestaff(@Url String id);


    @DELETE()
    Call<Staff> delstaff(@Url String id);

}
