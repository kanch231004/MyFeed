package com.cnx.myfeed.social

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ViewPagerAdapter (fragmentManager: FragmentManager, val tabCount : Int, titles : ArrayList<String>)
    : FragmentStatePagerAdapter( fragmentManager) {

    var titles = titles

    override fun getItem(position: Int): Fragment {

        when(position) {

            0 -> return StreamFragment()
            1 -> return EventsFragment()
            2 -> return MyCenterFragment()

        }
        return StreamFragment()

    }

    override fun getCount(): Int = tabCount

    override fun getPageTitle(position: Int): CharSequence = titles[position]
}