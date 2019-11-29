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

public class StaffAdapter extends RecyclerView.Adapter<StaffAdapter.MyViewHolder> {



   public Context mContext;
    List<Staff> mData;


    public StaffAdapter(Context mContext, List<Staff> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }



    @NonNull
    @Override
    public StaffAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from ( mContext ).inflate ( R.layout.cardview_staff_item, parent, false );
        StaffAdapter.MyViewHolder myViewHolder = new StaffAdapter.MyViewHolder ( v );
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final Staff currentItem = mData.get ( position );

//        holder.mstaffimg.setImageResource ( currentItem.getImage () );
        holder.mstaffname.setText ( currentItem.getFirstName () );
        holder.mstaffnumber.setText ( currentItem.getDesignationId () );

        if(currentItem.getStatus ().equals ( "Accepted" )) {
            holder.mstaffver.setImageResource ( R.drawable.ic_verified );
        }



        holder.cardRelativeLayout.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent ( mContext, Staff_Detail.class );
//                intent.putExtra ( "staffimage", currentItem.getImage () );
                intent.putExtra ( "staffid", currentItem.getId ()+ "");
                intent.putExtra ( "staffstatus", currentItem.getStatus ()+ "");
                intent.putExtra ( "stafffname", currentItem.getFirstName () );
                intent.putExtra ( "stafflname", currentItem.getLastName () );
                intent.putExtra ( "staffgender", currentItem.getGenderId () );
                intent.putExtra ( "staffdes", currentItem.getDesignationId () );
                intent.putExtra ( "staffdep", currentItem.getDepartmentId () );
                intent.putExtra ( "staffaddress", currentItem.getAdress () );

                mContext.startActivity ( intent );

            }
        } );

    }

    @Override
    public int getItemCount() {
        return mData.size ();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView mstaffimg,mstaffver;
        TextView mstaffname, mstaffnumber;
        public RelativeLayout cardRelativeLayout;

        public MyViewHolder(@NonNull View itemView) {
            super ( itemView );

            mstaffimg = (ImageView) itemView.findViewById ( R.id.img_staff );
            mstaffname = (TextView) itemView.findViewById ( R.id.staff_name );
            mstaffnumber = (TextView) itemView.findViewById ( R.id.staff_number );

            mstaffver = (ImageView) itemView.findViewById ( R.id.staff_verify );

            cardRelativeLayout = itemView.findViewById ( R.id.staff_cardview );

        }
    }
}
