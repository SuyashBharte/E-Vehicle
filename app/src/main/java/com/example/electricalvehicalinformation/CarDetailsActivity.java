package com.example.electricalvehicalinformation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.electricalvehicalinformation.Adapter.CarDetailsAdapter;
import com.example.electricalvehicalinformation.Adapter.MyListAdapter;
import com.example.electricalvehicalinformation.Api.ApiService;
import com.example.electricalvehicalinformation.Api.RetrofitClient;
import com.example.electricalvehicalinformation.Fragment.AddreviewFragment;
import com.example.electricalvehicalinformation.Models.CarDetailsList;
import com.example.electricalvehicalinformation.Models.Carlist;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import InternetConnection.InternetConnection;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CarDetailsActivity extends AppCompatActivity {

    String mdid;

    FloatingActionButton fabaddgatepass;
    ProgressDialog progressDialog;
    RecyclerView recyclerView;
    CarDetailsAdapter carDetailsAdapter;
    List<CarDetailsList> Personsname = new ArrayList<CarDetailsList>();

    CardView cd_enquiry,cd_view_enquiry;
    LinearLayout imagelist;
    List<String>roomlist = new ArrayList<String>();
    //    @android.support.RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);


        Intent intent=getIntent();
        mdid=intent.getStringExtra("md_id");

        cd_enquiry =findViewById(R.id.cd_enquiry);
        imagelist =findViewById(R.id.imagelist);
        cd_view_enquiry =findViewById(R.id.cd_view_enquiry);
        recyclerView = (RecyclerView) findViewById(R.id.employee_list);
        progressDialog = new ProgressDialog(this);
        //onClickShowStudentDetails = this;

        FragmentManager fragmentManager = getFragmentManager();

        if (InternetConnection.isInternetAvailable(CarDetailsActivity.this)) {
            //mSwipeRefreshLayout.setRefreshing(true);
            loadJSONCategory(mdid);
        } else {
            showSnack("Please check your Internet Connection.");
        }

        cd_view_enquiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 =new Intent(getApplicationContext(),FeedbackListActivity.class);
                intent1.putExtra("MD_ID",mdid);
                startActivity(intent1);
                finish();
            }
        });



        cd_enquiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddreviewFragment addPhotoBottomDialogFragment =
                        AddreviewFragment.newInstance();
                Bundle bundle = new Bundle();
                bundle.putString("car_id",mdid);
                addPhotoBottomDialogFragment.setArguments(bundle);
                addPhotoBottomDialogFragment.show(getSupportFragmentManager(),
                        "add_hospital_dialog_fragment");
            }
        });

    }

    private void loadJSONCategory(String category) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        ApiService api = retrofit.create(ApiService.class);
        Call<Carlist> call=api.getprofiledetails(this.mdid);

        call.enqueue(new Callback<Carlist>() {
            @Override
            public void onResponse(Call<Carlist> call, Response<Carlist> response) {
                if (response.isSuccessful()) {
                    List<CarDetailsList> categoryItems = response.body().getCategorylist();
                    recyclerView.removeAllViews();
                    Personsname.clear();
                    System.out.println(categoryItems);


                    if (categoryItems != null && categoryItems.size() > 0) {
                        for (int i = 0; i < categoryItems.size(); i++) {
                            Personsname.add(categoryItems.get(i));
                        }
                        recyclerView.setVisibility(View.VISIBLE);

                        carDetailsAdapter = new CarDetailsAdapter(getApplicationContext(), Personsname);
                        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(CarDetailsActivity.this);
                        recyclerView.setLayoutManager(mLayoutManager);
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setAdapter(carDetailsAdapter);
                        sliderFunction();

                        System.out.println("ItemCount : " + carDetailsAdapter.getItemCount());
                    } else {
                        recyclerView.setVisibility(View.GONE);
                        showSnack("No Data Found");
                    }
                } else {
                    // error case
                    recyclerView.setVisibility(View.GONE);
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
            public void onFailure(Call<Carlist> call, Throwable t) {

            }
        });
    }




    public void showSnack(String message){
//        TSnackbar snackbar = TSnackbar.make(findViewById(android.R.id.content), message, TSnackbar.LENGTH_LONG);
//        View snackbarView = snackbar.getView();
//       snackbarView.setBackgroundColor(getResources().getColor(R.color.black));
//       TextView textView = (TextView) snackbarView.findViewById(com.androidadvance.topsnackbar.R.id.snackbar_text);
//        textView.setTextColor(Color.WHITE);
//       snackbar.show();

        Snackbar snack = Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG);
        View view = snack.getView();
        FrameLayout.LayoutParams params =(FrameLayout.LayoutParams)view.getLayoutParams();
        params.gravity = Gravity.TOP;
        view.setLayoutParams(params);
        snack.show();
    }

    @Override
    protected void onResume() {
        if (InternetConnection.isInternetAvailable(CarDetailsActivity.this)) {

        } else {
            showSnack("Please check your Internet Connection.");
        }
        super.onResume();
    }

    public void showToast(String message){
        Toast toast = Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }

    private void sliderFunction(){
        try {
            if (Personsname == null || Personsname.isEmpty() || Personsname.get(0).getPhoto() == null) {
                return;
            }
            System.out.println("Roomlist Data sssssssssssss --> "+Personsname.get(0).getPhoto());
            String[] separated = Personsname.get(0).getPhoto().toString().split(",");

            int limit = Math.min(separated.length, 10);
            for (int j = 0; j < limit; j++) {
                String imgUrl = separated[j].trim();
                if (!imgUrl.isEmpty()) {
                    ImageView imageView = new ImageView(CarDetailsActivity.this);
                    Glide.with(CarDetailsActivity.this)
                            .load(imgUrl)
                            .into(imageView);
                    addvieW(imageView, 300, 250);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void addvieW(ImageView imageView, int width, int height) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(300, 250);

        // setting the margin in linearlayout
        params.setMargins(10, 10, 0, 10);
        imageView.setLayoutParams(params);


        // adding the image in layout
        imagelist.addView(imageView);

        imagelist.setGravity(Gravity.CENTER);

    }
}


