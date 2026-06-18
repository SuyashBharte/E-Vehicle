package com.example.electricalvehicalinformation.Api;

import com.example.electricalvehicalinformation.Models.Car_List_second;
import com.example.electricalvehicalinformation.Models.Carlist;
import com.example.electricalvehicalinformation.Models.FeedbackList;
import com.example.electricalvehicalinformation.Models.LoginResponse;
import com.example.electricalvehicalinformation.Models.ProfileList;
import com.example.electricalvehicalinformation.Models.RegisterResponse;
import com.example.electricalvehicalinformation.Models.ReviewList;
import com.example.electricalvehicalinformation.Models.Showroomlist;
import com.example.electricalvehicalinformation.Models.StationList;
import com.example.electricalvehicalinformation.Models.feedbackmain;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {


    @FormUrlEncoded
    @POST("signup.php")
    Call<RegisterResponse> userSignup(
            @Field("t_name") String Name ,
            @Field("t_email") String Email,
            @Field("t_mobile") String mobno,
            @Field("t_password") String Pass
    );

    @FormUrlEncoded
    @POST("login.php")
    Call<LoginResponse> userLogin(
            @Field("t_email") String EMA ,
            @Field("t_password") String password

    );
    @FormUrlEncoded
    @POST("feedback.php")
    Call<feedbackmain> userFeedback(
            @Field("fname") String fname ,
            @Field("femail") String femail,
@Field("fmobile") String fmobile,
                    @Field("fmsg") String fmsg
    );
    @GET("view_car.php")
    Call<ProfileList> getscheme(

    );

    @FormUrlEncoded
    @POST("query.php")
    Call<feedbackmain> query(
            @Field("qname") String qname ,
            @Field("qemail") String qemail,
            @Field("qmobile") String qmobile,
            @Field("qmsg") String qmsg
    );
    @FormUrlEncoded
    @POST("customer_review.php")
    Call<RegisterResponse> insertReview(
            @Field("cname") String cname ,
            @Field("cemail") String cemail,
            @Field("review") String review,
            @Field("c_id") String c_id
    );

    @FormUrlEncoded
    @POST("car_details.php")
    Call<Carlist> getprofiledetails(
            @Field("md_id") String mdid
    );


    @FormUrlEncoded
    @POST("car_details.php")
    Call<Car_List_second> getCarDetails(
            @Field("md_id") String mdid
    );

    @FormUrlEncoded
    @POST("review.php")
    Call<ReviewList> getreviewList(
            @Field("id") String id
    );

    /*@GET("view_feedback.php")
    Call<FeedbackList> getFeedback(

    );*/

    @FormUrlEncoded
    @POST("view_feedback.php")
    Call<FeedbackList> getFeedback(
            @Field("id") String id
    );
    @GET("showroom_list.php")
    Call<Showroomlist> getShowrroom(

    );


    @GET("station_list.php")
    Call<StationList> getStationList(

    );

}
