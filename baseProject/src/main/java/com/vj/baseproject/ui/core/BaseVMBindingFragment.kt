/*

Copy right here
 */
package com.vj.baseproject.ui.core


import android.util.Log
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.vj.baseproject.ui.core.BaseViewModel
import com.vj.baseproject.util.extension.showAsToast
import com.vj.baseproject.util.helper.NetworkLiveData


abstract class BaseVMBindingFragment<T : ViewDataBinding, VM : BaseViewModel>(private var viewModelClass: Class<VM>) :
    BaseBindingFragment<T>() {

    lateinit var viewModel: VM


    override fun onFragmentCreated() {
        super.onFragmentCreated()
        viewModel = ViewModelProvider(this).get(viewModelClass)
        viewModel.loadingLiveData.observe(this) {
            if (it) {
                showLoading()
            } else {
                hideLoading()
            }
        }

        viewModel.networkLiveData = NetworkLiveData(requireContext())
        viewModel.networkLiveData.observe(this) {
            onNetworkChange(it)
        }

        viewModel.messageLiveData.observe(this) {
            showMessage(it)
        }
    }

    /**
     * Here network change callback occur
     * @param isConnected whether device is connected with network or not
     */
    open fun onNetworkChange(isConnected: Boolean) {
        Log.e("Network Connected:", if (isConnected) "On Connect" else "On Disconnect")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.clearDisposable()
    }

    fun showMessage(message: String) {
        message.showAsToast(requireContext())
        /*Flashbar.Builder(requireActivity()).title("\n\n\nMessage")
            .message(message)
            .backgroundColor(ContextCompat.getColor(requireContext(), R.color.colorPrimary))
            .gravity(Flashbar.Gravity.TOP)
            .duration(3000)
            .show()*/
    }
}
