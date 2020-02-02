package com.sambudisp.made.navigationTaskAndBackstack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sambudisp.made.R
import kotlinx.android.synthetic.main.activity_detail_ntbackstack.*

class DetailNTBackstackActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_MESSAGE = "extra_message"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_ntbackstack)

        val title = intent.getStringExtra(EXTRA_TITLE)
        val message = intent.getStringExtra(EXTRA_MESSAGE)
        tv_title.text = title
        tv_message.text = message
    }
}
