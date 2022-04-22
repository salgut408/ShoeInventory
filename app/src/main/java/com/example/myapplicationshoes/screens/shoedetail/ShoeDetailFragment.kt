package com.example.myapplicationshoes.screens.shoedetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.myapplicationshoes.R
import com.example.myapplicationshoes.databinding.FragmentShoeDetailBinding
import com.example.myapplicationshoes.screens.shoelisting.ShoeListingViewModel


class ShoeDetailFragment : Fragment() {

    private val shoesViewModel: ShoeListingViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      val  binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail,
            container, false)

        binding.lifecycleOwner = this
//       binding.shoeListingsViewModel = shoesViewModel
//        binding.shoe = Shoe()

        binding.cancelButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListingFragment())
            )

        return binding.root
    }
}























