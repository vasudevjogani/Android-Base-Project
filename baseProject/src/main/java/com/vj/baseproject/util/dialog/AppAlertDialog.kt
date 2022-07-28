/*

Copy right here
 */
package com.vj.baseproject.util.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.vj.baseproject.databinding.LayoutAppDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class AppAlertDialog(val callback: (AppAlertDialog, LayoutAppDialogBinding) -> Unit) :
    BottomSheetDialogFragment() {

    lateinit var binding: LayoutAppDialogBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LayoutAppDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callback(this, binding)
    }
}
