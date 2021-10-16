package com.shashank.cuweb.Splashscreen

import android.content.Context
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.shashank.cuweb.R

class SplashFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Handler().postDelayed({
            if(!runBoard()){
                findNavController().navigate(R.id.action_splashFragment_to_viewPagerFragment)
            }else{
                findNavController().navigate(R.id.action_splashFragment_to_registerFragment)
            }

        },2000)

        val view =inflater.inflate(R.layout.fragment_splash, container, false)




        return view;
    }

    private fun runBoard():Boolean{

        val sharedpref =requireActivity().getSharedPreferences("check", Context.MODE_PRIVATE)
        return sharedpref.getBoolean("finish",false)
    }

}