package com.sambudisp.made.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sambudisp.made.R
import kotlinx.android.synthetic.main.fragment_home.*

class MainFragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragment)

        val fragmentManager = supportFragmentManager
        val homeFragment = HomeFragment()
        val fragment = fragmentManager. findFragmentByTag(HomeFragment::class.java.simpleName)

        if (fragment !is HomeFragment){
            Log.d("MyFlexibleFragment", "Fragment Name :" + HomeFragment::class.java.simpleName)
            fragmentManager
                    .beginTransaction()
                    .add(R.id.frame_container, homeFragment, HomeFragment::class.java.simpleName)
                    .commit()
        }
    }
}
