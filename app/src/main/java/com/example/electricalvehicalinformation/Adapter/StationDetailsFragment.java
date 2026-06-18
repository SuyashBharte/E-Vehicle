package com.example.electricalvehicalinformation.Adapter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.electricalvehicalinformation.Fragment.AddreviewFragment;
import com.example.electricalvehicalinformation.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class StationDetailsFragment extends BottomSheetDialogFragment {

   CardView cd_call;
   TextView txtDetails;
   String name,mobile,email,city,address,state,o_time,c_time;

    public static StationDetailsFragment newInstance() {
        return new StationDetailsFragment();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_station_details, container, false);

        name=getArguments().getString("name");
        mobile=getArguments().getString("mobile");
        email=getArguments().getString("email");
        city=getArguments().getString("city");
        address=getArguments().getString("address");
        state=getArguments().getString("state");
        o_time=getArguments().getString("o_time");
        c_time=getArguments().getString("c_time");

        cd_call=view.findViewById(R.id.cd_call);
        txtDetails=view.findViewById(R.id.txtDetails);

        txtDetails.setText("Name  :- "+name+
                "Mobile No :- "+mobile+
                "Emial :- "+email+
                "address :- "+address+
                "city :- "+city+
                "state :- "+state+
                "Opent Time :- "+c_time+
                "Close Time :- "+o_time
                );


        cd_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String uri = "tel:" + mobile.trim() ;
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse(uri));
                startActivity(intent);
            }
        });

   return view;
    }
}