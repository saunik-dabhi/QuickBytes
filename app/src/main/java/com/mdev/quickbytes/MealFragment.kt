package com.mdev.quickbytes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.mdev.quickbytes.databinding.FragmentMealBinding

class MealFragment : Fragment() {
    private var _binding: FragmentMealBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMealBinding.inflate(inflater, container, false)
        val view = binding.root
        val jsonReader = JsonReader()
        val categoryId = MealFragmentArgs.fromBundle(requireArguments()).categoryId
        val meals = jsonReader.getMealsFromJson(requireContext())
        val selectedMeals: ArrayList<MealElement> = ArrayList()
        for (meal in meals) {
            for (id in meal.categories) {
                if (id == categoryId) {
                    selectedMeals.add(meal)
                }
            }
        }
        val listView = binding.mealsList
        listView.adapter = MealAdapter(requireContext(), selectedMeals.toList())
        return view
    }
}