package com.example.electricalvehicalinformation.Fragment;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.electricalvehicalinformation.Api.RetrofitClient;
import com.example.electricalvehicalinformation.Models.RegisterResponse;
import com.example.electricalvehicalinformation.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AddreviewFragment extends BottomSheetDialogFragment {
    CardView add_review;
    EditText edtReview;
    SessionManager sessionManager;


    public static AddreviewFragment newInstance() {
        return new AddreviewFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_addreview, container, false);

        String Id = getArguments().getString("car_id");
        add_review=view.findViewById(R.id.add_review);
        edtReview=view.findViewById(R.id.edtReview);
        sessionManager = new SessionManager(getActivity());

        add_review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String review  = edtReview.getText().toString();

                if (TextUtils.isEmpty(review)){
                    edtReview.setError("Please Enter Your Review");
                    edtReview.requestFocus();
                    return;
                }else {
                    Call<RegisterResponse> call = RetrofitClient
                            .getInstance()
                            .getApi()
                            .insertReview(sessionManager.getStringData("name"),sessionManager.getStringData("email"),review,Id);
                    call.enqueue(new Callback<RegisterResponse>() {
                        @Override
                        public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                            if (response.isSuccessful() && response.body() != null) {
                                RegisterResponse registerResponse = response.body();
                                System.out.println("REGISTERRESPONSE" + registerResponse.getMessage());

                                if ("Not Inserted.".equals(registerResponse.getMessage())) {
                                    Toast.makeText(getActivity(), "Not Inserted", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getActivity(), "Inserted Successfully", Toast.LENGTH_SHORT).show();
                                    dismiss();
                                }
                            } else {
                                Toast.makeText(getActivity(), "Failed to submit review", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<RegisterResponse> call, Throwable t) {
                            Toast.makeText(getActivity(),t.getMessage(), Toast.LENGTH_SHORT).show();


                        }
                    });


                }
            }
        });

   return view;
    }
}