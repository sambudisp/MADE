package com.sambudisp.made.firebaseCloudMessaging

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.sambudisp.made.R

class FCMService : FirebaseMessagingService() {

    companion object {
        private val TAG = FCMService::class.java.simpleName
    }

    override fun onNewToken(p0: String?) {
        super.onNewToken(p0)
        Log.d(TAG, "Refreshed token: $p0")
    }

    override fun onMessageReceived(p0: RemoteMessage?) {
        super.onMessageReceived(p0)
        p0?.notification?.let {
            sendNotification(it.body)
        }
    }

    private fun sendNotification(messageBody: String?) {
        val channelId = getString(R.string.default_notification_channel_id)
        val channelName = "berita"
        val intent = Intent(this, FirebaseCloudMessagingMainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(
            this, 0, intent,
            PendingIntent.FLAG_ONE_SHOT
        )
        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentText(messageBody)
            .setAutoCancel(true)
            .setSound(defaultSoundUri)
            .setContentIntent(pendingIntent)
        val mNotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT)
            notificationBuilder.setChannelId(channelId)
            mNotificationManager.createNotificationChannel(channel)
        }
        val notification = notificationBuilder.build()
        mNotificationManager.notify(0, notification)
    }

}