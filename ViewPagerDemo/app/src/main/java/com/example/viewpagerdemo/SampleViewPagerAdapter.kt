package com.example.viewpagerdemo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class SampleViewPagerAdapter(fragmentManager:FragmentManager) :FragmentPagerAdapter(fragmentManager)
{
    override fun getItem(position: Int): Fragment {
        return when(position)
        {
            1-> Fragment2.newInstance()
            2-> Fragment3.newInstance()
            else ->Fragment1.newInstance()
        }

    }

    override fun getCount(): Int {
        return 3
    }

}