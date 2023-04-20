package com.mdev.quickbytes

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.FrameLayout
import android.widget.TextView

//custom array adapter for Category this connects custom grid layout with gridview
class CategoryAdapter(context: Context, data: Categories) :
    ArrayAdapter<CategoryElement>(context, R.layout.grid_layout, data) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val categoryElement = getItem(position) as CategoryElement
        var view = convertView
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.grid_layout, parent, false)
        }
        //to set bg color of the category grid item
        val frameLayout = view!!.findViewById<FrameLayout>(R.id.categoryBackground)
        frameLayout.setBackgroundColor(Color.parseColor(colors[position]))
        val categoryText = view.findViewById<TextView>(R.id.categoryTitle)
        categoryText.text = categoryElement.title
        return view
    }

    companion object {
        // background color for categories
        private val colors: List<String> = listOf(
            "#FFC107",
            "#FF9800",
            "#F44336",
            "#8BC34A",
            "#00BFFF",
            "#9B51E0",
            "#50E3C2",
            "#4A90E2",
            "#D0021B",
            "#F5A623"
        )
    }
}