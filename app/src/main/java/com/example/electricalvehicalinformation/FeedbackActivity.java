package com.example.electricalvehicalinformation;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.electricalvehicalinformation.Api.RetrofitClient;
import com.example.electricalvehicalinformation.Models.LoginResponse;
import com.example.electricalvehicalinformation.Models.feedbackmain;

public class FeedbackActivity extends AppCompatActivity {
    public  EditText edt_project_name;
    public  EditText edt_mail;
    public EditText edt_mobile;
    public EditText edt_feedback;
    public Button btn_enquiry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        edt_project_name = findViewById(R.id.edt_project_name);
        edt_mail = findViewById(R.id.edt_mail);
        edt_mobile = findViewById(R.id.edt_mobile);
        edt_feedback = findViewById(R.id.edt_feedback);
        btn_enquiry = findViewById(R.id.btn_enquiry);
        btn_enquiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<feedbackmain> call = RetrofitClient
                        .getInstance()
                        .getApi()
                        .userFeedback(edt_project_name.getText().toString(), edt_mail.getText().toString(),edt_mobile.getText().toString(),edt_feedback.getText().toString());

                call.enqueue(new Callback<feedbackmain>() {
                    @Override
                    public void onResponse(Call<feedbackmain> call, Response<feedbackmain> response) {
                        if (response.isSuccessful() && response.body() != null && response.body().getData() != null) {
                            Toast.makeText(FeedbackActivity.this, response.body().getData().getMessage(), Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(FeedbackActivity.this, DashboardActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(FeedbackActivity.this, "Failed to submit feedback", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<feedbackmain> call, Throwable t) {
                        Toast.makeText(FeedbackActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }
}