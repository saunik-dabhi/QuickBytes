package com.mdev.quickbytes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

// custom adapter to link custom meal list layout with list of meal element
class MealAdapter(context: Context, data: Meals) :
    ArrayAdapter<MealElement>(context, R.layout.meal_list_tile, data) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val meal = getItem(position) as MealElement
        var view = convertView
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.meal_list_tile, parent, false)
        }
        val image = view!!.findViewById<ImageView>(R.id.mealImage)
        val title = view.findViewById<TextView>(R.id.mealTitle)
        title.text = meal.title
        // to load image from network
        Glide.with(view).load(meal.imageURL).into(image)
        return view
    }
}