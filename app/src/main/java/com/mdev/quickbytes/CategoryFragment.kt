package com.mdev.quickbytes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.mdev.quickbytes.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment() {
    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        val view = binding.root
        //to read local category json file
        val jsonReader = JsonReader()
        val categories = jsonReader.getCategoriesFromJson(requireContext())
        // set up adapter in gridview
        val gridView = binding.categoryGrid
        gridView.adapter = CategoryAdapter(requireContext(), categories)
        gridView.setOnItemClickListener { _, _, position, _ ->
            // navigate and send category id to meal fragment
            view.findNavController().navigate(CategoryFragmentDirections.actionCategoryFragmentToMealFragment(categories[position].id))
        }
        return view
    }
}