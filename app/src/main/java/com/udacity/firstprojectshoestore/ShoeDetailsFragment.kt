package com.udacity.firstprojectshoestore

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.udacity.firstprojectshoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.firstprojectshoestore.databinding.FragmentShoeListBinding


class ShoeDetailsFragment : Fragment() {

    private lateinit var viewModel: ShoeViewModel
    private lateinit var binding: FragmentShoeDetailsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         binding= DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_details, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)
        binding.viewModel = viewModel

        binding.AddButton.setOnClickListener(){ view : View ->

            val shoeAdded = Shoe(
                viewModel.shoe.shoeName,
                viewModel.shoe.shoeSize
            ,viewModel.shoe.shoeCompany,
            viewModel.shoe.shoeDescription)

            viewModel.addShoe(shoeAdded)
            binding.ShoeNameEditText.text.clear()
            binding.ShoeSizeEditText.text.clear()
            binding.ShoeCompanyEditText.text.clear()
            binding.ShoeDescrEditText.text.clear()

            Navigation.findNavController(view).navigate(R.id.action_shoeDetailsFragment_to_shoeListFragment)

        }
    return binding.root
    }

    override fun onDestroyView() {

        super.onDestroyView()
    }
}