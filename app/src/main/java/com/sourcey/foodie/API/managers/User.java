package com.sourcey.foodie.API.managers;

import android.content.Context;

import com.sourcey.foodie.API.APIManager;
import com.sourcey.foodie.API.httprequests.HttpRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by sp4rkh on 14/05/16.
 */
public class User
{
    private static String userRootURL;

    public User(final String rootURL)
    {
        userRootURL = rootURL;
    }

    public void userList(final Context context, final APIManager.APIListener listener)
    {
        String url = userRootURL + "/foodies";

        HttpRequest.get(url, context, listener);
    }

    public void userDetail(final Integer id, final Context context, final APIManager.APIListener listener)
    {
        String url = userRootURL + "/foodies/" + id.toString();

        HttpRequest.get(url, context, listener);
    }

    public void userUpdate(final Integer id,
                           final String email,
                           final String firstName, final String lastName, final String phone,
                           final String addressPart1, final String addressPart2,
                           final Context context, final APIManager.APIListener listener)
    {
        String url = userRootURL + "/users/" + id.toString();

        Map<String, Object> params = new HashMap<>();
        params.put("Email", email);
        params.put("FirstName", firstName);
        params.put("LastName", lastName);
        params.put("Phone", phone);
        params.put("AddressPart1", addressPart1);
        params.put("AddressPart2", addressPart2);

        HttpRequest.put(url, params, context, listener);
    }

    public void userDelete(final Integer id, final Context context, final APIManager.APIListener listener)
    {
        String url = userRootURL + "/users/" + id.toString();

        HttpRequest.delete(url, context, listener);
    }

    /*
        Reservations
     */

    public void getReservations(final Integer id, final Context context, final APIManager.APIListener listener)
    {
        String url = userRootURL + "/foodies/" + id.toString() + "/reservations";

        HttpRequest.get(url, context, listener);
    }

    public void createReservation(final Integer userId, final Integer restoId,
                                  final Date date, final Integer hour, final Integer nbPerson, final String comment,
                                  final Context context, final APIManager.APIListener listener)
    {
        String url = userRootURL + "/foodies/" + userId.toString() + "restautants/" + restoId.toString() + "/reservations";

        Map<String, Object> params = new HashMap<>();
        params.put("date", date);
        params.put("hour", hour);
        params.put("nbPerson", nbPerson);
        params.put("comment", comment);

        HttpRequest.post(url, params, context, listener);
    }

    /*
        Resto comments
     */

    public void getRestoComments(final Integer id, final Context context, final APIManager.APIListener listener)
    {
        String url = userRootURL + "/foodie/" + id.toString() + "/comment_restaurants";

        HttpRequest.get(url, context, listener);
    }

    public void createRestoComment(final Integer userId,
                                   final Integer restoId, final String comment, final Integer mark,
                                   final Context context, final APIManager.APIListener listener)
    {
        String url = userRootURL + "/foodies/" + userId.toString() + "/comment_restaurants";

        Map<String, Object> params = new HashMap<>();
        params.put("restaurantId", restoId);
        params.put("comment", comment);
        params.put("mark", mark);

        HttpRequest.post(url, params, context, listener);
    }

    public void updateRestoComment(final Integer userId, final Integer commentId,
                                   final String comment, final Integer mark,
                                   final Context context, final APIManager.APIListener listener)
    {
        String url = userRootURL + "/foodies/" + userId.toString() + "/comment_restaurants/" + commentId.toString();

        Map<String, Object> params = new HashMap<>();
        params.put("comment", comment);
        params.put("mark", mark);

        HttpRequest.put(url, params, context, listener);
    }

    public void deleteRestoComment(final Integer userId, final Integer commentId,
                                   final Context context, final APIManager.APIListener listener)
    {
        String url = userRootURL + "/foodies/" + userId.toString() + "/comment_restaurants/" + commentId.toString();

        HttpRequest.delete(url, context, listener);
    }

    /*
        Menu comments
     */

    /*
        Dishes comments
     */


    /*
        Resto
     */

    /*
        Menu
     */
    

    /*
        Dishes
     */



}
