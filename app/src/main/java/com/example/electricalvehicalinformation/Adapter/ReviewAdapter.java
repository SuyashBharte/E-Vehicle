package com.example.electricalvehicalinformation.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.electricalvehicalinformation.Models.ReviewModel;
import com.example.electricalvehicalinformation.R;

import java.util.ArrayList;
import java.util.List;


public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder> {

    private Context mContext;
    List<ReviewModel> categoryModels = new ArrayList<ReviewModel>();

    public ReviewAdapter(Context mContext, List<ReviewModel> categoryModels) {
        this.mContext = mContext;
        this.categoryModels = categoryModels;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.review_list_item, viewGroup, false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, final int i) {
        final ReviewModel categoryModel=categoryModels.get(i);

        System.out.println("Name === "+categoryModel.getR_name());

        holder.tvName.setText(categoryModel.getR_name());
        holder.tvReview.setText(categoryModel.getR_review());
        holder.tvReadMore.setVisibility(View.GONE);



    }

    @Override
    public int getItemCount() {
        return categoryModels.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvReview,tvName,tvReadMore;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvReview=itemView.findViewById(R.id.tvReview);
            tvName=itemView.findViewById(R.id.tvName);
            tvReadMore=itemView.findViewById(R.id.tvReadMore);
        }
    }
}
