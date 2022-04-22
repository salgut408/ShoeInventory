package com.example.myapplicationshoes.screens.login

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.myapplicationshoes.R
import com.example.myapplicationshoes.databinding.FragmentLogInBinding


class LogInFragment : Fragment() {

    private lateinit var binding: FragmentLogInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
// Inflate the layout for this fragment
// these two do the same thing ... ?
//      -> 1 <-
//      binding = FragmentLogInBinding.inflate(layoutInflater)
//      -> 2 <-
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_log_in,
            container, false
        )

// these 3 do the same ? yes.... but used depending on conditions
//    -> 1 <-
        binding.btnLogin.setOnClickListener(
            Navigation.createNavigateOnClickListener(LogInFragmentDirections.navigateToWelcome())
        )
//    ->  2 <-
//        binding.btnLogin.setOnClickListener { view: View ->
//            view.findNavController().navigate(R.id.navigate_to_welcome)
//        }
//     -> 3 <-
//        binding.btnLogin.setOnClickListener {
//            Navigation.findNavController(binding.root).navigate(R.id.navigate_to_welcome)
//        }

        binding.btnNewUser.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(LogInFragmentDirections.navigateToWelcome())

        }
        // adding the menu
        setHasOptionsMenu(true)
        return binding.root
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

















