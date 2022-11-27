package com.udacity.firstprojectshoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.firstprojectshoestore.databinding.FragmentShoeDetailsBinding
import kotlin.time.Duration


class ShoeDetailsFragment : Fragment() {

    private lateinit var viewModel: ShoeViewModel
    private lateinit var binding: FragmentShoeDetailsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         binding= DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_details, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)
        binding.viewModel = viewModel

        binding.AddButton.setOnClickListener(){ view : View ->
        if (binding.ShoeNameEditText.text.isEmpty() ||
            binding.ShoeSizeEditText.text.isEmpty() ||
            binding.ShoeDescrEditText.text.isEmpty() ||
            binding.ShoeCompanyEditText.text.isEmpty() ){

            val toast = Toast.makeText(context, "Please Fill all Fields", Toast.LENGTH_SHORT)
            toast.show()
        }
            else {

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

        }
    return binding.root
    }

}