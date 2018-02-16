package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {

        JSONObject jsonObj = new JSONObject(json);
        JSONObject nameObj = jsonObj.getJSONObject("name");
        String mainName = nameObj.getString("mainName");

        JSONArray alsoKnownAsArray = nameObj.getJSONArray("alsoKnownAs");
        List<String> listOfStrings = new ArrayList<>();
        for (int i = 0; i < alsoKnownAsArray.length(); i++) {
            listOfStrings.add(alsoKnownAsArray.getString(i));
        }
        String placeOfOrigin = jsonObj.getString("placeOfOrigin");
        String description = jsonObj.getString("description");
        String image = jsonObj.getString("image");

        JSONArray ingredientsArray = jsonObj.getJSONArray("ingredients");
        List<String> ingredientsOfStrings = new ArrayList<>();
        for (int i = 0; i < ingredientsArray.length(); i++) {
            ingredientsOfStrings.add(ingredientsArray.getString(i));
        }

        final Sandwich sandwich = new Sandwich(mainName, listOfStrings, placeOfOrigin, description, image, ingredientsOfStrings);
        return sandwich;
    }
}
