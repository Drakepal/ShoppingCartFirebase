package com.example.shoppingcartfirebase.viewmodel

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.shoppingcartfirebase.model.MenuModel

class MenuAdapter (
    private val context: Context,
    private val list: List<MenuModel>
        ) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {
    class MenuViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var menuImage: ImageView? = null
        var menuName: TextView? = null
        var menuPrice: TextView? = null

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}