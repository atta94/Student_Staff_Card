package com.example.student_staff_card;

import android.os.Bundle;
import android.util.Log;
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

public class Fragment_Student extends Fragment {

    View v;
    private RecyclerView myrecyclerView;
//    private List<Student_Model> student_modelList;

    private List<Students> studentsList = new ArrayList<> ();

    public Fragment_Student() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {


        v = inflater.inflate ( R.layout.student_fragment, container, false );
        myrecyclerView = (RecyclerView) v.findViewById ( R.id.student_recyclerview );
        myrecyclerView.setLayoutManager ( new LinearLayoutManager ( getActivity () ) );
////////////////
        Retrofit retrofit = new Retrofit.Builder ()
//                .baseUrl ( "http://192.168.11.5:8080/api/students" )

                .baseUrl ( "http://192.168.137.1:8080/api/" )
                .addConverterFactory ( GsonConverterFactory.create () )
                .build ();

        final API_Model api_model = retrofit.create ( API_Model.class );

        Call<List<Students>> call = api_model.getstudents ();

        call.enqueue ( new Callback<List<Students>> () {
            @Override
            public void onResponse(Call<List<Students>> call, Response<List<Students>> response) {

//                List<Students> students = response.body ();
                studentsList = response.body ();

                StudentAdapter recyclerviewadapter = new StudentAdapter ( getContext (), studentsList );
                myrecyclerView.setAdapter ( recyclerviewadapter );

            }

            @Override
            public void onFailure(Call<List<Students>> call, Throwable t) {
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
//        student_modelList = new ArrayList<> ();
//        student_modelList.add ( new Student_Model ( R.drawable.ic_studentimage, "ahmed rizwan", "03215484848" ) );
//        student_modelList.add ( new Student_Model ( R.drawable.ic_studentimage, "Rizwan Ali", "03215484848" ) );
//        student_modelList.add ( new Student_Model ( R.drawable.ic_studentimage, "khan rizwan", "03215484848" ) );
//        student_modelList.add ( new Student_Model ( R.drawable.ic_studentimage, "ahmed rizwan", "03215484848" ) );
//        student_modelList.add ( new Student_Model ( R.drawable.ic_studentimage, "ahmed rizwan", "03215484848" ) );
//        student_modelList.add ( new Student_Model ( R.drawable.ic_studentimage, "ahmed rizwan", "03215484848" ) );
//        student_modelList.add ( new Student_Model ( R.drawable.ic_studentimage, "ahmed rizwan", "03215484848" ) );
//        student_modelList.add ( new Student_Model ( R.drawable.ic_studentimage, "ahmed rizwan", "03215484848" ) );
//        student_modelList.add ( new Student_Model ( R.drawable.ic_studentimage, "ahmed rizwan", "03215484848" ) );
//        student_modelList.add ( new Student_Model ( R.drawable.ic_studentimage, "ahmed rizwan", "03215484848" ) );
//        student_modelList.add ( new Student_Model ( R.drawable.ic_studentimage, "ahmed rizwan", "03215484848" ) );
//        student_modelList.add ( new Student_Model ( R.drawable.ic_studentimage, "ahmed rizwan", "03215484848" ) );
//        student_modelList.add ( new Student_Model ( R.drawable.ic_studentimage, "ahmed rizwan", "03215484848" ) );
//
//    }
}
