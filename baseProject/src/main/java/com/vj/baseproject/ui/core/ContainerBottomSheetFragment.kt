/*

Copy right here
 */
package com.vj.baseproject.ui.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.vj.baseproject.R
import com.vj.baseproject.databinding.FragmentContainerBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ContainerBottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentContainerBottomSheetBinding
    private lateinit var fragment: BaseFragment

    companion object {
        fun newInstance(baseFragment: BaseFragment): ContainerBottomSheetFragment {
            val args = Bundle()
            val fragment = ContainerBottomSheetFragment()
            fragment.setUpFragment(baseFragment)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /* setStyle(DialogFragment.STYLE_NORMAL, R.style.DialogStyle)*/
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContainerBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        childFragmentManager.beginTransaction().replace(R.id.bottomContainer, fragment).commit()
    }

    fun setUpFragment(fragment: BaseFragment) {
        this@ContainerBottomSheetFragment.fragment = fragment
    }
}

fun BaseFragment.showAsBottomSheet(fragmentManager: FragmentManager): BottomSheetDialogFragment {
    val containerBottomSheetFragment = ContainerBottomSheetFragment.newInstance(this)
    containerBottomSheetFragment.show(fragmentManager, this::class.java.simpleName)
    return containerBottomSheetFragment
}
