package com.example.electricalvehicalinformation.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.electricalvehicalinformation.Models.ShowroomDetaillist;
import com.example.electricalvehicalinformation.R;
import com.example.electricalvehicalinformation.ShowroomDetailsActivity;
import com.example.electricalvehicalinformation.StationDetailsActivity;

import java.util.ArrayList;
import java.util.List;

public class ShowroomAdapter extends RecyclerView.Adapter<ShowroomAdapter.ViewHolder> {

    private Context mContext;
    List<ShowroomDetaillist> profileModels = new ArrayList<ShowroomDetaillist>();

    public ShowroomAdapter(Context mContext, List<ShowroomDetaillist> profileModels) {
        this.mContext = mContext;
        this.profileModels = profileModels;
    }

    @NonNull
    @Override
    public ShowroomAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.review_list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ShowroomAdapter.ViewHolder holder, final int i) {
        final ShowroomDetaillist profileModel = profileModels.get(i);
        holder.sname.setText(profileModel.getShname());
        holder.tvName.setVisibility(View.GONE);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, StationDetailsActivity.class);
                intent.putExtra("name",profileModel.getShname());
                intent.putExtra("mobile",profileModel.getMobile());
                intent.putExtra("email",profileModel.getEmail());
                intent.putExtra("city",profileModel.getCity());
                intent.putExtra("address",profileModel.getAddress());
                intent.putExtra("state",profileModel.getState());
                intent.putExtra("call","showroom");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);

            }
        });


    }







    @Override
    public int getItemCount() { return profileModels.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView sname,tvName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sname=itemView.findViewById(R.id.tvReview);
            tvName=itemView.findViewById(R.id.tvName);
        }
    }
}
