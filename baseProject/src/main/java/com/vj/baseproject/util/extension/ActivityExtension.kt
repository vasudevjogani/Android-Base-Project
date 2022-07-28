/*

Copy right here
 */
package com.vj.baseproject.util.extension

import android.app.Activity
import android.app.Dialog
import android.os.Build
import android.view.View
import com.vj.baseproject.R


fun Activity.makeFullScreen() {
    window.decorView.systemUiVisibility =
        View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
}

fun Activity.makeRegularScreen() {
    window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
}

fun Activity.changeStatusBarColor(color: Int, isLight: Boolean) {
    window.statusBarColor = color
    changeStatusBarIconLight(isLight)
}

fun Activity.changeStatusBarIconLight(isLight: Boolean) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        var flags: Int = window.decorView.systemUiVisibility
        flags = if (isLight) {
            flags and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
        } else {
            flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
        window.decorView.systemUiVisibility = flags
    }
}

fun Activity.createDialogWithoutBounds(view: View): Dialog {
    val dialog = Dialog(this, R.style.DialogTheme)
    dialog.setCancelable(false)
    /*dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)*/
    dialog.setContentView(view)
//        setDialogMatchWindow(dialog)
    return dialog
}
