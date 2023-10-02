package com.example.edokotlinproject

import android.location.GnssAntennaInfo.Listener
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.os.UserHandle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var txtHasil: TextView
    lateinit var imageBatu: ImageView
    lateinit var imageGunting: ImageView
    lateinit var imageKertas: ImageView
    lateinit var imageCPU: ImageView
    lateinit var btnPindah: Button

    enum class Pilihan{
        BATU, GUNTING, KERTAS
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        setContentView(R.layout.screengame)
//        txtNama = findViewById<TextView>(R.id.txtNama)
//        txtNama.text="Edowardo"

        imageBatu = findViewById(R.id.imageBatu)
        imageGunting = findViewById(R.id.imageGunting)
        imageKertas = findViewById(R.id.imageKertas)
        imageCPU = findViewById(R.id.imageCPU)
        txtHasil = findViewById(R.id.txtHasil)

        imageKertas.setOnClickListener( OnClickListener {
            Toast.makeText(this, "Kertas", Toast.LENGTH_SHORT).show()
            rulesOfGames(Pilihan.KERTAS)
        })

        imageBatu.setOnClickListener( OnClickListener {
            Toast.makeText(this, "Batu", Toast.LENGTH_SHORT).show()
            rulesOfGames(Pilihan.BATU)
        })

        imageGunting.setOnClickListener( OnClickListener {
            Toast.makeText(this, "Gunting", Toast.LENGTH_SHORT).show()
            rulesOfGames(Pilihan.GUNTING)
        })
    }

    fun pindahHalaman(view: View){
        Toast.makeText(this, "Pindah Halaman", Toast.LENGTH_SHORT).show()
    }

    fun rulesOfGames(pilihanUser: Pilihan){
        val pilihanKomputer = Pilihan.values()[(Random.nextInt(Pilihan.values().size))]
        when (pilihanKomputer){
            Pilihan.BATU->imageCPU.setImageResource(R.drawable.batu)
            Pilihan.KERTAS->imageCPU.setImageResource(R.drawable.kertas)
            Pilihan.GUNTING->imageCPU.setImageResource(R.drawable.gunting)

        }
        Toast.makeText(this, "Pilihan komputer : $pilihanKomputer", Toast.LENGTH_SHORT).show()

        when{
            pilihanUser == pilihanKomputer -> txtHasil.text= "SERI"
            (pilihanUser == Pilihan.BATU && pilihanUser == Pilihan.GUNTING) ||
                    (pilihanUser == Pilihan.KERTAS && pilihanKomputer == Pilihan.BATU) ||
                    (pilihanUser == Pilihan.GUNTING && pilihanKomputer == Pilihan.KERTAS) ->
                txtHasil.text = "Yey Kamu Menang"
            else-> txtHasil.text = "Yahh Kamu Kalah"
        }
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "onPause() jalan", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "onResume() jalan", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "onDestroy() jalan", Toast.LENGTH_SHORT).show()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Toast.makeText(this, "onSave() jalan", Toast.LENGTH_SHORT).show()

    }


}