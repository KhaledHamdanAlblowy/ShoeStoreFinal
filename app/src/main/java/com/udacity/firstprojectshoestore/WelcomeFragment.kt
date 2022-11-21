package com.udacity.firstprojectshoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.firstprojectshoestore.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {


    //all good untill this point

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentWelcomeBinding = DataBindingUtil.inflate(
             inflater, R.layout.fragment_welcome, container, false
        )
        binding.instructionsButton.setOnClickListener{
            view : View ->
            Navigation.findNavController(view).navigate(R.id.action_welcomeFragment2_to_instructionsFragment)
        }
        return binding.root

    }




}