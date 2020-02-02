package com.sambudisp.made.navigationTaskAndBackstack

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.TaskStackBuilder
import androidx.core.content.ContextCompat
import com.sambudisp.made.R
import kotlinx.android.synthetic.main.activity_navigation_task_backstack.*

class NavigationTaskBackstackActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_task_backstack)

        btn_open_detail.setOnClickListener(this)

        showNotification(
            this@NavigationTaskBackstackActivity,
            getString(R.string.notification_title),
            getString(R.string.notification_message),
            110
        )

    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_open_detail) {
            val detailIntent =
                Intent(this@NavigationTaskBackstackActivity, DetailNTBackstackActivity::class.java)
            detailIntent.putExtra(
                DetailNTBackstackActivity.EXTRA_TITLE,
                getString(R.string.detail_title)
            )
            detailIntent.putExtra(
                DetailNTBackstackActivity.EXTRA_MESSAGE,
                getString(R.string.detail_message)
            )
            startActivity(detailIntent)
        }
    }

    private fun showNotification(context: Context, title: String, message: String, notifId: Int) {
        val CHANNEL_ID = "Channel_1"
        val CHANNEL_NAME = "Navigation channel"
        val notifDetailIntent = Intent(this, DetailNTBackstackActivity::class.java)
        notifDetailIntent.putExtra(DetailNTBackstackActivity.EXTRA_TITLE, title)
        notifDetailIntent.putExtra(DetailNTBackstackActivity.EXTRA_MESSAGE, message)

        val pendingIntent = TaskStackBuilder.create(this)
            .addParentStack(DetailNTBackstackActivity::class.java)
            .addNextIntent(notifDetailIntent)
            .getPendingIntent(110, PendingIntent.FLAG_UPDATE_CURRENT)

        val notificationManagerCompat =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setContentTitle(title)
            .setSmallIcon(R.drawable.ic_refresh_black_24dp)
            .setContentText(message)
            .setColor(ContextCompat.getColor(context, android.R.color.black))
            .setVibrate(longArrayOf(1000, 1000, 1000, 1000, 1000))
            .setSound(alarmSound)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT
            )
            channel.enableVibration(true)
            channel.vibrationPattern = longArrayOf(1000, 1000, 1000, 1000, 1000)
            builder.setChannelId(CHANNEL_ID)
            notificationManagerCompat.createNotificationChannel(channel)
        }
        val notification = builder.build()
        notificationManagerCompat.notify(notifId, notification)
    }
}
