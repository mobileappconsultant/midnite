package com.android.midnite.data.prefs

import android.annotation.SuppressLint
import android.content.SharedPreferences
import javax.inject.Inject

class SharedPrefs @Inject constructor(private val prefs: SharedPreferences) {

    companion object {
        const val LAST_DB_UPDATE_TIME = "lastDbUpdateTime"
    }

    @SuppressLint("CommitPrefEdits")
    fun updateLastDbUpdateTime(timestamp: Long) {
        val editor = prefs.edit()
        editor.putLong(LAST_DB_UPDATE_TIME, timestamp)
        editor.apply()
    }

    fun getLastDbUpdateTme(): Long {
        return if (prefs.contains(LAST_DB_UPDATE_TIME)) {
            prefs.getLong(LAST_DB_UPDATE_TIME, 0L)
        } else 0L
    }
}
