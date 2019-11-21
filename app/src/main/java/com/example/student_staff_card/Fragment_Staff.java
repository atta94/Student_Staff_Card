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

public class Fragment_Staff extends Fragment {

View v;
    private RecyclerView myrecyclerView;
    private List<Staff_Model> staff_modelList;

    public Fragment_Staff() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       v= inflater.inflate ( R.layout.staff_fragment,container,false );
        myrecyclerView=(RecyclerView)v.findViewById ( R.id.staff_recyclerview );
        Staff_Recyclerview_Adapter recyclerview_adapter =new Staff_Recyclerview_Adapter ( getContext (),staff_modelList );
        myrecyclerView.setLayoutManager (new LinearLayoutManager ( getActivity () ) );
        myrecyclerView.setAdapter ( recyclerview_adapter );

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );

        staff_modelList = new ArrayList<> ();
        staff_modelList.add ( new Staff_Model ( R.drawable.ic_studentimage, "Ahmed rizwan", "03215484848" ) );
        staff_modelList.add ( new Staff_Model ( R.drawable.ic_studentimage, "Ahmed rizwan", "03215484848" ) );
        staff_modelList.add ( new Staff_Model ( R.drawable.ic_studentimage, "Ahmed rizwan", "03215484848" ) );
        staff_modelList.add ( new Staff_Model ( R.drawable.ic_studentimage, "Ahmed rizwan", "03215484848" ) );
        staff_modelList.add ( new Staff_Model ( R.drawable.ic_studentimage, "Ahmed rizwan", "03215484848" ) );
        staff_modelList.add ( new Staff_Model ( R.drawable.ic_studentimage, "Ahmed rizwan", "03215484848" ) );
        staff_modelList.add ( new Staff_Model ( R.drawable.ic_studentimage, "Ahmed rizwan", "03215484848" ) );
        staff_modelList.add ( new Staff_Model ( R.drawable.ic_studentimage, "Ahmed rizwan", "03215484848" ) );
        staff_modelList.add ( new Staff_Model ( R.drawable.ic_studentimage, "Ahmed rizwan", "03215484848" ) );
        staff_modelList.add ( new Staff_Model ( R.drawable.ic_studentimage, "Ahmed rizwan", "03215484848" ) );
        staff_modelList.add ( new Staff_Model ( R.drawable.ic_studentimage, "Ahmed rizwan", "03215484848" ) );





    }
}
