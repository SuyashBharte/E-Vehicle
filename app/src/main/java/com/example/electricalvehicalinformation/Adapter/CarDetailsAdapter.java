package com.example.electricalvehicalinformation.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.electricalvehicalinformation.CarDetailsActivity;
import com.example.electricalvehicalinformation.Models.CarDetailsList;
import com.example.electricalvehicalinformation.Models.CarImageResponse;
import com.example.electricalvehicalinformation.R;

import java.util.ArrayList;
import java.util.List;

public class CarDetailsAdapter extends RecyclerView.Adapter<CarDetailsAdapter.ViewHolder>{

    private Context mContext;
    List<CarDetailsList> profileModels = new ArrayList<CarDetailsList>();

    public CarDetailsAdapter(Context mContext, List<CarDetailsList> profileModels) {
        this.mContext = mContext;
        this.profileModels = profileModels;
    }
    @NonNull
    @Override
    public CarDetailsAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardetails, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int i) {
        final CarDetailsList profileModel=profileModels.get(i);
        holder.t1.setText(profileModel.getCarname());
        holder.mno.setText(profileModel.getModelno());
        holder.mtype.setText(profileModel.getModeltype());
        holder.wheel.setText(profileModel.getWsize());
        holder.t2.setText(profileModel.getLaunchdate());
        holder.t3.setText(profileModel.getSpecification());
        holder.t4.setText(profileModel.getFeatures());
        holder.t6.setText(profileModel.getCost());
        holder.tt2.setText(profileModel.getVariant());
        holder.t7.setText(profileModel.getRange());
        holder.t8.setText(profileModel.getMotor());
        holder.t9.setText(profileModel.getBattery());
        holder.tt.setText(profileModel.getWarranty());





        Glide.with(mContext)
                .load(profileModel.getPhoto())
                .into(holder.image);


    }




    @Override
    public int getItemCount() { return profileModels.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView t1;
        TextView mtype;
        TextView wheel;
        TextView mno;
        TextView t2;
        TextView t3;
        TextView t4;
        TextView t6;
        TextView t7;
        TextView t8;
        TextView t9;
        TextView tt;
        TextView tt2;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.t1);
            mtype=itemView.findViewById(R.id.mtype);
            wheel=itemView.findViewById(R.id.wheel);
            t2=itemView.findViewById(R.id.t2);
            t3=itemView.findViewById(R.id.t3);
            t4=itemView.findViewById(R.id.t4);
            t6=itemView.findViewById(R.id.t6);
            t7=itemView.findViewById(R.id.t7);
            t8=itemView.findViewById(R.id.t8);
            t9=itemView.findViewById(R.id.t9);
            tt=itemView.findViewById(R.id.tt);
            tt2=itemView.findViewById(R.id.tt2);
            mno=itemView.findViewById(R.id.mno);
            image=itemView.findViewById(R.id.image);
        }
    }
}
