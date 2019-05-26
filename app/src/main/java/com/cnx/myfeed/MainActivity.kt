package com.cnx.myfeed

import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.cnx.myfeed.extensions.replaceFragment
import com.cnx.myfeed.main.BookingFragment
import com.cnx.myfeed.main.HelpDeskFragment
import com.cnx.myfeed.main.MessagesFragment
import com.cnx.myfeed.main.StoreFragment
import com.cnx.myfeed.social.SocialFragment
import kotlinx.android.synthetic.main.layout_app_bar.*
import kotlinx.android.synthetic.main.layout_bottom_nav_bar.*
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

class MainActivity : AppCompatActivity() {

    private val fragments by lazy { listOf(SocialFragment(),MessagesFragment(), BookingFragment(), StoreFragment(), HelpDeskFragment()) }

    private var bottomBarImageViews: Array<ImageView> = emptyArray()

    private var selectedResources  = listOf<Int>(R.drawable.ic_social,R.drawable.ic_message,R.drawable.ic_message,R.drawable.ic_message,R.drawable.ic_message)
    private var unSelectedResources  = listOf<Int>(R.drawable.ic_social_unselected,R.drawable.ic_message_unselected,R.drawable.ic_message_unselected,R.drawable.ic_message_unselected,R.drawable.ic_message_unselected)
    private var selectedFragment = Array(5) { false }
    private var currentFragmentNo = -1
    private var lastSelectedFragment = -1
    private var scaleAnim: Animation? = null
    private var shrinkAnim : Animation? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        scaleAnim = AnimationUtils.loadAnimation(this, R.anim.scale_anim_date)
        shrinkAnim = AnimationUtils.loadAnimation(this,R.anim.shrink_anim)
        scaleAnim!!.duration = 500
        shrinkAnim!!.duration = 0
        initArrays()
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationIcon(R.drawable.ic_menu_black_24dp)

        initTabItemListeners()
        setCurrentFragmentNumber(0)
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(base))
    }

    private fun initArrays() {

        bottomBarImageViews = arrayOf(ivDashboard, ivLesson, ivSchool,ivSchedule,ivAnalysis)

    }

    private fun initTabItemListeners() {


        llDashboard.setOnClickListener { setCurrentFragmentNumber(0) }

        llLesson.setOnClickListener {
            setCurrentFragmentNumber(1)
        }
        llSchool.setOnClickListener {
            setCurrentFragmentNumber(2)
        }

        llSchedule.setOnClickListener {
            setCurrentFragmentNumber(3)
        }

        llAnalysis.setOnClickListener {
            setCurrentFragmentNumber(4)
        }

    }

    private fun setCurrentFragmentNumber(selectedFragmentNo: Int) {

        if (currentFragmentNo == selectedFragmentNo)
            return

        currentFragmentNo = selectedFragmentNo


        for (i in 0..4) {

            selectedFragment[i] = i == selectedFragmentNo
        }

        setSelectedForCurrentFragment(currentFragmentNo)
    }

    private fun setSelectedForCurrentFragment(fragmentNo: Int) {


        bottomBarImageViews[fragmentNo].startAnimation(scaleAnim)
        resetScale()

        for (i in 0..4) {

            bottomBarImageViews[i].setImageResource(if (selectedFragment[i]) selectedResources[i] else unSelectedResources[i])
        }

        lastSelectedFragment = fragmentNo
        replaceFragment(fragments[fragmentNo])
    }

    private fun resetScale() {

        if(lastSelectedFragment >= 0) {
            bottomBarImageViews[lastSelectedFragment].startAnimation(shrinkAnim)
        }
    }

    private fun replaceFragment(fragment: Fragment) {

        replaceFragment(fragment, R.id.flContainer)
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {

            R.id.search -> {
                //startActivity(Intent(this, FavoriteListActivity::class.java))
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
        return true
    }



}
