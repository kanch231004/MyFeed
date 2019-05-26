package com.cnx.myfeed.social

import android.os.Parcelable
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter

class ViewPagerAdapter (fragmentManager: FragmentManager, val tabCount : Int, titles : ArrayList<String>)
    : FragmentStatePagerAdapter( fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {



        var titles = titles
    override fun getItem(position: Int): Fragment {

        Log.d("ViewPager","called with position $position")

        when(position) {


            0 -> return StreamFragment()
            1 -> return EventsFragment()
            2 -> return MyCenterFragment()


        }
        return StreamFragment()

    }

    override fun getCount(): Int = tabCount

    override fun getPageTitle(position: Int): CharSequence = titles[position]

    override fun getItemPosition(`object`: Any): Int {
        return PagerAdapter.POSITION_NONE

    }

    override fun saveState(): Parcelable? {
        return null
    }


}