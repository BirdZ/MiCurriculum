package com.example.adrian.abbasies.serviceWeb;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;

/**
 * Created by Adrian on 21/04/2015.
 */
public class conectServiceWeb {

    public static JSONArray getJSONArrayFromURL(String url, JSONObject json) {
        InputStream is = null;
        String result = "";


        JSONArray JArray = null;

        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(url);
            try {
                StringEntity se = new StringEntity(json.toString());
                httppost.setEntity(se);

            } catch (UnsupportedEncodingException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            httppost.setHeader("Accept", "application/json");
            httppost.setHeader("Content-type", "application/json");
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();

        } catch (ConnectTimeoutException eC) {

        } catch (SocketTimeoutException ste) {


        } catch (Exception e) {
            Log.v("Registro", "e1--> " + e.toString());

        }


        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            result = sb.toString();
            //result= "timeline:"+result;
        } catch (Exception e) {
        }

        try {
            //json = new JSONObject(result);
            JArray = new JSONArray(result);
        } catch (JSONException e) {

        }
        return JArray;
    }

    public static JSONObject getJSONObjectFromURL(String url, JSONObject json) {
        InputStream is = null;
        String result = "";
        JSONObject jsonResult = null;

        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(url);
            try {
                StringEntity se = new StringEntity(json.toString());
                httppost.setEntity(se);

            } catch (UnsupportedEncodingException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            httppost.setHeader("Accept", "application/json");
            httppost.setHeader("Content-type", "application/json");

            HttpResponse response = httpclient.execute(httppost);

            HttpEntity entity = response.getEntity();
            is = entity.getContent();

        } catch (ConnectTimeoutException eC) {

        } catch (SocketTimeoutException ste) {


        } catch (Exception e) {
            Log.v("Registro", "e1--> " + e.toString());

        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            result = sb.toString();
            //result= "timeline:"+result;
        } catch (Exception e) {
        }

        try {
            jsonResult = new JSONObject(result);

        } catch (JSONException e) {


        }
        return jsonResult;
    }
}
