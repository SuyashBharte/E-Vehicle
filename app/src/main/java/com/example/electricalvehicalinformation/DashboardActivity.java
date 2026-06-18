package com.example.electricalvehicalinformation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {

    TextView Info, cstation, feedback, contact,sdetails;

    CardView card_view2,card_view6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Info = findViewById(R.id.Info);
        cstation = findViewById(R.id.cstation);
        feedback = findViewById(R.id.feedback);
        contact = findViewById(R.id.contact);
        sdetails = findViewById(R.id.sdetails);
        card_view2 = findViewById(R.id.card_view2);
        card_view6 = findViewById(R.id.card_view6);


        Info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, EvInfoActivity.class);
                startActivity(intent);


            }
        });
        card_view6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, CompareCarActivity.class);
                startActivity(intent);


            }
        });
        cstation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, StationListActivity.class);
                startActivity(intent);


            }
        });



        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, FeedbackActivity.class);
              startActivity(intent);


            }
        });

        sdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, ShowroomDetailsActivity.class);
                startActivity(intent);


            }
        });


        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, ContactQueryForm.class);
                startActivity(intent);

            }
        });
    }
}