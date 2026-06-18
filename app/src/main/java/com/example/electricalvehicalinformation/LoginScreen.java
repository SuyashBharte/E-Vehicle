package com.example.electricalvehicalinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.electricalvehicalinformation.Api.RetrofitClient;
import com.example.electricalvehicalinformation.Fragment.SessionManager;
import com.example.electricalvehicalinformation.Models.LoginResponse;
import com.kaopiz.kprogresshud.KProgressHUD;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginScreen extends AppCompatActivity  implements View.OnClickListener {
    private KProgressHUD hud;
    private EditText edt_name;
    private EditText edt_pass;
    SessionManager sessionManager ;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        sessionManager = new SessionManager(this);
        edt_pass = findViewById(R.id.edt_pass);
        edt_name = findViewById(R.id.edt_name);

        hud = KProgressHUD.create(this);
        hud.setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel("Please wait")
                .setCancellable(true)
                .setAnimationSpeed(2)
                .setDimAmount(0.5f);


        findViewById(R.id.button4).setOnClickListener((View.OnClickListener) this);
        findViewById(R.id.textView6).setOnClickListener((View.OnClickListener) this);


    }


    private void userLogin() {
        String Email = edt_name.getText().toString().trim();
        String Password = edt_pass.getText().toString().trim();

        if (Email.isEmpty()) {
            edt_name.setError("Email Is Required");
            edt_name.requestFocus();
            return;
        }
        if (Password.isEmpty()) {
            edt_pass.setError("Password Is Required");
            edt_pass.requestFocus();
            return;
        }
        if (Password.length() < 8) {
            edt_pass.setError("Password Should Be Atleast 8 Character Long");
            edt_pass.requestFocus();
            return;

        }




        hud.show();
        Call<LoginResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .userLogin(Email, Password);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                hud.dismiss();
                if (response.isSuccessful() && response.body() != null) {
                    LoginResponse loginResponse = response.body();
                    System.out.println("LOGINRESPONSE" + loginResponse.getMessage());

                    if ("user not found.".equals(loginResponse.getMessage())) {
                        Toast.makeText(LoginScreen.this, "User Not Found", Toast.LENGTH_SHORT).show();
                    } else {
                        System.out.println("Name -- "+loginResponse.getName());
                        System.out.println("Email -- "+loginResponse.getEmail());
                        sessionManager.putStringData("name",loginResponse.getName());
                        sessionManager.putStringData("email",loginResponse.getEmail());
                        Toast.makeText(LoginScreen.this, "Login Successful", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(LoginScreen.this, DashboardActivity.class);
                        startActivity(intent);
                        finish();
                    }
                } else {
                    Toast.makeText(LoginScreen.this, "Login Failed or Invalid Response", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                hud.dismiss();
                Toast.makeText(LoginScreen.this,t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }




    @Override
    public void onClick (View v){
        switch (v.getId()) {
            case R.id.button4:
                userLogin();
                break;
            case R.id.textView6:
                startActivity(new Intent(this, RegisterScreen.class));
                break;
        }

    }}