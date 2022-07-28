/*

Copy right here
 */
package com.vj.baseproject.data.remote

import com.dc.retroapi.builder.RetrofitClientBuilder
import com.dc.retroapi.interceptor.RequestInterceptor
import com.dc.retroapi.interceptor.ResponseInterceptor
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {
    fun <T> getService(services: Class<T>): T {
        return RetrofitClientBuilder().baseUrl("")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .addInterceptor(RequestInterceptor(object : RequestInterceptor.OnRequestInterceptor {
                override fun provideBodyMap(): HashMap<String, String> {
                    return hashMapOf()
                }

                override fun provideHeaderMap(): HashMap<String, String> {
                    val hashMap = HashMap<String, String>()
                    /*hashMap["Authorization"] = "Basic YWRtaW46YWRtaW5AMTIz"
                    hashMap["access_token"] = PrefManager.getStringPref("accessToken")*/
                    return hashMap
                }

                override fun removeFromBody(): ArrayList<String> {
                    return arrayListOf<String>()
                }
            }))
            .addInterceptor(ResponseInterceptor(object : ResponseInterceptor.OnResponseCallback {
                override fun onNetworkResponse(response: Response) {
                    if (response.code == 401) {
                        /*BaseApplication.application.logout()*/
                    }
                }
            }))
            .addLogInterceptor(HttpLoggingInterceptor.Level.BODY)
            .create(services)
    }
}
