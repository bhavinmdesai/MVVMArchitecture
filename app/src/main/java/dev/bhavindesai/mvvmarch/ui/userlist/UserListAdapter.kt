package dev.bhavindesai.mvvmarch.ui.userlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import dev.bhavindesai.mvvmarch.R
import dev.bhavindesai.mvvmarch.data.remote.models.User
import dev.bhavindesai.mvvmarch.databinding.ListItemUserBinding

class UserListAdapter() : RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    private var userList = mutableListOf<User>()

    fun setUserList(userList: List<User>){
        this.userList.clear()
        this.userList.addAll(userList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ListItemUserBinding>(LayoutInflater.from(parent.context), R.layout.list_item_user, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(userList[position])

    override fun getItemCount(): Int = userList.size

    inner class ViewHolder(private val binding: ListItemUserBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User) {
            binding.user = user
            binding.executePendingBindings()
        }
    }
}