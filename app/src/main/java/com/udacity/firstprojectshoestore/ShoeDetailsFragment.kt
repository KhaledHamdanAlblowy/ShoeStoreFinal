package com.udacity.firstprojectshoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.udacity.firstprojectshoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.firstprojectshoestore.databinding.FragmentShoeListBinding


class ShoeDetailsFragment : Fragment() {

    private val viewModel: ViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentShoeDetailsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_details, container, false)

        binding.AddButton.setOnClickListener(){
                view : View ->
            Navigation.findNavController(view).navigate(R.id.action_shoeDetailsFragment_to_shoeListFragment)

        }
    return binding.root
    }


}