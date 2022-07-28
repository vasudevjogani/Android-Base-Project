/*

Copy right here
 */
package com.vj.baseproject.data.model

import com.google.gson.annotations.SerializedName

open class ApiResponse {

    @SerializedName("status")
    val status: Boolean = false

    @SerializedName("message")
    val message: String = ""

    @SerializedName("request_id")
    val requestId: Long = 0

    fun onSuccess(callback: (String) -> Unit) {
        callback(message)
    }
}


