package com.example.student_staff_card;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Fragment_Staff extends Fragment {

View v;
    private RecyclerView myrecyclerView;
    private List<Staff> staffList = new ArrayList<> ();

    public Fragment_Staff() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       v= inflater.inflate ( R.layout.staff_fragment,container,false );
        myrecyclerView=(RecyclerView)v.findViewById ( R.id.staff_recyclerview );
        myrecyclerView.setLayoutManager (new LinearLayoutManager ( getActivity () ) );

///////////
        Retrofit retrofit = new Retrofit.Builder ()
//                .baseUrl ( "http://192.168.11.5:8080/api/students" )

                .baseUrl ( "http://192.168.137.1:8080/api/" )
                .addConverterFactory ( GsonConverterFactory.create () )
                .build ();

        final API_Model api_model = retrofit.create ( API_Model.class );

        Call<List<Staff>> call = api_model.getstaff ();

        call.enqueue ( new Callback<List<Staff>> () {
            @Override
            public void onResponse(Call<List<Staff>> call, Response<List<Staff>> response) {

              staffList = response.body ();

                StaffAdapter recyclerviewadapter = new StaffAdapter  ( getContext (), staffList );
                myrecyclerView.setAdapter ( recyclerviewadapter );

            }

            @Override
            public void onFailure(Call<List<Staff>> call, Throwable t) {
                Toast.makeText ( getContext (), t.getMessage (), Toast.LENGTH_LONG ).show ();
            }
        } );
        /////////////////////////////

        return v;
    }
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate ( savedInstanceState );
//
//        staff_modelList = new ArrayList<> ();
//        staff_modelList.add ( new Staff_Model ( R.drawable.ic_studentimage, "Ahmed rizwan", "03215484848" ) );
//        staff_modelList.add ( new Staff_Model ( R.drawable.ic_studentimage, "Ahmed rizwan", "03215484848" ) );
//        staff_modelList.add ( new Staff_Model ( R.drawable.ic_studentimage, "Ahmed rizwan", "03215484848" ) );
//        staff_modelList.add ( new Staff_Model ( R.drawable.ic_studentimage, "Ahmed rizwan", "03215484848" ) );
//        staff_modelList.add ( new Staff_Model ( R.drawable.ic_studentimage, "Ahmed rizwan", "03215484848" ) );
//        staff_modelList.add ( new Staff_Model ( R.drawable.ic_studentimage, "Ahmed rizwan", "03215484848" ) );
//        staff_modelList.add ( new Staff_Model ( R.drawable.ic_studentimage, "Ahmed rizwan", "03215484848" ) );
//        staff_modelList.add ( new Staff_Model ( R.drawable.ic_studentimage, "Ahmed rizwan", "03215484848" ) );
//        staff_modelList.add ( new Staff_Model ( R.drawable.ic_studentimage, "Ahmed rizwan", "03215484848" ) );
//        staff_modelList.add ( new Staff_Model ( R.drawable.ic_studentimage, "Ahmed rizwan", "03215484848" ) );
//        staff_modelList.add ( new Staff_Model ( R.drawable.ic_studentimage, "Ahmed rizwan", "03215484848" ) );
//
//
//
//
//
//    }
}
