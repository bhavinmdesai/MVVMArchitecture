package dev.bhavindesai.mvvmarch.ui.userlist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import dev.bhavindesai.mvvmarch.R
import dev.bhavindesai.mvvmarch.databinding.FragmentUserListBinding
import dev.bhavindesai.mvvmarch.ui.activities.MainActivity
import dev.bhavindesai.mvvmarch.ui.base.BaseFragment

class UserListFragment : BaseFragment() {

    private lateinit var binding: FragmentUserListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_list, container, false)

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val activity = requireActivity() as MainActivity

        activity.setToolbarTitle("Users")
        activity.setActionBarVisibility(true)
    }

    override fun onReAppear() {

    }

    companion object {
        fun newInstance() = UserListFragment()
    }
}

