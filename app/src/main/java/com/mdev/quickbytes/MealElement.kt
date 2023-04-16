package com.mdev.quickbytes

typealias Meals = List<MealElement>

data class MealElement(
    val id: String,
    val categories: List<String>,
    val title: String,
    val affordability: Affordability,
    val complexity: Complexity,
    val imageURL: String,
    val duration: Long,
    val ingredients: List<String>,
    val steps: List<String>,
    val isGlutenFree: Boolean,
    val isVegan: Boolean,
    val isVegetarian: Boolean,
    val isLactoseFree: Boolean
)

enum class Affordability {
    Affordable,
    Luxurious,
    Pricey
}

enum class Complexity {
    Challenging,
    Hard,
    Simple
}
