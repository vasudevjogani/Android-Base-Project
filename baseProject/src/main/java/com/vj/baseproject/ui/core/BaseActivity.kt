/*

Copy right here
 */
package com.vj.baseproject.ui.core

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.vj.baseproject.databinding.LayoutLoadingBinding
import com.vj.baseproject.util.extension.createDialogWithoutBounds
import com.vj.baseproject.util.extension.showAsToast


open class BaseActivity : AppCompatActivity() {

    var dialog: Dialog? = null
    val TAG = "ActivityLifeCycle:" + this::class.java.simpleName

    open fun showLoading() {
        dialog = createDialogWithoutBounds(
            LayoutLoadingBinding.inflate(
                LayoutInflater.from(this),
                null,
                false
            ).root
        )
        dialog?.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(TAG, "OnCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG, "OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "OnPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "OnDestroy")
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, "OnStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e(TAG, "OnRestart")
    }

    open fun hideLoading() {
        Log.e("Loading", "On Hidden")
        dialog?.dismiss()
    }


    fun showMessage(message: String) {
        message.showAsToast(this)
        /*Flashbar.Builder(this).title("\n\n\nMessage")
            .message(message)
            .backgroundColor(ContextCompat.getColor(this, R.color.colorPrimary))
            .gravity(Flashbar.Gravity.TOP)
            .duration(3000)
            .show()*/
    }
}
