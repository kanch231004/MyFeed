package com.cnx.myfeed.social

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.cnx.myfeed.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_social.*


class SocialFragment : Fragment() {

    private var seletectedTabPos = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       val view = inflater.inflate(R.layout.fragment_social,container,false)

       Log.d("create Social","createView called")

        val viewPager = view.findViewById(R.id.vpFeed) as ViewPager

        setupViewPager(viewPager)

        return  view

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState?.putInt("tabPosition", seletectedTabPos)


    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

        seletectedTabPos = savedInstanceState?.getInt("tabPosition") ?: 0

        Log.d("Social","selected tab pos $seletectedTabPos")
        tabLayout.getTabAt(savedInstanceState?.getInt("tabPosition") ?: 0)?.select()
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("create","activity created called")
       // setupViewPager(vpFeed)
       // tabLayout.setupWithViewPager(vpFeed)

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                seletectedTabPos = tab?.position ?: 0
            }


        })


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
        val adapter = ViewPagerAdapter(childFragmentManager,3,titles)
        viewPager.adapter = adapter
        viewPager.currentItem = 0
    }


    override fun onResume() {
        super.onResume()

        Log.d("create","view  resume called")

        vpFeed.currentItem = seletectedTabPos
        tabLayout.setupWithViewPager(vpFeed)
    }

}