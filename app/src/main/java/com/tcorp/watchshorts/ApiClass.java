package com.tcorp.watchshorts;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ApiClass {
    RequestQueue rq;
    public List<VideoModel> videoModelList;

    public ApiClass() {
    }

    ApiClass(Context context){
        if(videoModelList==null)
        videoModelList = new ArrayList<>();

        rq = Volley.newRequestQueue(context);
    }


    void fetchData(String url){
        Log.d("URRLLLL", url);

        StringRequest strReq = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                //Log.e("responce",""+response);

                try {
//                    JSONArray jsonArray = new JSONArray(response);
                    JSONObject jsonObject = new JSONObject(response);
                    Log.d("GELENNNNN", jsonObject.getJSONArray("items").getJSONObject(12).getJSONObject("id").getString("videoId"));
                    for(int i = 0 ; i< jsonObject.getJSONArray("items").length();i++){

                        videoModelList.add(new VideoModel(
                                jsonObject.getJSONArray("items").getJSONObject(i).getJSONObject("id").getString("videoId"),
                                jsonObject.getJSONArray("items").getJSONObject(i).getJSONObject("snippet").getString("title"),
                                jsonObject.getJSONArray("items").getJSONObject(i).getJSONObject("snippet").getJSONObject("thumbnails").getJSONObject("default").getString("url")
                        ));
                        Log.d("i",videoModelList.get(i).getId());
                        Log.d("i",videoModelList.get(i).getTitle());
                        Log.d("i",videoModelList.get(i).getImgUrl());

                    }

//                    Log.d("GELENNNNN", jsonArray.get(0).toString());
//                    //for (int i = 0; i < 1; i++) {
//
//                    //JSONObject obj = JsonArray.getJSONObject(0);
//
//                    String text= jsonObject.getString("title");
//                    //  String id= obj.getString ( "id" );
//
//
//
//                    String title = text ;
//                    //Log.e("Youtube video title","Video Title = "+title);
//                    callback.onSuccess(title);

                } catch (JSONException e) {
                    // JSON error
                    e.printStackTrace();
                    Log.d("Json Catch",e.getMessage());
                    Log.d("Json Catch",e.toString());


                }
            }
        }, new Response.ErrorListener() {
            @Override


            public void onErrorResponse(VolleyError error) {
                Log.d("VOLLEY ERROR", error.getMessage());
            }
        }) {

        };

        rq.add(strReq);

        }
    }

