package com.example.electricalvehicalinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.electricalvehicalinformation.Api.RetrofitClient;
import com.example.electricalvehicalinformation.Models.RegisterResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterScreen extends AppCompatActivity implements View.OnClickListener {

    private EditText edt_name;
    private EditText edt_mail;
    private EditText edt_phone;
    private EditText edtpassword;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);


        edt_name = findViewById(R.id.edt_name);
        edt_mail = findViewById(R.id.edt_mail);
        edt_phone = findViewById(R.id.edt_phone);
        edtpassword = findViewById(R.id.edtpassword);

        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.login).setOnClickListener(this);

    }

    public void userSignUp() {
        String name = edt_name.getText().toString().trim();
        String email = edt_mail.getText().toString().trim();
        String mobile = edt_phone.getText().toString().trim();
        String password = edtpassword.getText().toString().trim();

        if (name.isEmpty()) {
            edt_name.setError("Name Is Required");
            edt_name.requestFocus();
            return;
        }
        if (email.isEmpty()) {
            edt_mail.setError("Email Is Required");
            edt_mail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edt_mail.setError("Enter Valid Email");
            edt_mail.requestFocus();
            return;
        }
        if (mobile.isEmpty()) {
            edt_phone.setError("Mobile No Is Required");
            edt_phone.requestFocus();
            return;
        }

        if (mobile.length()!=10){
            edt_phone.setError("Please Enter Valid Mobile Number ");
            edt_phone.requestFocus();
            return;
        }


        if (password.isEmpty()) {
            edtpassword.setError("Confirm Password Is Required");
            edtpassword.requestFocus();
            return;
        }
        if (password.length() < 8) {
            edtpassword.setError("Password Should Be Atleast 8 Character Long");
            edtpassword.requestFocus();
            return;
        }


        //  Call Signup Api Here...
        Call<RegisterResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .userSignup(name, email, mobile,password);

        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    RegisterResponse registerResponse = response.body();
                    System.out.println("REGISTERRESPONSE" + registerResponse.getMessage());

                    if ("Not Inserted.".equals(registerResponse.getMessage())) {
                        Toast.makeText(RegisterScreen.this, "Not Inserted", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(RegisterScreen.this, "Registration Successfully", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                } else {
                    Toast.makeText(RegisterScreen.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Toast.makeText(RegisterScreen.this, t.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button4:
                userSignUp();
                break;
            case R.id.login:
                startActivity(new Intent(this, LoginScreen.class));
                break;

        }
    }
}
