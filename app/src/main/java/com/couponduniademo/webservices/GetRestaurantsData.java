package com.couponduniademo.webservices;

import android.text.TextUtils;

import com.couponduniademo.entities.Response;
import com.couponduniademo.httphelper.JSONHelper;
import com.google.gson.Gson;

public class GetRestaurantsData {

    public static Response get() {
        // Input parameters
        String json = JSONHelper.getWSResponse();

        try {
            if (json != null && !json.equalsIgnoreCase("null") && !json.equalsIgnoreCase("{}") && !TextUtils.isEmpty(json)) {
                // getting \n from the webservice response so remove \n from response and replace with ""
                String result = json.replace("\n", "");
                Gson gson = new Gson();
                return gson.fromJson(result, Response.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
