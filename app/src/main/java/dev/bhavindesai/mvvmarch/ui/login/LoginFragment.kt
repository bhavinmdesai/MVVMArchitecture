package dev.bhavindesai.mvvmarch.ui.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import dev.bhavindesai.mvvmarch.R
import dev.bhavindesai.mvvmarch.databinding.FragmentLoginBinding
import dev.bhavindesai.mvvmarch.ui.activities.MainActivity
import dev.bhavindesai.mvvmarch.ui.base.BaseFragment
import dev.bhavindesai.mvvmarch.ui.userlist.UserListFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment() {

    private lateinit var binding: FragmentLoginBinding

    private val viewModel: LoginViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        baseViewModel = viewModel

        super.onCreateView(inflater, container, savedInstanceState)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        setObservers()

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireActivity() as MainActivity).setActionBarVisibility(false)
    }

    private fun setObservers() {
        viewModel.ldLoginSuccessful.observe(viewLifecycleOwner, Observer {
            val activity = requireActivity() as MainActivity

            activity.addOrReplaceFragment(UserListFragment.newInstance(), R.id.container)
        })

        viewModel.showLoader.observe(viewLifecycleOwner, Observer {
            if (it)
                binding.pbLoading.visibility = View.VISIBLE
            else
                binding.pbLoading.visibility = View.GONE
        })
    }

    override fun onReAppear() {
        (requireActivity() as MainActivity).setActionBarVisibility(false)
    }

    companion object {
        fun newInstance() = LoginFragment()
    }
}