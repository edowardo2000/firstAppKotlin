package com.example.edokotlinproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.edokotlinproject.model.MainMenu
import com.example.edokotlinproject.R

class MainMenuAdapter (val menu: List<MainMenu>, val listener: OnItemMenuClick) : RecyclerView.Adapter<MainMenuAdapter.MainMenuViewHolder>(){

    inner class MainMenuViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val imgMenu = view.findViewById<ImageView>(R.id.imgMenu)
        val judulMenu = view.findViewById<TextView>(R.id.txtNamaMenu)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainMenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_menu, parent, false)
        return MainMenuViewHolder(view)
    }


    override fun getItemCount(): Int {
        return menu.size
    }

    override fun onBindViewHolder(holder: MainMenuViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(menu[position].gambarMenu).into(holder.imgMenu)
        holder.judulMenu.text = menu[position].judulMenu

        holder.itemView.setOnClickListener(View.OnClickListener {
            listener.onItemClick( menu[position])
        })
    }

}