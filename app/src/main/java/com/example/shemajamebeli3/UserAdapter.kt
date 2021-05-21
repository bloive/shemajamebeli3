package com.example.shemajamebeli3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shemajamebeli3.databinding.UserViewBinding


class UserAdapter (private val items: MutableList<UserModel>, private val ItemListener: ItemListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.user_view, parent, false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.name).text = items[position].name
        holder.itemView.findViewById<TextView>(R.id.surname).text = items[position].surname
        holder.itemView.findViewById<TextView>(R.id.email).text = items[position].email
    }

    override fun getItemCount() = items.size

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private lateinit var model: UserModel
        fun bind() {
            model = items[adapterPosition]
            itemView.findViewById<TextView>(R.id.name).text =  model.name
            itemView.findViewById<TextView>(R.id.surname).text =  model.surname
            itemView.findViewById<TextView>(R.id.email).text =  model.email
        }
        override fun onClick ( v: View?) {
            ItemListener.ItemOnClick(adapterPosition, )
        }
    }

    // :(
}