/*

Copy right here
 */
package com.vj.baseproject.ui.core


import android.os.Bundle
import android.util.Log
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.vj.baseproject.util.helper.NetworkLiveData


abstract class BaseVMBindingActivity<T : ViewDataBinding, VM : BaseViewModel>(private var viewModelClass: Class<VM>) :
    BaseBindingActivity<T>() {

    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[viewModelClass]


        viewModel.loadingLiveData.observe(this) {
            if (it) {
                showLoading()
            } else {
                hideLoading()
            }
        }

        viewModel.networkLiveData = NetworkLiveData(this)
        viewModel.networkLiveData.observe(this) {
            if (!it) {
                onNetworkChange(it)
            }
        }

        viewModel.messageLiveData.observe(this) {
            showMessage(it)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.clearDisposable()
    }

    open fun onNetworkChange(isConnected: Boolean) {
        Log.e("Network Connected:", if (isConnected) "On Connect" else "On Disconnect")
    }
}
