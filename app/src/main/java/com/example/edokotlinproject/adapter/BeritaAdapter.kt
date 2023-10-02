package com.example.edokotlinproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.edokotlinproject.R
import com.example.edokotlinproject.model.DataBerita

class BeritaAdapter (val berita: List<DataBerita>, val listener: OnItemBeritaClick) : RecyclerView.Adapter<BeritaAdapter.BeritaViewHolder>(){

    inner class BeritaViewHolder(view: View ) : RecyclerView.ViewHolder(view){
        //mapping layout dengan findViewById
        val gambarBerita = view.findViewById<ImageView>(R.id.gambarBerita)
        val gambarUser = view.findViewById<ImageView>(R.id.gambarUser)
        val judulBerita = view.findViewById<TextView>(R.id.txtJudul)
        val isiBerita = view.findViewById<TextView>(R.id.txtBerita)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeritaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_berita, parent, false)
        return BeritaViewHolder(view)
    }

    override fun getItemCount(): Int {
        return berita.size
    }

    override fun onBindViewHolder(holder: BeritaViewHolder, position: Int) {
        
        Glide.with(holder.itemView.context).load(berita[position].gambarBerita).into(holder.gambarBerita)
        holder.gambarUser.setImageResource(berita[position].gambarUser)
        holder.judulBerita.text = berita[position].judulBerita
        holder.isiBerita.text = berita[position].isiBerita

        holder.itemView.setOnClickListener(View.OnClickListener {
            listener.onItemClick( berita[position])
        })


    }
}