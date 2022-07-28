/*

Copy right here
 */
package com.vj.baseproject.util.extension

import android.content.Context
import android.widget.Toast

fun String.showAsToast(context: Context) {
    showAsToast(context, Toast.LENGTH_SHORT)
}

fun String.showAsToast(context: Context, duration: Int) {
    Toast.makeText(context, this, duration).show()
}

fun String?.optDouble(): Double {
    return if (isNullOrEmpty())
        0.0
    else toDouble()
}

fun String?.optString(): String {
    return if (isNullOrEmpty())
        "N/A"
    else
        this

}
