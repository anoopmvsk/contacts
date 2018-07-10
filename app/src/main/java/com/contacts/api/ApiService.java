package com.contacts.api;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.contacts.model.Contact;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.lang.reflect.Type;
import java.util.ArrayList;


/**
 * Created by anoop on 6/8/18.
 * <p>
 * ApiService is the class to make an API Call to server
 */

public class ApiService {
    private static final String API_URL = "https://api.myjson.com/bins/jz6bp";
    //private static OkHttpClient client = new OkHttpClient();

    /**
     * Fetches the Contacts from API
     *
     * @param responseListener
     */
    public static void onGetContacts(Context context, final ResponseListener responseListener) {

        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, API_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            ArrayList<Contact> contacts = getContacts(jsonObject.getJSONArray("contacts"));
                            if (contacts != null)
                                responseListener.onResponseSuccess(contacts);
                            else
                                responseListener.onResponseError("Something went wrong, please try again.");
                        } catch (JSONException je) {
                            responseListener.onResponseError("Something went wrong, please try again.");
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                responseListener.onResponseError("Something went wrong, please try again.");
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    /**
     * Converts the response json to model class
     *
     * @param contactsArray
     * @return
     */
    private static ArrayList<Contact> getContacts(JSONArray contactsArray) {
        Type listType = new TypeToken<ArrayList<Contact>>() {
        }.getType();
        return
                new GsonBuilder().create().fromJson(contactsArray.toString(), listType);
    }


}
