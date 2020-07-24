package dev.bhavindesai.mvvmarch.ui.activities

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import dev.bhavindesai.mvvmarch.R
import dev.bhavindesai.mvvmarch.databinding.ActivityMainBinding
import dev.bhavindesai.mvvmarch.ui.base.BaseActivity
import dev.bhavindesai.mvvmarch.ui.login.LoginFragment

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        init()

        addOrReplaceFragment(LoginFragment.newInstance(), R.id.container, true)
    }

    private fun init() {
        binding.toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.secondaryTextColor))
        setActionBar(binding.toolbar)
    }

    override fun setActionBarVisibility(isVisible: Boolean) {
        binding.toolbar.visibility =  if (isVisible) View.VISIBLE else View.GONE
    }

    fun setToolbarTitle(title: String){
        supportActionBar?.title = title
    }
}