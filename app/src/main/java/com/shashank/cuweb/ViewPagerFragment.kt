package com.shashank.cuweb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shashank.cuweb.adapter.viewpagerAdapter
import com.shashank.cuweb.onBoardingScreen.FirstFragment
import com.shashank.cuweb.onBoardingScreen.SecondFragment
import kotlinx.android.synthetic.main.fragment_view_pager.*
import kotlinx.android.synthetic.main.fragment_view_pager.view.*


class ViewPagerFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_view_pager, container, false)

        val frList = arrayListOf<Fragment>(
            FirstFragment(),SecondFragment()
        )
        val adapter = viewpagerAdapter(frList,requireActivity().supportFragmentManager,lifecycle)

         view.viewpager.adapter =adapter


        return  view
    }


}