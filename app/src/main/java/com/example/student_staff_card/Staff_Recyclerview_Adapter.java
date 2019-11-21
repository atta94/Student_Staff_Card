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

public class Staff_Recyclerview_Adapter extends RecyclerView.Adapter<Staff_Recyclerview_Adapter.MyViewHolder> {



   public Context mContext;
    List<Staff_Model> mData;


    public Staff_Recyclerview_Adapter(Context mContext, List<Staff_Model> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }



    @NonNull
    @Override
    public Staff_Recyclerview_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from ( mContext ).inflate ( R.layout.cardview_staff_item, parent, false );
        Staff_Recyclerview_Adapter.MyViewHolder myViewHolder = new Staff_Recyclerview_Adapter.MyViewHolder ( v );
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final Staff_Model currentItem = mData.get ( position );

//        holder.staffname.setText ( mData.get ( position ).getName () );
//        holder.staffnumber.setText ( mData.get ( position ).getNumber () );
//        holder.staffimg.setImageResource ( mData.get ( position ).getImage () );

        holder.mstaffimg.setImageResource ( currentItem.getImage () );
        holder.mstaffname.setText ( currentItem.getName () );
        holder.mstaffnumber.setText ( currentItem.getNumber () );



        holder.cardRelativeLayout.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent ( mContext, Staff_Detail.class );
                intent.putExtra ( "staffimage", currentItem.getImage () );
                intent.putExtra ( "staffname", currentItem.getName () );
                intent.putExtra ( "staffno", currentItem.getNumber () );
                mContext.startActivity ( intent );

            }
        } );

    }

    @Override
    public int getItemCount() {
        return mData.size ();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView mstaffimg;
        TextView mstaffname, mstaffnumber;
        public RelativeLayout cardRelativeLayout;

        public MyViewHolder(@NonNull View itemView) {
            super ( itemView );

            mstaffimg = (ImageView) itemView.findViewById ( R.id.img_staff );
            mstaffname = (TextView) itemView.findViewById ( R.id.staff_name );
            mstaffnumber = (TextView) itemView.findViewById ( R.id.staff_number );
            cardRelativeLayout = itemView.findViewById ( R.id.staff_cardview );

        }
    }
}
