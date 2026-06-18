package com.example.electricalvehicalinformation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StationDetailsActivity extends AppCompatActivity {
    CardView cd_call,cd_map;
    TextView txtDetails,tvTitle;
    String name,mobile,email,city,address,state,o_time,c_time;
String Call="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station_details);

        Call=getIntent().getStringExtra("call");

        if (Call.equals("showroom")){
            name=getIntent().getStringExtra("name");
            mobile=getIntent().getStringExtra("mobile");
            email=getIntent().getStringExtra("email");
            city=getIntent().getStringExtra("city");
            address=getIntent().getStringExtra("address");
            state=getIntent().getStringExtra("state");


        }else {
            name=getIntent().getStringExtra("name");
            mobile=getIntent().getStringExtra("mobile");
            email=getIntent().getStringExtra("email");
            city=getIntent().getStringExtra("city");
            address=getIntent().getStringExtra("address");
            state=getIntent().getStringExtra("state");
            o_time=getIntent().getStringExtra("o_time");
            c_time=getIntent().getStringExtra("c_time");
        }

        cd_call=findViewById(R.id.cd_call);
        cd_map=findViewById(R.id.cd_map);
        txtDetails=findViewById(R.id.txtDetails);
        tvTitle=findViewById(R.id.tvTitle);

        if (Call.equals("showroom")){
            tvTitle.setText("Showroom Details");
        }else {
            tvTitle.setText("Charging Station Details");
        }

        if (Call.equals("showroom")){
            txtDetails.setText("Name  :- "+name+
                    "\nMobile No :- "+mobile+
                    "\nEmial :- "+email+
                    "\naddress :- "+address+
                    "\ncity :- "+city+
                    "\nstate :- "+state

            );
        }else{
            txtDetails.setText("Name  :- "+name+
                    "\nMobile No :- "+mobile+
                    "\nEmial :- "+email+
                    "\naddress :- "+address+
                    "\ncity :- "+city+
                    "\nstate :- "+state+
                    "\nOpent Time :- "+c_time+
                    "\nClose Time :- "+o_time
            );
        }


        cd_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://maps.google.com/maps?daddr="+address;
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,  Uri.parse(url));
                startActivity(intent);
            }
        });



        cd_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String uri = "tel:" + mobile.trim() ;
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse(uri));
                startActivity(intent);
            }
        });

    }
}