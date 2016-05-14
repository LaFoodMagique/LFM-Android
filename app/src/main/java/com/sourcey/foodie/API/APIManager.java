package com.sourcey.foodie.API;

import com.sourcey.foodie.API.managers.Authenticate;

/**
 * Created by sp4rkh on 14/05/16.
 */
public class APIManager
{
    private final static String rootURL = "http://127.0.0.1:8000/";

    public static String token = null;

    public static Authenticate auth = new Authenticate(rootURL);



    public static interface APIListener
    {
        public void onResponse(String json);
    }


}
