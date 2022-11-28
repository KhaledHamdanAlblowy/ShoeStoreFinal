package com.udacity.firstprojectshoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.firstprojectshoestore.databinding.FragmentLogingBinding


class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentLogingBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_loging, container, false
        )

        binding.loginButton.setOnClickListener { view: View ->
            Navigation.findNavController(view)
                .navigate(R.id.action_loginFragment2_to_welcomeFragment2)
        }
        binding.signInButton.setOnClickListener { view: View ->
            Navigation.findNavController(view)
                .navigate(R.id.action_loginFragment2_to_welcomeFragment2)
        }
        return binding.root
    }


}