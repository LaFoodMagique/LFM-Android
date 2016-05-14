package com.sourcey.foodie.API.managers;

import android.content.Context;

import com.sourcey.foodie.API.APIManager;
import com.sourcey.foodie.API.httprequests.HttpRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sp4rkh on 14/05/16.
 */
public class Authenticate
{
    private static String authRootURL;

    public Authenticate(final String rootURL)
    {
        authRootURL = rootURL;
    }

    public void login(final String email, final String password, final Context context, final APIManager.APIListener listener)
    {
        String url = authRootURL + "/foodie/auth/login";

        Map<String, String> params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);

        HttpRequest.post(url, params, context, listener);
    }

    public void logout(final Context context, final APIManager.APIListener listener)
    {
        String url = "";
    }
}
