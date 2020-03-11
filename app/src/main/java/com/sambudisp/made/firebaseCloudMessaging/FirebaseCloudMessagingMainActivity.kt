package com.sambudisp.made.firebaseCloudMessaging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.messaging.FirebaseMessaging
import com.sambudisp.made.R
import kotlinx.android.synthetic.main.activity_firebase_cloud_messaging_main.*

class FirebaseCloudMessagingMainActivity : AppCompatActivity() {

    companion object {
        private val TAG = FirebaseCloudMessagingMainActivity::class.java.simpleName
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase_cloud_messaging_main)

        btn_subscribe.setOnClickListener {
            FirebaseMessaging.getInstance().subscribeToTopic("berita")
            val msg = "Subscribe ke 'berita'"
            Log.d(TAG, msg)
            Toast.makeText(this@FirebaseCloudMessagingMainActivity, msg, Toast.LENGTH_SHORT).show()
        }

        btn_token.setOnClickListener {
            FirebaseInstanceId.getInstance().instanceId.addOnSuccessListener { instanceIdResult ->
                val deviceToken = instanceIdResult.token
                val msg = getString(R.string.msg_token_fmt, deviceToken)
                Toast.makeText(this@FirebaseCloudMessagingMainActivity, msg, Toast.LENGTH_SHORT).show()
                Log.d(TAG, "Refreshed token: $deviceToken")
            }
        }
    }
}
