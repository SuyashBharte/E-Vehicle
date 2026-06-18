package com.example.electricalvehicalinformation.Adapter;

import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.electricalvehicalinformation.R;

import java.util.List;

public class MyListAdapter extends ArrayAdapter<String> {

    private final Activity context;

    private final List<String> imgid;

    public MyListAdapter(Activity context, List<String> imgid) {
        super(context, R.layout.slider_list_item);
        // TODO Auto-generated constructor stub

        this.context=context;

        this.imgid=imgid;

    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.slider_list_item, null,true);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.iv_imagev);

        System.out.println("Adapter Date SLJ -->   ");

        Glide.with(context)
                .load(imgid)
                .into(imageView);


      //  imageView.setImageResource(Integer.parseInt(imgid.get(position)));

        return rowView;

    };
}