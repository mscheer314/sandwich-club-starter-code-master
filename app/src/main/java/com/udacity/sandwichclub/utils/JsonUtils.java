package com.udacity.sandwichclub.utils;

import android.support.annotation.NonNull;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich result = new Sandwich();
        String mainName, placeOfOrigin, description, image;
        JSONArray aka, ingredients;

        try {
            JSONObject sandwichJson = new JSONObject(json);
            JSONObject nameObject = sandwichJson.getJSONObject("name");

            mainName = nameObject.getString("mainName");

            aka = nameObject.getJSONArray("alsoKnownAs");
            ArrayList<String> akaList = new ArrayList<String>();

            if (aka != null) {
                for (int i = 0; i < aka.length(); i++) {
                    akaList.add(aka.get(i).toString());
                }
            }

            placeOfOrigin = sandwichJson.getString("placeOfOrigin");
            description = sandwichJson.getString("description");
            image = sandwichJson.getString("image");

            ingredients = sandwichJson.getJSONArray("ingredients");
            ArrayList<String> ingredientsList = new ArrayList<>();

            if (ingredients != null) {
                for (int i = 0; i < ingredients.length(); i++) {
                    ingredientsList.add(ingredients.get(i).toString());
                }
            }

            result.setMainName(mainName);
            result.setAlsoKnownAs(akaList);
            result.setDescription(description);
            result.setImage(image);
            result.setPlaceOfOrigin(placeOfOrigin);
            result.setIngredients(ingredientsList);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return result;
    }
}
