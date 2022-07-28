package com.vj.baseproject.ui.core

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vj.baseproject.BaseApplication

import com.vj.baseproject.util.extension.isNetworkAvailable

import com.vj.baseproject.util.helper.SingleLiveData
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

open class BaseViewModel : ViewModel() {

    lateinit var networkLiveData: MutableLiveData<Boolean>
    val loadingLiveData = MutableLiveData<Boolean>()
    private val compositeDisposable = CompositeDisposable()
    val validationLiveData = SingleLiveData<String>()
    val messageLiveData = SingleLiveData<String>()

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    fun clearDisposable() {
        compositeDisposable.clear()
    }

    private fun validateNetwork(onNetworkConnected: () -> Unit) {
        if (isNetworkAvailable()) {
            onNetworkConnected()
        } else {
            networkLiveData.postValue(false)
        }
    }

    fun <T> callAPI(observable: Single<T>, withLoading: Boolean, callback: (T) -> Unit) {
        validateNetwork {
            if (withLoading) {
                invalidateLoading(true)
            }
            observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<T> {
                    override fun onSubscribe(d: Disposable) {
                        addDisposable(d)
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                        if (withLoading) {
                            invalidateLoading(false)
                        }
                    }


                    override fun onSuccess(t: T) {
                        if (withLoading) {
                            invalidateLoading(false)
                        }
                        callback(t)
                    }
                })
        }
    }

    fun invalidateLoading(show: Boolean) {
        loadingLiveData.postValue(show)
    }

    fun showMessage(message: String) {
        messageLiveData.postValue(message)
    }

    override fun onCleared() {
        super.onCleared()
        clearDisposable()
    }

    fun isNetworkAvailable(): Boolean {
        return BaseApplication.application.applicationContext.isNetworkAvailable()
    }
}
