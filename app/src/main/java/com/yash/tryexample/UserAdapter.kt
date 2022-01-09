package com.yash.tryexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class UserAdapter(private val context: Context, private val results: List<Results>): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_view,parent,false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        val result = results[position]
        holder.displayName.text = result.displayName
        holder.dateCreated.text = result.createdAtString

        Glide.with(context).load(result.s3TempPath).into(holder.apiImage)


    }

    override fun getItemCount(): Int {
        return results.size
    }

    class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var displayName: TextView = itemView.findViewById(R.id.displayName)
        var dateCreated: TextView = itemView.findViewById(R.id.dateCreated)
        var apiImage: ImageView = itemView.findViewById(R.id.apiImage)

    }

}