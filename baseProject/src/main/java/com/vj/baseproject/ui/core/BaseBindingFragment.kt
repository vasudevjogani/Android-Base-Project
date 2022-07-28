/*

Copy right here
 */
package com.vj.baseproject.ui.core


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

import com.google.android.material.bottomsheet.BottomSheetDialogFragment


/**
 * Created by HB on 21/8/19.
 */
open class BaseBindingFragment<T : ViewDataBinding> : BaseFragment() {

    lateinit var binding: T

    protected fun generateBinding(
        @LayoutRes layoutId: Int,
        container: ViewGroup?,
        inflater: LayoutInflater
    ): View {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return binding.root
    }

    fun dismiss() {
        if (parentFragment is BottomSheetDialogFragment) {
            (parentFragment as BottomSheetDialogFragment).dismiss()
        }
    }
}
