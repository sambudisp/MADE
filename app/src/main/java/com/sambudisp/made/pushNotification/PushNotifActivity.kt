package com.sambudisp.made.pushNotification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.sambudisp.made.R
import com.sambudisp.made.customView.CustomViewActivity

class PushNotifActivity : AppCompatActivity() {

    companion object {
        val NOTIFICATION_ID = 1
        var CHANNEL_ID = "channel_01"
        var CHANNEL_NAME = "dicoding channel"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_push_notif)

    }

    fun sendNotif(view: View) {
        val intent = Intent(this, CustomViewActivity::class.java)
        //val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://dicoding.com")) //atur intentmu sendiri mau diarahkan ke mana
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        val mNotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val mBuilder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_audiotrack_black_24dp)
            .setLargeIcon(
                BitmapFactory.decodeResource(
                    resources,
                    R.drawable.ic_audiotrack_black_24dp
                )
            )
            .setContentTitle("Judul")
            .setContentText("Konten")
            .setSubText("Sub Text")
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)

        val notification = mBuilder.build()
        mNotificationManager.notify(NOTIFICATION_ID, notification)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT
            )
            channel.description = CHANNEL_NAME
            mBuilder.setChannelId(CHANNEL_ID)
            mNotificationManager.createNotificationChannel(channel)
        }
    }
}
