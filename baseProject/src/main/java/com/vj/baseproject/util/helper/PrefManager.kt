/*

Copy right here
 */


import android.app.Activity
import android.content.SharedPreferences
import com.vj.baseproject.BaseApplication


import com.google.gson.Gson

object PrefManager {
    fun Any.toJson(): String {
        val gson = Gson()
        return gson.toJson(this)
    }

    inline fun <reified T> String.toObject(): T {
        val gson = Gson()
        return gson.fromJson(this, T::class.java)
    }

    fun putStringPref(key: String, value: String) {
        getPref().edit().apply {
            putString(key, value)
        }.apply()
    }

    fun getStringPref(key: String): String {
        return getPref().getString(key, "") ?: ""
    }

    fun contains(key: String): Boolean {
        return getPref().contains(key)
    }

    fun getPref(): SharedPreferences {
        return BaseApplication.application.getSharedPreferences("appPref", Activity.MODE_PRIVATE)
    }

    fun clear() {
        getPref().edit().apply {
            clear()
        }.apply()
    }
}
