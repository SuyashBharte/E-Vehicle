package com.example.electricalvehicalinformation.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.electricalvehicalinformation.Fragment.AddreviewFragment;
import com.example.electricalvehicalinformation.Models.FeedbackModel;
import com.example.electricalvehicalinformation.Models.StationModel;
import com.example.electricalvehicalinformation.R;
import com.example.electricalvehicalinformation.StationDetailsActivity;

import java.util.ArrayList;
import java.util.List;


public class StationAdapter extends RecyclerView.Adapter<StationAdapter.ViewHolder> {

    private Context mContext;
    List<StationModel> profileModels = new ArrayList<StationModel>();

    public StationAdapter(Context mContext, List<StationModel> profileModels) {
        this.mContext = mContext;
        this.profileModels = profileModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.review_list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int i) {
        final StationModel profileModel=profileModels.get(i);
        holder.txtsname.setText(profileModel.getFirst()+
                "\nAddress :-  "+profileModel.getAddress()+
                "\nOpen Time :- "+profileModel.getC_time()+
                "\nClose Time :- "+profileModel.getO_time());
        holder.tvName.setVisibility(View.GONE);



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, StationDetailsActivity.class);
                intent.putExtra("name",profileModel.getFirst());
                intent.putExtra("mobile",profileModel.getMobile());
                intent.putExtra("email",profileModel.getEmail());
                intent.putExtra("city",profileModel.getCity());
                intent.putExtra("address",profileModel.getAddress());
                intent.putExtra("state",profileModel.getState());
                intent.putExtra("o_time",profileModel.getO_time());
                intent.putExtra("c_time",profileModel.getC_time());
                intent.putExtra("call","station");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);

            }
        });


    }




    @Override
    public int getItemCount() { return profileModels.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtsname,tvName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtsname=itemView.findViewById(R.id.tvReview);
            tvName=itemView.findViewById(R.id.tvName);

        }
    }
}