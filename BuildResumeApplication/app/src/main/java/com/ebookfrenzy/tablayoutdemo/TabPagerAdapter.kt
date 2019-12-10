package com.ebookfrenzy.tablayoutdemo

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
class TabPagerAdapter(fm: FragmentManager, private var tabCount: Int) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> InfoFragment()
            1 -> WorkFragment()
            2 -> ContactMeFragment()
            else -> null
        }
    }
    override fun getCount(): Int {
        return tabCount
    }
}