package com.vj.androidbase

import android.os.Bundle
import com.vj.androidbase.databinding.ActivityMainBinding
import com.vj.baseproject.ui.core.BaseBindingActivity

class MainActivity : BaseBindingActivity<ActivityMainBinding>() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBindingView(R.layout.activity_main)

    }
}