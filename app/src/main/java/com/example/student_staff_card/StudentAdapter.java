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

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyViewHolder> {

    Context mContext;
    List<Students> mData;


    public StudentAdapter(Context mContext, List<Students> mData) {
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

        final Students currentItem = mData.get( position );

//        holder.mstuimg.setImageResource ( currentItem.getImage () );
        holder.mstuname.setText ( currentItem.firstName );
        holder.mstunumber.setText ( currentItem.contact );


        if(currentItem.status.equals ( "Accepted" )) {
            holder.mstuver.setImageResource ( R.drawable.ic_verified );
        }


        holder.cardRelativeLayout.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent ( mContext, Student_Detail.class );
//                intent.putExtra ( "studentimage", currentItem.getImage  () );
                intent.putExtra ( "studentid", currentItem.getId ()+ "");
                intent.putExtra ( "studentstatus", currentItem.getStatus () );
                intent.putExtra ( "studentfname", currentItem.getFirstName () );
                intent.putExtra ( "studentlname", currentItem.getLastName () );
                intent.putExtra ( "studentgender", currentItem.getGender () );
                intent.putExtra ( "studentfathername", currentItem.getFatherName () );
                intent.putExtra ( "studentcontact", currentItem.getContact () );
                intent.putExtra ( "studentaddress", currentItem.getAdress () );


                mContext.startActivity ( intent );

            }
        } );

    }


    @Override
    public int getItemCount() {
        return mData.size ();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView mstuimg,mstuver;
        TextView mstuname, mstunumber,mstatus,mstustatus;
        public RelativeLayout cardRelativeLayout;

        public MyViewHolder(@NonNull View itemView) {
            super ( itemView );

            mstuimg = (ImageView) itemView.findViewById ( R.id.img_stu );
            mstuname = (TextView) itemView.findViewById ( R.id.stu_name );
            mstunumber = (TextView) itemView.findViewById ( R.id.stu_number );

            mstuver = (ImageView) itemView.findViewById ( R.id.stu_verify );

            cardRelativeLayout = itemView.findViewById ( R.id.student_cardview );
        }
    }

}
