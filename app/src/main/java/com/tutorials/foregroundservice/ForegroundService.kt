package com.tutorials.foregroundservice

import android.annotation.SuppressLint
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat

class ForegroundService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        when (intent?.action) {
            Actions.START.toString() -> start()
            Actions.STOP.toString() -> stopSelf()
        }
        return super.onStartCommand(intent, flags, startId)
    }

    enum class Actions {
        START, STOP
    }

    @SuppressLint("ForegroundServiceType")
    private fun start() {

        val notification = NotificationCompat.Builder(this, "channelId")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentText("Foreground Service")
            .setContentTitle("Foreground Title")
            .build()
//        val nm = applicationContext.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
//        nm.notify(11, notification)
        startForeground(11, notification)
    }
}