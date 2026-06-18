package com.example.electricalvehicalinformation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.electricalvehicalinformation.Api.ApiService;
import com.example.electricalvehicalinformation.Api.RetrofitClient;
import com.example.electricalvehicalinformation.Models.CarDetailsList;
import com.example.electricalvehicalinformation.Models.CarDetailsList_Second;
import com.example.electricalvehicalinformation.Models.CarImageResponse;
import com.example.electricalvehicalinformation.Models.Car_List_second;
import com.example.electricalvehicalinformation.Models.Carlist;
import com.example.electricalvehicalinformation.Models.ProfileList;
import com.google.android.material.snackbar.Snackbar;
import com.kaopiz.kprogresshud.KProgressHUD;

import java.util.ArrayList;
import java.util.List;

import InternetConnection.InternetConnection;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CompareCarActivity extends AppCompatActivity {
    List<CarImageResponse> Personsname = new ArrayList<CarImageResponse>();
    Spinner spinner_1,spinner_2;
    CardView cd_enquiry;
    List<String>roomlist= new ArrayList<String>();

    String Car1_id = "",Car2_id ="";


    LinearLayout layout1;
    HorizontalScrollView layout2;
    
    TextView t1,t12,mtype,mtype2,wheel,wheel2,mno,mno2,t2,t22,t3,t32,t4,t42,t6,t62,t7,t72,t8,t82,t9,t92,tt,tt2,tt22,ttvWarrently;
    ImageView image,image2;

    List<CarDetailsList> Personsnam1e = new ArrayList<CarDetailsList>();
    List<CarDetailsList_Second> Personsnam2e = new ArrayList<CarDetailsList_Second>();
    private KProgressHUD hud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_car);



        hud = KProgressHUD.create(this);
        hud.setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel("Please wait")
                .setCancellable(true)
                .setAnimationSpeed(2)
                .setDimAmount(0.5f);

        spinner_1=findViewById(R.id.spinner_1);
        spinner_2=findViewById(R.id.spinner_2);
        cd_enquiry=findViewById(R.id.cd_enquiry);
        layout1=findViewById(R.id.layout1);
        layout2=findViewById(R.id.layout2);


        t1= findViewById(R.id.tvName);
        mtype= findViewById(R.id.tvModelType);
        wheel= findViewById(R.id.tvWheelSize);
        t2= findViewById(R.id.t2);
        t3= findViewById(R.id.t3);
        t4= findViewById(R.id.t4);
        t6= findViewById(R.id.t6);
        t7= findViewById(R.id.t7);
        t8= findViewById(R.id.t8);
        t9= findViewById(R.id.t9);
        tt= findViewById(R.id.tt);
        tt2= findViewById(R.id.tt2);
        mno= findViewById(R.id.tvModelNo);
        image= findViewById(R.id.image);

        t12= findViewById(R.id.tvName2);
        mtype2= findViewById(R.id.tvModelType2);
        wheel2= findViewById(R.id.tvWheelSize2);
        t22= findViewById(R.id.t22);
        t32= findViewById(R.id.t32);
        t42= findViewById(R.id.t42);
        t62= findViewById(R.id.t62);
        t72= findViewById(R.id.t72);
        t82= findViewById(R.id.t82);
        t92= findViewById(R.id.t92);
        tt2= findViewById(R.id.tt2);
        tt22= findViewById(R.id.tt22);
        ttvWarrently= findViewById(R.id.ttvWarrently);
        mno2= findViewById(R.id.tvModelNo2);
        image2= findViewById(R.id.image2);



        if (InternetConnection.isInternetAvailable(CompareCarActivity.this)) {
            hud.show();
            loadJSONCategory();
        } else {
            showSnack("Please check your Internet Connection.");
        }

        spinner_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (!spinner_1.getSelectedItem().equals("Select Car")){
                    Car1_id =   Personsname.get(i-1).getMdId();
                } else {
                    Car1_id = "";
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (!spinner_2.getSelectedItem().equals("Select Car")){
                    Car2_id =   Personsname.get(i-1).getMdId();
                } else {
                    Car2_id = "";
                }



            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        cd_enquiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Car1 = spinner_1.getSelectedItem().toString();
                String Car2 = spinner_2.getSelectedItem().toString();

                if (Car1.equals("Select Car")){
                    Toast.makeText(CompareCarActivity.this, "Please Select Car 1", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (Car2.equals("Select Car")){
                    Toast.makeText(CompareCarActivity.this, "Please Select Car 2", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (Car1.equals(Car2)){
                    Toast.makeText(CompareCarActivity.this, "Please Select Different Cars", Toast.LENGTH_SHORT).show();
                    return;
                }


                layout1.setVisibility(View.GONE);
                layout2.setVisibility(View.VISIBLE);
                CarDetailsLoan1();
                CarDetailsLoan2();





            }
        });

    }


    private void loadJSONCategory() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();


        ApiService api = retrofit.create(ApiService.class);
        Call<ProfileList> call=api.getscheme();

        call.enqueue(new Callback<ProfileList>() {
            @Override
            public void onResponse(Call<ProfileList> call, Response<ProfileList> response) {
                hud.dismiss();
                if (response.isSuccessful()) {
                    List<CarImageResponse> categoryItems = response.body().getCategorylist();
                    Personsname.clear();
                    System.out.println(categoryItems);

                    if (categoryItems != null && categoryItems.size() > 0) {
                        for (int i = 0;i < categoryItems.size();i++){
                            Personsname.add(categoryItems.get(i));
                        }
                        AddSpinnerData();
                    }else{

                        showSnack("No Data Found");
                    }


                }
                else {

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
            public void onFailure(Call<ProfileList> call, Throwable t) {
                hud.dismiss();
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

    @Override
    protected void onResume() {

        super.onResume();
    }

    private void AddSpinnerData() {
        roomlist.add("Select Car");
        for (int i=0;i<Personsname.size();i++){
            roomlist.add(Personsname.get(i).getCarname());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(CompareCarActivity.this, android.R.layout.simple_spinner_item,roomlist);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_1.setAdapter(adapter);
        spinner_2.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    private void CarDetailsLoan1() {
        hud.show();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        ApiService api = retrofit.create(ApiService.class);
        Call<Carlist> call=api.getprofiledetails(Car1_id);

        call.enqueue(new Callback<Carlist>() {
            @Override
            public void onResponse(Call<Carlist> call, Response<Carlist> response) {
                hud.dismiss();
                if (response.isSuccessful()) {
                    List<CarDetailsList> categoryItems = response.body().getCategorylist();
                    Personsnam1e.clear();
                    System.out.println(categoryItems);


                    if (categoryItems != null && categoryItems.size() > 0) {
                        for (int i = 0; i < categoryItems.size(); i++) {
                            Personsnam1e.add(categoryItems.get(i));
                        }

                        FillDetailsOne();
                    } else {
                        showSnack("No Data Found");
                    }
                } else {
                    // error case
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
                hud.dismiss();
            }
        });
    }

    private void FillDetailsOne() {

        Glide.with(CompareCarActivity.this)
                .load(Personsnam1e.get(0).getPhoto())
                .into(image);

        t1.setText(Personsnam1e.get(0).getCarname());
        mno.setText(Personsnam1e.get(0).getModelno());
        mtype.setText(Personsnam1e.get(0).getModeltype());
        wheel.setText(Personsnam1e.get(0).getWsize());
        t2.setText(Personsnam1e.get(0).getLaunchdate());
        t3.setText(Personsnam1e.get(0).getSpecification());
        t4.setText(Personsnam1e.get(0).getFeatures());
        t6.setText(Personsnam1e.get(0).getCost());
        tt2.setText(Personsnam1e.get(0).getVariant());
        t7.setText(Personsnam1e.get(0).getRange());
        t8.setText(Personsnam1e.get(0).getMotor());
        t9.setText(Personsnam1e.get(0).getBattery());
        tt.setText(Personsnam1e.get(0).getWarranty());
    }
    private void FillDetailsTwo() {
        try {
            Glide.with(CompareCarActivity.this)
                    .load(Personsnam2e.get(0).getPhoto())
                    .into(image2);

            t12.setText(Personsnam2e.get(0).getCarname());
            mno2.setText(Personsnam2e.get(0).getModelno());
            mtype2.setText(Personsnam2e.get(0).getModeltype());
            wheel2.setText(Personsnam2e.get(0).getWsize());
            t22.setText(Personsnam2e.get(0).getLaunchdate());
            t32.setText(Personsnam2e.get(0).getSpecification());
            t42.setText(Personsnam2e.get(0).getFeatures());
            t62.setText(Personsnam2e.get(0).getCost());
            tt22.setText(Personsnam2e.get(0).getVariant());
            t72.setText(Personsnam2e.get(0).getRange());
            t82.setText(Personsnam2e.get(0).getMotor());
            t92.setText(Personsnam2e.get(0).getBattery());
            ttvWarrently.setText(Personsnam2e.get(0).getWarranty());


        }catch (Exception e){
            Toast.makeText(this, "Error : "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
    private void CarDetailsLoan2() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        ApiService api = retrofit.create(ApiService.class);
        Call<Car_List_second> call=api.getCarDetails(Car2_id);

        call.enqueue(new Callback<Car_List_second>() {
            @Override
            public void onResponse(Call<Car_List_second> call, Response<Car_List_second> response) {
                if (response.isSuccessful()) {
                    List<CarDetailsList_Second> categoryItems_ = response.body().getCategorylist();
                    Personsnam2e.clear();
                    System.out.println("Section Two -- > "+ categoryItems_);


                    if (categoryItems_ != null && categoryItems_.size() > 0) {
                        for (int i = 0; i < categoryItems_.size(); i++) {
                            Personsnam2e.add(categoryItems_.get(i));
                        }

                        FillDetailsTwo();
                    } else {
                        showSnack("No Data Found");
                    }
                } else {
                    // error case
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
            public void onFailure(Call<Car_List_second> call, Throwable t) {

            }
        });
    }
}