package com.example.sley.flicks.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Sley on 10/16/2017.
 */

public class Config {
    String imageBaseUrl;
    String posterSize;
    //the backdrop size to use when fetching images
    String backdropSize;

    public Config(JSONObject object) throws JSONException{
        JSONObject images = object.getJSONObject("images");
        imageBaseUrl = images.getString("secure_base_url");
        JSONArray postersizeOption = images.getJSONArray("poster_sizes");
        posterSize = postersizeOption.optString(3,"w342");

        JSONArray backdropSizeOption = images.getJSONArray("backdrop_sizes");
        backdropSize = backdropSizeOption.optString(1,"w780");


    }

    public String getImageUrl(String size, String path){
        return String.format("%s%s%s", imageBaseUrl, size, path); //concatenate all three
    }

    public String getImageBaseUrl() {
        return imageBaseUrl;
    }

    public String getPosterSize() {
        return posterSize;
    }

    public String getBackdropSize() {
        return backdropSize;
    }
}
