package com.example.edokotlinproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.edokotlinproject.adapter.BeritaAdapter
import com.example.edokotlinproject.adapter.OnItemBeritaClick
import com.example.edokotlinproject.model.DataBerita

class ListBerita : AppCompatActivity() {
    lateinit var imgBack : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_berita)

        val berita = listOf<DataBerita>(
            DataBerita("https://awsimages.detik.net.id/visual/2022/09/15/indeks-harga-saham-gabungan-ihsg-di-bursa-efek-indonesia-jakarta-cnbc-indonesiatri-susilo-4_169.jpeg?w=715&q=90",
                R.drawable.logoedo, "Berita 1", "lorem itsum lorem itsum lorem itsumlorem itsum lorem itsum lorem itsum lorem itsum lorem itsum lorem itsumlorem itsum lorem itsum lorem itsum lorem itsum lorem itsum lorem itsumlorem itsum lorem itsum lorem itsum"
            ),
            DataBerita("https://awsimages.detik.net.id/visual/2022/09/15/indeks-harga-saham-gabungan-ihsg-di-bursa-efek-indonesia-jakarta-cnbc-indonesiatri-susilo-4_169.jpeg?w=715&q=90",
            R.drawable.logoedo, "Berita 2", "lorem itsum lorem itsum lorem itsumlorem itsum lorem itsum lorem itsum"
            ),
            DataBerita("https://awsimages.detik.net.id/visual/2022/09/15/indeks-harga-saham-gabungan-ihsg-di-bursa-efek-indonesia-jakarta-cnbc-indonesiatri-susilo-4_169.jpeg?w=715&q=90",
                R.drawable.logoedo, "Berita 2", "lorem itsum lorem itsum lorem itsumlorem itsum lorem itsum lorem itsum"
            ),
            DataBerita("https://awsimages.detik.net.id/visual/2022/09/15/indeks-harga-saham-gabungan-ihsg-di-bursa-efek-indonesia-jakarta-cnbc-indonesiatri-susilo-4_169.jpeg?w=715&q=90",
                R.drawable.logoedo, "Berita 2", "lorem itsum lorem itsum lorem itsumlorem itsum lorem itsum lorem itsum"
            )
        )

        imgBack = findViewById(R.id.imgBack)
        //callback method

        val listBerita = findViewById<RecyclerView>(R.id.RecycleBerita)
        listBerita.layoutManager = LinearLayoutManager (this)
        listBerita.adapter = BeritaAdapter(berita, object: OnItemBeritaClick{
            override fun onItemClick(berita: DataBerita){
                intent = Intent(this@ListBerita, BeritaDetail::class.java)
                intent.putExtra("berita", berita)
                startActivity(intent)
            }
        })

        imgBack.setOnClickListener(View.OnClickListener {
            intent = Intent(this@ListBerita, MainMenu::class.java)
            startActivity(intent)
        })
    }
}