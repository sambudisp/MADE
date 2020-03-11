package com.sambudisp.made.pushNotifCustom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sambudisp.made.R
import kotlinx.android.synthetic.main.activity_push_notif_custom.*

class PushNotifCustomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_push_notif_custom)

        button_show_notification.setOnClickListener {
            startService(Intent(this, NotificationService::class.java))
        }
    }
}
