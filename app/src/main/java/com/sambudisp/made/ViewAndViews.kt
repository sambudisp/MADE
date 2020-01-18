package com.sambudisp.made

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ViewAndViews : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_and_views)

        supportActionBar?.title = "Google Pixel"

    }
}
