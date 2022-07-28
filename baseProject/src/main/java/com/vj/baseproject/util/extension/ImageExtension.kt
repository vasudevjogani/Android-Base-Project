/*

Copy right here
 */
package com.vj.baseproject.util.extension

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


/**
 * Created by HB on 21/8/19.
 */
fun ImageView.loadImage(url: String, placeHolder: Int = -1) {
    val requestManager = Glide.with(this).load(url)
    if (placeHolder != -1) {
        requestManager.apply(RequestOptions().placeholder(placeHolder).error(placeHolder)).into(this)
    } else {
        requestManager.into(this)
    }
}

fun ImageView.loadDrawable(@DrawableRes image: Int, placeHolder: Int = -1) {
    val requestManager = Glide.with(this).load(image)
    if (placeHolder != -1) {
        requestManager.apply(RequestOptions().placeholder(placeHolder).error(placeHolder)).into(this)
    } else {
        requestManager.into(this)
    }
}

fun ImageView.loadCircleCropImage(image: String, placeHolder: Int = -1) {
    Glide.with(this.context)
            .load(image)
            .circleCrop()
            .placeholder(placeHolder)
            .into(this)
}
