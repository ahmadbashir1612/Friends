package com.karigor.friends.utility

import android.content.Context
import android.net.NetworkInfo
import android.net.ConnectivityManager

object Utils {
    fun haveInternet(ctx: Context): Boolean {
        val info =
            (ctx.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo
        if (info == null || !info.isConnected) {
            return false
        }
        return if (info.isRoaming) {
            // here is the roaming option you can change it if you want to
            // disable internet while roaming, just return false
            true
        } else true
    }
}