package dev.bhavindesai.mvvmarch.ui.activities

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import dev.bhavindesai.mvvmarch.R
import dev.bhavindesai.mvvmarch.databinding.ActivityMainBinding
import dev.bhavindesai.mvvmarch.ui.base.BaseActivity
import dev.bhavindesai.mvvmarch.ui.base.BaseFragment

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        init()
    }

    private fun init() {
        binding.toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.secondaryTextColor))
        setActionBar(binding.toolbar)
    }
}