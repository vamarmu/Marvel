package com.vamarmu.marvel.data.remote

import android.content.Context
import com.vamarmu.marvel.R
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp


class RemoteConfig {

    companion object {

       const val BASE_URL = "https://gateway.marvel.com:443/v1/public/"


        val ts = Timestamp(System.currentTimeMillis()).time.toString()

        fun getApikey(context: Context) = context.resources.getString(R.string.api_key)

        fun getHash(context: Context): String {
            val apikey: String = getApikey(context)
            val key: String = context.resources.getString(R.string.private_key)
            val input = "$ts$key$apikey"
            val md5 = MessageDigest.getInstance("MD5")
            return BigInteger (1,md5.digest(input.toByteArray())).toString(16).padStart(32, 0.toChar())
        }
    }
}