package com.example.electricalvehicalinformation.Models;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class feedbackmain {


        @SerializedName("Data")
        @Expose
        private feedbackone data;

        public feedbackone getData() {
            return data;
        }

        public void setData(feedbackone data) {
            this.data = data;
        }

    }

