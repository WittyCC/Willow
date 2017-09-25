package com.example.guest.willow.services;

import com.example.guest.willow.Constants;
import com.example.guest.willow.models.Listing;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OnboardService {

    public static void findListings(String postalcode, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder().build();

        // Create new url using API_BASE_URL
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.API_BASE_URL).newBuilder();
        String url = urlBuilder.build().toString() + postalcode;

        // Make API Request
        Request request = new Request.Builder().url(url).addHeader("apikey", Constants.API_KEY_HEADER).addHeader("Accept", Constants.ACCEPT_HEADER).build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    // Parse JSON file from API
    public ArrayList<Listing> processResults(Response response) {
        ArrayList<Listing> listings = new ArrayList<>();
        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject onboardJSON = new JSONObject(jsonData);
                JSONArray dataJSON = onboardJSON.getJSONArray("property");

                for (int i = 0; i < dataJSON.length(); i++) {
                    JSONObject listingsJSON = dataJSON.getJSONObject(i);
                    String line1 = listingsJSON.getJSONObject("address").getString("line1");
                    String line2 = listingsJSON.getJSONObject("address").getString("line2");
                    String locality = listingsJSON.getJSONObject("address").getString("locality");
                    double postal1 = listingsJSON.getJSONObject("address").getDouble("postal1");
                    double latitude = listingsJSON.getJSONObject("address").getDouble("latitude");
                    double longitude = listingsJSON.getJSONObject("address").getDouble("longitude");

                    Listing listing = new Listing(line1, line2, locality, postal1, latitude, longitude);

                    listings.add(listing);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return listings;
    }
}
