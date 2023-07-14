package com.example.kmtest

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class UserAdapter: RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private val userList = mutableListOf<UserList>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_user, parent, false)

        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.bind(user)

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, SecondScreenActivity::class.java)
            intent.putExtra("user_name", user.first_name)
            context.startActivity(intent)
        }
    }

    fun submitList(list: List<UserList>) {
        userList.clear()
        userList.addAll(list)
        notifyDataSetChanged()
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val firstName: TextView = itemView.findViewById(R.id.tv_first_name)
        private val lastName: TextView = itemView.findViewById(R.id.tv_last_name)
        private val userEmail: TextView = itemView.findViewById(R.id.tv_email)
        private val userAvatar: ImageView = itemView.findViewById(R.id.iv_avatar)

        fun bind(user: UserList) {
            firstName.text = user.first_name
            lastName.text = user.last_name
            userEmail.text = user.email

            Glide.with(itemView)
                .load(user.avatar)
                .apply(RequestOptions.circleCropTransform())
                .into(userAvatar)
        }

    }

}