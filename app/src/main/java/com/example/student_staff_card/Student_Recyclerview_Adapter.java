package com.example.student_staff_card;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Student_Recyclerview_Adapter extends RecyclerView.Adapter<Student_Recyclerview_Adapter.MyViewHolder> {

    Context mContext;
    List<Student_Model> mData;


    public Student_Recyclerview_Adapter(Context mContext, List<Student_Model> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from ( mContext ).inflate ( R.layout.cardview_stu_item, parent, false );
        MyViewHolder myViewHolder = new MyViewHolder ( v );
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final Student_Model currentItem = mData.get ( position );

        holder.mstuimg.setImageResource ( currentItem.getImage () );
        holder.mstuname.setText ( currentItem.getName () );
        holder.mstunumber.setText ( currentItem.getNumber () );



        holder.cardRelativeLayout.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent ( mContext, Student_Detail.class );
                intent.putExtra ( "studentimage", currentItem.getImage  () );
                intent.putExtra ( "studentname", currentItem.getName () );
                intent.putExtra ( "studentno", currentItem.getNumber () );
                mContext.startActivity ( intent );

            }
        } );

    }


    @Override
    public int getItemCount() {
        return mData.size ();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView mstuimg;
        TextView mstuname, mstunumber;
        public RelativeLayout cardRelativeLayout;

        public MyViewHolder(@NonNull View itemView) {
            super ( itemView );

            mstuimg = (ImageView) itemView.findViewById ( R.id.img_stu );
            mstuname = (TextView) itemView.findViewById ( R.id.stu_name );
            mstunumber = (TextView) itemView.findViewById ( R.id.stu_number );
            cardRelativeLayout = itemView.findViewById ( R.id.student_cardview );
        }
    }

}
