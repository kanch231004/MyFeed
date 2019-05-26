package com.cnx.myfeed

import android.app.Application
import uk.co.chrisjenx.calligraphy.CalligraphyConfig

class MyFeed : Application() {

    override fun onCreate() {
        super.onCreate()

        CalligraphyConfig.initDefault(CalligraphyConfig.Builder()
            .setDefaultFontPath("fonts/avenir-next-regular.ttf")
            .setFontAttrId(R.attr.fontPath)
            .build()
        )
    }
}