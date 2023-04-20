package com.mdev.quickbytes

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.FrameLayout
import android.widget.TextView

class CategoryAdapter(context: Context, data: Categories) :
    ArrayAdapter<CategoryElement>(context, R.layout.grid_layout, data) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val categoryElement = getItem(position) as CategoryElement
        var view = convertView
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.grid_layout, parent, false)
        }
        val frameLayout = view!!.findViewById<FrameLayout>(R.id.categoryBackground)
        frameLayout.setBackgroundColor(Color.parseColor(colors[position]))
        val categoryText = view.findViewById<TextView>(R.id.categoryTitle)
        categoryText.text = categoryElement.title
        return view
    }

    companion object {
        private val colors: List<String> = listOf(
            "#1E1E1E",
            "#2E2E2E",
            "#3A3A3A",
            "#464646",
            "#555555",
            "#626262",
            "#707070",
            "#7C7C7C",
            "#8A8A8A",
            "#979797"
        )
    }
}