package com.cnx.myfeed.social

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.cnx.myfeed.R
import kotlinx.android.synthetic.main.fragment_social.*


class SocialFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       val view = inflater.inflate(R.layout.fragment_social,container,false)

       Log.d("create","createView called")

        return  view

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("create","activity created called")


        setupViewPager(vpFeed)
        tabLayout.setupWithViewPager(vpFeed)

    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("create","view  created called")




    }

    private fun setupViewPager(viewPager: ViewPager) {

        val titles = ArrayList<String>()
        titles.add("STREAM")
        titles.add("EVENTS")
        titles.add("MY CENTER")
        val adapter = ViewPagerAdapter(activity?.supportFragmentManager!!,3,titles)
        viewPager.adapter = adapter

        viewPager.currentItem = 0
    }

}