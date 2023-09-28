package com.emilabdurahmanli.brodcastreciever

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class CustomBroadcastReceiver : BroadcastReceiver()  {
    override fun onReceive(p0: Context?, p1: Intent?) {
        Log.d("Custom", "Received action from ${p1.toString()}")
    }
}