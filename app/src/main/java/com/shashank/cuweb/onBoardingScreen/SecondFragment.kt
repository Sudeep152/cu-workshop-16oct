package com.shashank.cuweb.onBoardingScreen

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.shashank.cuweb.R
import kotlinx.android.synthetic.main.fragment_second.view.*


class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_second, container, false)

        view.fiBtn.setOnClickListener {
            runBoard()
            findNavController().navigate(R.id.action_viewPagerFragment_to_registerFragment)
        }

        return  view;
    }

    @SuppressLint("CommitPrefEdits")
    private fun runBoard(){
        val sharedpref =requireActivity().getSharedPreferences("check",Context.MODE_PRIVATE)
        val editor = sharedpref.edit()
        editor.putBoolean("finish",true)
        editor.apply()



    }

}