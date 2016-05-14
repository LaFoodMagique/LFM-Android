package com.sourcey.foodie.API.httprequests;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.sourcey.foodie.API.APIManager;

import java.util.Map;

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
    }

    public static void post(final String url, final Map<String, String> params, final Context context, final APIManager.APIListener listener)
    {
        if (queue == null) {
            queue = Volley.newRequestQueue(context);
        }
    }

    public static void put(final String url, final Map<String, String> params, final Context context, final APIManager.APIListener listener)
    {
        if (queue == null) {
            queue = Volley.newRequestQueue(context);
        }
    }
}
