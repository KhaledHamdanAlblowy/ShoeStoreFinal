package com.udacity.firstprojectshoestore

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.firstprojectshoestore.databinding.FragmentShoeListBinding
import com.udacity.firstprojectshoestore.databinding.ShoeItemCardLayoutBinding


class ShoeListFragment : Fragment() {
    private lateinit var viewModel: ShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentShoeListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list, container, false
        )
        setHasOptionsMenu(true)
        viewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)
        binding.lifecycleOwner = this

        viewModel.listOfShoes.observe(viewLifecycleOwner, Observer {
            shoeList -> for (shoe in shoeList){
            val itemBinding = ShoeItemCardLayoutBinding.inflate(layoutInflater)
            itemBinding.shoe = shoe
            binding.LinearLayoutList.addView(itemBinding.root)
        }
        })

        binding.floatingActionButton.setOnClickListener(){ view : View ->
            Navigation.findNavController(view).navigate(R.id.action_shoeListFragment_to_shoeDetailsFragment)

        }

        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.loginFragment2 -> {
                LoginFragment()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}