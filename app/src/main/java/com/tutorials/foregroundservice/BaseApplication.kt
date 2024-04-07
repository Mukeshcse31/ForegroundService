package com.tutorials.foregroundservice

import android.app.Application
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.Color
import android.os.Build
import androidx.core.app.NotificationChannelCompat

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel("channelId", "channelName", NotificationManager.IMPORTANCE_HIGH)
            //-> same as notification
            //-> user sees in the settings
            channel.apply {
                enableLights(true)
                lightColor = Color.RED
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