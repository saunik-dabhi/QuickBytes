package com.mdev.quickbytes

// meal model
typealias Meals = List<MealElement>

data class MealElement(
    val id: String,
    val categories: List<String>,
    val title: String,
    val affordability: String,
    val complexity: String,
    val imageURL: String,
    val duration: Long,
    val ingredients: List<String>,
    val steps: List<String>,
    val isGlutenFree: Boolean,
    val isVegan: Boolean,
    val isVegetarian: Boolean,
    val isLactoseFree: Boolean
)
