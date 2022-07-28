/*

Copy right here
 */
package com.vj.baseproject.util.extension

import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Point
import android.graphics.drawable.Drawable
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.vj.baseproject.util.dialog.AppAlertDialog

fun Context.getWindowDimension(): Pair<Int, Int> {
    val wm = this.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val display = wm.defaultDisplay
    val size = Point()
    display.getSize(size)
    return Pair(size.x, size.y)
}


fun Context.isNetworkAvailable(): Boolean {
    var result = false
    val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        cm?.run {
            cm.getNetworkCapabilities(cm.activeNetwork)?.run {
                result = when {
                    hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                    hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                    hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                    else -> false
                }
            }
        }
    } else {
        cm?.run {
            cm.activeNetworkInfo?.run {
                if (type == ConnectivityManager.TYPE_WIFI) {
                    result = true
                } else if (type == ConnectivityManager.TYPE_MOBILE) {
                    result = true
                }
            }
        }
    }
    return result
}

fun Context.getDrawableCompat(resourceId: Int): Drawable? {
    return ContextCompat.getDrawable(this, resourceId)
}

fun Context.getAppVersionName(): String {
    try {
        val pInfo = packageManager.getPackageInfo(packageName, 0);
        pInfo.versionName.toString()
    } catch (e: PackageManager.NameNotFoundException) {
        e.printStackTrace();
    }
    return "N/A"
}

fun Context.getAppVersion(): String {
    try {
        val pInfo = packageManager.getPackageInfo(packageName, 0);
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            pInfo.longVersionCode.toString()
        } else {
            pInfo.versionCode.toString()
        };
    } catch (e: PackageManager.NameNotFoundException) {
        e.printStackTrace();
    }
    return "0"
}


fun AppCompatActivity.showAlert(
    title: String,
    message: String,
    positiveButton: String,
    negativeButton: String,
    positiveCallback: () -> Unit = {}
) {
    AppAlertDialog { dialog, bindingX ->
        bindingX.tvTitle.text = title
        bindingX.tvDescription.text = message
        bindingX.btnSubmit.text = positiveButton
        bindingX.btnCancel.text = negativeButton
        if (negativeButton.isEmpty()) {
            bindingX.btnCancel.setVisible(false)
        }

        bindingX.btnSubmit.setOnClickListener {
            positiveCallback()
            dialog.dismiss()
        }

        bindingX.btnCancel.setOnClickListener {
            dialog.dismiss()
        }
    }.show(supportFragmentManager, "s")
}