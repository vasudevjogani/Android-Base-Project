
package com.vj.baseproject.ui.core

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

/**
 * Created by HB on 21/8/19.
 */
open class BaseFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(TAG, "OnCreate")
        onFragmentCreated()
    }

    open fun onFragmentCreated() {

    }

    open fun showLoading() {
        (activity as BaseActivity).showLoading()
    }

    open fun hideLoading() {
        (activity as BaseActivity).hideLoading()
    }


    val TAG = "FragmentLifeCycle:" + this::class.java.simpleName

    override fun onStart() {
        super.onStart()
        Log.e(TAG, "OnStart")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e(TAG, "OnCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e(TAG, "OnViewCreated")
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

    fun requireAppcompatActivity(): AppCompatActivity {
        return requireActivity() as AppCompatActivity
    }
}
