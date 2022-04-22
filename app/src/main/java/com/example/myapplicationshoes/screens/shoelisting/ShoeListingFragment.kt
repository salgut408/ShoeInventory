package com.example.myapplicationshoes.screens.shoelisting

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.myapplicationshoes.R
import com.example.myapplicationshoes.databinding.FragmentShoeListingBinding
import com.example.myapplicationshoes.models.Shoe


class ShoeListingFragment : Fragment() {

    private  val shoeListingsViewModel: ShoeListingViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeListingBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_listing, container, false)
        //letting frag know abt view model

        binding.lifecycleOwner = this

        shoeListingsViewModel.getShoeLiveData().observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                createShoes(it)
            }
        }

//        for shoe details going to
        binding.fab.setOnClickListener{
            Navigation.findNavController(binding.root).navigate(ShoeListingFragmentDirections.actionShoeListingFragmentToShoeDetailFragment())

        }
        setHasOptionsMenu(true)
        return binding.root
    }

    private fun createShoes(shoes: List<Shoe>) {
        context?.let {context ->
            val shoeContainer = binding.list
            shoes.forEach{shoe ->
                val shoeLayout = ShoeLayout(context)
                shoeLayout.loadShoe(shoe)
                shoeContainer.addView(shoeLayout)
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }


}






















