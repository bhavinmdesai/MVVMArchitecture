package dev.bhavindesai.mvvmarch.ui.userlist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dev.bhavindesai.mvvmarch.R
import dev.bhavindesai.mvvmarch.databinding.FragmentUserListBinding
import dev.bhavindesai.mvvmarch.ui.activities.MainActivity
import dev.bhavindesai.mvvmarch.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserListFragment : BaseFragment() {

    private lateinit var binding: FragmentUserListBinding

    private val userListViewModel: UserListViewModel by viewModel()

    private val userListAdapter = UserListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_list, container, false)

        init()

        setupObserver()

        userListViewModel.getListOfUsers()
        return binding.root
    }

    private fun init() {
        binding.rvUsers.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvUsers.addItemDecoration(SpaceItemDecoration(requireContext(), R.dimen.list_item_spacing))
        binding.rvUsers.adapter = userListAdapter
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val activity = requireActivity() as MainActivity

        activity.setToolbarTitle("Users")
        activity.setActionBarVisibility(true)
    }

    private fun setupObserver() {
        userListViewModel.userList.observe(viewLifecycleOwner, Observer {
            it?.apply {
                userListAdapter.setUserList(it)
                userListAdapter.notifyDataSetChanged()
            }
        })
    }

    override fun onReAppear() {

    }

    companion object {
        fun newInstance() = UserListFragment()
    }
}

