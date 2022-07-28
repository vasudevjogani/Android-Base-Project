/*

Copy right here
 */
package com.vj.baseproject.data.remote

import com.vj.baseproject.data.model.ApiResponse
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface CoreApi {

    @POST("register")
    @FormUrlEncoded
    fun register(
        @Field("user_type") loginType: String,
        @Field("device_type") deviceType: Int,
        @Field("mobile_no") mobile: String,
        @Field("email") email: String,
        @Field("social_id") socialId: String,
        @Field("first_name") firstName: String,
        @Field("last_name") lastName: String,
        @Field("password") password: String,
        @Field("type") type: String,
        @Field("country_code") countryCode: String = "91"
    ): Single<ApiResponse>

}
