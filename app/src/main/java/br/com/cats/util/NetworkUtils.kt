package br.com.cats.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.os.Build
import android.widget.Toast

class NetworkUtils {
    fun registerNetworkCallback(
        applicationContext: Context,
        callback: ConnectivityManager.NetworkCallback
    ): ConnectivityManager {
        val connectivityManager = applicationContext
                                .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            connectivityManager.registerDefaultNetworkCallback(callback)
        }

        return connectivityManager
    }

    fun isNetworkConnected(applicationContext: Context): Boolean {
        val connectivityManager =
            applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // Para versões Android 23 e superiores
            val network = connectivityManager.activeNetwork
            val networkCapabilities = connectivityManager.getNetworkCapabilities(network)

            return networkCapabilities?.let {
                it.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                        it.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                        it.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
            } ?: false
        } else {
            // Para versões Android anteriores à 23
            val networkInfo = connectivityManager.activeNetworkInfo

            return networkInfo?.isConnectedOrConnecting == true
        }
    }
}