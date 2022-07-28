/*

Copy right here
 */
package com.vj.baseproject.util.extension

import android.content.Context

import android.view.LayoutInflater
import androidx.core.content.ContextCompat
import androidx.databinding.ViewDataBinding


fun ViewDataBinding.context(): Context = this.root.context

fun ViewDataBinding.getString(resId: Int): String {
    return context().getString(resId)
}

fun ViewDataBinding.getString(resId: Int, formatArgs: Any): String {
    return context().getString(resId, formatArgs)
}

fun ViewDataBinding.getColor(resId: Int): Int {
    return ContextCompat.getColor(context(), resId)
}

fun ViewDataBinding.getInflater(): LayoutInflater {
    return LayoutInflater.from(context())
}
