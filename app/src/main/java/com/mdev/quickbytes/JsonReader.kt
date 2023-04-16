package com.mdev.quickbytes

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class JsonReader {
    private val gson = Gson()
    private fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

    fun getCategoriesFromJson(context: Context): Categories {
        val categoryJsonFile = getJsonDataFromAsset(context, categoryJson)
        val categoryListType = object : TypeToken<Categories>() {}.type
        return gson.fromJson(categoryJsonFile, categoryListType)
    }

    fun getMealsFromJson(context: Context): Meals {
        val mealJsonFile = getJsonDataFromAsset(context, mealJson)
        val mealListType = object : TypeToken<Meals>() {}.type
        return gson.fromJson(mealJsonFile, mealListType)
    }

    companion object {
        const val categoryJson = "category.json"
        const val mealJson = "meal.json"
    }
}