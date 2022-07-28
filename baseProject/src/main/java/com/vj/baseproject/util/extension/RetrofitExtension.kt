/*

Copy right here
 */
package com.vj.baseproject.util.extension


import com.vj.baseproject.util.helper.RetrofitUtils
import okhttp3.RequestBody
import java.io.File

fun String.toRequestBody(): RequestBody {
    return RetrofitUtils.getStringBody(this)
}

fun File?.toImageBody(): RequestBody {
    return RetrofitUtils.getImageBody(this)
}
