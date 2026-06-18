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
import com.example.electricalvehicalinformation.R;

import java.util.ArrayList;
import java.util.List;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder> {

    private Context mContext;
    List<CarImageResponse> profileModels = new ArrayList<CarImageResponse>();

    public ProfileAdapter(Context mContext, List<CarImageResponse> profileModels) {
        this.mContext = mContext;
        this.profileModels = profileModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gridlayout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int i) {
        final CarImageResponse profileModel=profileModels.get(i);
        holder.txtsname.setText(profileModel.getCarname());


        if (profileModel.getPhoto() != null) {
            String[] separated = profileModel.getPhoto().toString().split(",");
            if (separated.length > 0 && !separated[0].trim().isEmpty()) {
                Glide.with(mContext)
                        .load(separated[0].trim())
                        .into(holder.image);
            }
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(mContext, CarDetailsActivity.class);
                intent.putExtra("md_id",profileModel.getMdId());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);



            }
        });
    }




    @Override
    public int getItemCount() { return profileModels.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtsname;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtsname=itemView.findViewById(R.id.txtsname);
            image=itemView.findViewById(R.id.image);
        }
    }
}
