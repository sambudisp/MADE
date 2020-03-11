package com.sambudisp.made.pushNotifCustom

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.sambudisp.made.R
import com.sambudisp.made.pushNotifCustom.NotificationService.Companion.REPLY_ACTION
import com.sambudisp.made.pushNotification.PushNotifActivity.Companion.CHANNEL_ID
import com.sambudisp.made.pushNotification.PushNotifActivity.Companion.CHANNEL_NAME

class NotificationBroadcastReceiver : BroadcastReceiver() {

    companion object {
        private const val KEY_NOTIFICATION_ID = "key_notification_id"
        private const val KEY_MESSAGE_ID = "key_message_id"

        fun getReplyMessageIntent(context: Context, notificationId: Int, messageId: Int): Intent {
            val intent = Intent(context, NotificationBroadcastReceiver::class.java)
            intent.action = REPLY_ACTION
            intent.putExtra(KEY_NOTIFICATION_ID, notificationId)
            intent.putExtra(KEY_MESSAGE_ID, messageId)
            return intent
        }
    }

    override fun onReceive(context: Context, intent: Intent) {
        if (REPLY_ACTION == intent.action) {
            val message = NotificationService.getReplyMessage(intent)
            val messageId = intent.getIntExtra(KEY_MESSAGE_ID, 0)

            Toast.makeText(context, "Message ID: $messageId\nMessage: $message",
                Toast.LENGTH_SHORT).show()

            val notifyId = intent.getIntExtra(KEY_NOTIFICATION_ID, 1)
            updateNotification(context, notifyId)
        }
    }

    private fun updateNotification(context: Context, notifyId: Int) {

        val mNotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val mBuilder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_audiotrack_black_24dp)
            .setContentTitle("Judul Broadcast")
            .setContentText("Konten Broadcast")

        /*
        Untuk android Oreo ke atas perlu menambahkan notification channel
        Materi ini akan dibahas lebih lanjut di modul extended
         */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            /* Create or update. */
            val channel = NotificationChannel(CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT)

            mBuilder.setChannelId(CHANNEL_ID)

            mNotificationManager.createNotificationChannel(channel)
        }

        val notification = mBuilder.build()

        mNotificationManager.notify(notifyId, notification)
    }
}
