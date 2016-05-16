package com.sourcey.foodie.API.httprequests;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.sourcey.foodie.API.APIManager;

import java.util.Map;
import java.util.Objects;

/**
 * Created by sp4rkh on 14/05/16.
 */
public class HttpRequest
{
    public static RequestQueue queue = null;

    public static void get(final String url, final Context context, final APIManager.APIListener listener)
    {
        if (queue == null) {
            queue = Volley.newRequestQueue(context);
        }

        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                   @Override
                   public void onResponse(String response)
                   {
                        listener.onResponse(response);
                   }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        queue.add(request);
    }

    public static void post(final String url, final Map<String, Object> params, final Context context, final APIManager.APIListener listener)
    {
        if (queue == null) {
            queue = Volley.newRequestQueue(context);
        }

        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        listener.onResponse(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        queue.add(request);
    }

    public static void put(final String url, final Map<String, Object> params, final Context context, final APIManager.APIListener listener)
    {
        if (queue == null) {
            queue = Volley.newRequestQueue(context);
        }

        StringRequest request = null;

        queue.add(request);
    }

    public static void delete(final String url, final Context context, final APIManager.APIListener listener)
    {
        if (queue == null) {
            queue = Volley.newRequestQueue(context);
        }

        StringRequest request = null;

        queue.add(request);
    }
}
