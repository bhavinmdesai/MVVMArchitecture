package dev.bhavindesai.mvvmarch.ui.base

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import dev.bhavindesai.mvvmarch.R
import dev.bhavindesai.mvvmarch.ui.constants.FragmentAnimation

abstract class BaseActivity : AppCompatActivity(), FragmentManager.OnBackStackChangedListener {

    fun addOrReplaceFragment(fragment: Fragment, containerViewId: Int, isAdded: Boolean = false, fragmentAnimation: FragmentAnimation = FragmentAnimation.DEFAULT): Int {
        val fragmentTransaction = supportFragmentManager.beginTransaction()

        when (fragmentAnimation) {
            FragmentAnimation.IN_RIGHT_OUT_LEFT -> fragmentTransaction.setCustomAnimations(
                R.anim.fragment_right_in, R.anim.fragment_left_out,
                R.anim.fragment_left_in, R.anim.fragment_right_out
            )
            FragmentAnimation.IN_TOP_OUT_BOTTOM -> {
            }
        }

        if (isAdded) {
            fragmentTransaction.add(containerViewId, fragment)
        } else {
            fragmentTransaction.replace(containerViewId, fragment)
        }

        fragmentTransaction.addToBackStack(null)

        return fragmentTransaction.commit()
    }

    private fun getCurrentFragment(): Fragment? {
        return supportFragmentManager.findFragmentById(R.id.container)
    }

    override fun onBackStackChanged() {
        val fragment = getCurrentFragment()

        fragment?.let {
            (fragment as BaseFragment).onReAppear()
        }
    }

    abstract fun setActionBarVisibility(isVisible: Boolean)
}