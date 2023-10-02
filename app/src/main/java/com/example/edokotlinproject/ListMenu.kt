package com.example.edokotlinproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.view.menu.MenuAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.edokotlinproject.adapter.MainMenuAdapter
import com.example.edokotlinproject.adapter.OnItemMenuClick
import com.example.edokotlinproject.model.DataBerita
import com.example.edokotlinproject.model.MainMenu

class ListMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_menu)


        val menu = listOf<MainMenu>(
            MainMenu(
                R.drawable.logoedo, "Simulasi Cicilan"
            ),
            MainMenu(
                R.drawable.logoedo, "Baca Berita"
            ),
            MainMenu(
                R.drawable.logoedo, "Baca Berita"
            ),
            MainMenu(
                R.drawable.logoedo, "Baca Berita"
            ),
            MainMenu(
                R.drawable.logoedo, "Baca Berita"
            ),
        )

        val listMenu = findViewById<RecyclerView>(R.id.RecycleMenu)
        listMenu.layoutManager = LinearLayoutManager (this)
        listMenu.adapter = MainMenuAdapter(menu, object: OnItemMenuClick {
            override fun onItemClick(menu: MainMenu) {
                intent = Intent(this@ListMenu, SimulasiCicilan::class.java)
                intent.putExtra("menu", menu)
                startActivity(intent)
            }
        })
    }

}