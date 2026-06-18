package com.example.electricalvehicalinformation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.electricalvehicalinformation.Adapter.ReviewAdapter;
import com.example.electricalvehicalinformation.Api.ApiService;
import com.example.electricalvehicalinformation.Api.RetrofitClient;
import com.example.electricalvehicalinformation.Fragment.InternetConnection;
import com.example.electricalvehicalinformation.Models.ReviewList;
import com.example.electricalvehicalinformation.Models.ReviewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CheckReviewActivity extends AppCompatActivity {
String MD_ID = "";
    RecyclerView review_list;
    List<ReviewModel> Personsname1 = new ArrayList<ReviewModel>();
    ReviewAdapter profileAdapterr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_review);

        MD_ID= getIntent().getStringExtra("MD_ID");
        review_list=findViewById(R.id.review_list);

        if (InternetConnection.isInternetAvailable(CheckReviewActivity.this)) {
            loadJSONReviewCategory(MD_ID);

        } else {
            showSnack("Please check your Internet Connection.");
        }

    }

    private void loadJSONReviewCategory(String id) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();


        ApiService api = retrofit.create(ApiService.class);
        Call<ReviewList> call=api.getreviewList(id);

        call.enqueue(new Callback<ReviewList>() {
            @Override
            public void onResponse(Call<ReviewList> call, Response<ReviewList> response) {
                if (response.isSuccessful()) {
                    System.out.println("Server Response review-- "+response.body().getCategorylist().size());
                    List<ReviewModel> categoryItems = response.body().getCategorylist();
                    review_list.removeAllViews();
                    Personsname1.clear();
                    System.out.println(categoryItems);

                    if (categoryItems != null && categoryItems.size() > 0) {
                        for (int i = 0; i < categoryItems.size(); i++) {
                            System.out.println("Server Response -- "+categoryItems.get(i));
                            Personsname1.add(categoryItems.get(i));
                            System.out.println("Server Response -- 1122"+Personsname1.size());
                        }
                        review_list.setVisibility(View.VISIBLE);

                        profileAdapterr = new ReviewAdapter(getApplicationContext(), Personsname1);
                        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(CheckReviewActivity.this);
                        //review_list.setLayoutManager(new LinearLayoutManager(ProfileDetaailsActivity.this, LinearLayoutManager.HORIZONTAL, true));
                        review_list.setLayoutManager(mLayoutManager);
                        review_list.setHasFixedSize(true);
                        review_list.setAdapter(profileAdapterr);

                        //System.out.println("ItemCount : " + profileAdapter.getItemCount());
                    } else {
                        review_list.setVisibility(View.GONE);
                        showSnack("No Data Found");
                    }
                } else {
                    // error case
                    review_list.setVisibility(View.GONE);
                    showSnack("Failed to Retrive Data ");

                    System.out.println("Error : " + response.errorBody());
                    switch (response.code()) {
                        case 404:
                            showSnack("Server Error 404");
                            //Toast.makeText(LoginActivity.this, "not found", Toast.LENGTH_SHORT).show();
                            break;
                        case 500:
                            //Toast.makeText(LoginActivity.this, "Error 500", Toast.LENGTH_SHORT).show();
                            showSnack("server broken");
                            break;
                        default:
                            showSnack("unknown error");
                            break;
                    }
                }
            }


            @Override
            public void onFailure(Call<ReviewList> call, Throwable t) {
                Toast.makeText(CheckReviewActivity.this, "Error - "+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void showSnack(String message){
        Snackbar snack = Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG);
        View view = snack.getView();
        FrameLayout.LayoutParams params =(FrameLayout.LayoutParams)view.getLayoutParams();
        params.gravity = Gravity.TOP;
        view.setLayoutParams(params);
        snack.show();
    }

}