package com.sourcey.foodie.API;

import com.sourcey.foodie.API.managers.Authenticate;

/**
 * Created by sp4rkh on 14/05/16.
 */
public class APIManager
{
    public enum APIRoot
    {
        LOCAL,
        DEV,
        PROD;

        @Override
        public String toString() {
            switch (this) {
                case LOCAL:
                    return "http://127.0.0.1:3000/api";
                case DEV:
                    return "http://192.168.169.143:3000/api";
                case PROD:
                    return "http://xxx.xxx.xxx.xxx:3000/api";
            }
            return null;
        }
    }

    private final static APIRoot rootURL = APIRoot.LOCAL;

    public static String token = null;

    public static Authenticate auth = new Authenticate(rootURL.toString());


    public static interface APIListener
    {
        public void onResponse(String json);
    }
}
