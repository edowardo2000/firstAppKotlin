package com.example.edokotlinproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.edokotlinproject.model.DataBerita

class BeritaDetail : AppCompatActivity() {

    lateinit var berita : DataBerita
    lateinit var imgBack : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_berita_detail)
        berita = intent.getParcelableExtra("berita")!!
        imgBack = findViewById(R.id.imgBack)

        Glide.with(this).load(berita.gambarBerita).into(findViewById<ImageView>(R.id.dgambarBerita))
        findViewById<ImageView>(R.id.dgambarUser).setImageResource(berita.gambarUser)
        findViewById<TextView>(R.id.dJudulBerita).text = berita.judulBerita
        findViewById<TextView>(R.id.dIsiBerita).text = berita.isiBerita

        imgBack.setOnClickListener(View.OnClickListener {
            intent = Intent(this@BeritaDetail, ListBerita::class.java)
            startActivity(intent)
        })
    }

}