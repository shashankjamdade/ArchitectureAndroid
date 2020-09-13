package com.matrimony.demo.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.matrimony.demo.R
import com.matrimony.demo.listener.ItemClickListener
import com.matrimony.demo.model.ResultUserItem
import com.matrimony.demo.model.UserListResponse
import kotlinx.android.synthetic.main.item_user_list.view.*


class UserListAdapter(
    var users: ArrayList<ResultUserItem>,
    var context: Context,
    var itemClickListener: ItemClickListener
) : RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder =
        UserViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_user_list, parent, false)
        )

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position])
        holder.itemView.btn_accept.setOnClickListener {
            var item = users?.get(position);
            item?.userChoice = "accepted"
            itemClickListener.setClickedInfo(item)
        }
        holder.itemView.btn_reject.setOnClickListener {
            var item = users?.get(position);
            item?.userChoice = "rejected"
            itemClickListener.setClickedInfo(item)
        }
    }

    fun refreshAdapter(newUsers: List<ResultUserItem>) {
        users.clear()
        users.addAll(newUsers)
        notifyDataSetChanged()
    }

    inner class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val layout = view.item_layout
        private val firstName = view.first_name
        private val lastName = view.last_name
        private val email = view.email
        private val image = view.imageView
        private val choice = view.choice
        fun bind(usr: ResultUserItem) {
            firstName.text = usr?.name?.first
            lastName.text = usr?.name?.last
            email.text = usr?.email
            choice.text = usr?.userChoice
            Glide.with(context).load(usr?.picture?.medium).placeholder(R.drawable.ic_sync)
                .into(image)


        }
    }
}