package com.shashank.cuweb.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class viewpagerAdapter(list:ArrayList<Fragment>,fm:FragmentManager,lifecycle: Lifecycle):FragmentStateAdapter(fm,lifecycle) {

    private  val fmList =list

    override fun getItemCount(): Int {

        return fmList.size

    }

    override fun createFragment(position: Int): Fragment {

        return  fmList[position]
    }
}