package com.tutorials.foregroundservice

import android.app.Application
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.core.app.NotificationChannelCompat

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel("channelId", "channelName", NotificationManager.IMPORTANCE_HIGH)
            channel.apply {
                enableLights(true)
                enableVibration(true)
                setShowBadge(true)
                description = "channelId"
            }
            val nm =
                applicationContext.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            nm.createNotificationChannel(channel)
        }
    }
}