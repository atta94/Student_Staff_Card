package com.example.student_staff_card;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Fragment_Student extends Fragment {

    View v;
    private RecyclerView myrecyclerView;
    private List<Student_Model> student_modelList;


    public Fragment_Student() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate ( R.layout.student_fragment, container, false );
        myrecyclerView=(RecyclerView)v.findViewById ( R.id.student_recyclerview );
        Student_Recyclerview_Adapter recyclerview_adapter =new Student_Recyclerview_Adapter ( getContext (),student_modelList );
        myrecyclerView.setLayoutManager (new LinearLayoutManager ( getActivity () ) );
        myrecyclerView.setAdapter ( recyclerview_adapter );
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );

        student_modelList = new ArrayList<> ();
        student_modelList.add ( new Student_Model ( R.drawable.ic_studentimage, "ahmed rizwan", "03215484848" ) );
        student_modelList.add ( new Student_Model ( R.drawable.ic_studentimage, "Rizwan Ali", "03215484848" ) );
        student_modelList.add ( new Student_Model ( R.drawable.ic_studentimage, "khan rizwan", "03215484848" ) );
        student_modelList.add ( new Student_Model ( R.drawable.ic_studentimage, "ahmed rizwan", "03215484848" ) );
        student_modelList.add ( new Student_Model ( R.drawable.ic_studentimage, "ahmed rizwan", "03215484848" ) );
        student_modelList.add ( new Student_Model ( R.drawable.ic_studentimage, "ahmed rizwan", "03215484848" ) );
        student_modelList.add ( new Student_Model ( R.drawable.ic_studentimage, "ahmed rizwan", "03215484848" ) );
        student_modelList.add ( new Student_Model ( R.drawable.ic_studentimage, "ahmed rizwan", "03215484848" ) );
        student_modelList.add ( new Student_Model ( R.drawable.ic_studentimage, "ahmed rizwan", "03215484848" ) );
        student_modelList.add ( new Student_Model ( R.drawable.ic_studentimage, "ahmed rizwan", "03215484848" ) );
        student_modelList.add ( new Student_Model ( R.drawable.ic_studentimage, "ahmed rizwan", "03215484848" ) );
        student_modelList.add ( new Student_Model ( R.drawable.ic_studentimage, "ahmed rizwan", "03215484848" ) );
        student_modelList.add ( new Student_Model ( R.drawable.ic_studentimage, "ahmed rizwan", "03215484848" ) );

    }
}
