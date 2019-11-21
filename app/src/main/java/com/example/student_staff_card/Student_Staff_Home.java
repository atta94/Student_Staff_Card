package com.example.student_staff_card;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class Student_Staff_Home extends AppCompatActivity {


    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_student__staff__home );

        tabLayout = findViewById ( R.id.tablayout_id );
        viewPager = findViewById ( R.id.viewpager_id );
        adapter = new ViewPagerAdapter ( getSupportFragmentManager () );

        //add fragment here
        adapter.AddFragment ( new Fragment_Student (), "Student" );
        adapter.AddFragment ( new Fragment_Staff (), "Staff" );
        viewPager.setAdapter ( adapter );
        tabLayout.setupWithViewPager ( viewPager );

    }
}
