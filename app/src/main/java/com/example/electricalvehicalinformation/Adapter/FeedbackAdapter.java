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
import com.example.electricalvehicalinformation.Models.CarImageResponse;
import com.example.electricalvehicalinformation.Models.FeedbackModel;
import com.example.electricalvehicalinformation.R;

import java.util.ArrayList;
import java.util.List;


public class FeedbackAdapter extends RecyclerView.Adapter<FeedbackAdapter.ViewHolder> {

    private Context mContext;
    List<FeedbackModel> profileModels = new ArrayList<FeedbackModel>();

    public FeedbackAdapter(Context mContext, List<FeedbackModel> profileModels) {
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
        final FeedbackModel profileModel=profileModels.get(i);
        holder.txtsname.setText(profileModel.getReview());
        holder.tvName.setText(profileModel.getCname());

        holder.tvReadMore.setVisibility(View.GONE);

    }




    @Override
    public int getItemCount() { return profileModels.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtsname,tvName,tvReadMore;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtsname=itemView.findViewById(R.id.tvReview);
            tvName=itemView.findViewById(R.id.tvName);
            tvReadMore=itemView.findViewById(R.id.tvReadMore);

        }
    }
}