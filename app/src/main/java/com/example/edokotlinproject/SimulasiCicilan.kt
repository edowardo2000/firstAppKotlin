package com.example.edokotlinproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.get
import org.w3c.dom.Text
import java.text.DecimalFormat

class SimulasiCicilan : AppCompatActivity() {

    lateinit var jmlUang : SeekBar
    lateinit var txtPinjaman : TextView
    lateinit var interestArray: Array<Double>
    lateinit var lstInterest: Spinner
    lateinit var grpTenor : RadioGroup
    lateinit var btnHitung: Button
    lateinit var txtCicilan: TextView
    lateinit var imgBack : ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simulasi_cicilan)

        intent.getStringExtra("username")
        jmlUang = findViewById(R.id.jmlUang)
        txtPinjaman = findViewById(R.id.txtPinjaman)
        lstInterest = findViewById(R.id.spinnerBunga)
        grpTenor = findViewById(R.id.grpTenor)
        btnHitung = findViewById(R.id.btnHitung)
        imgBack = findViewById(R.id.imgBack)
        setupSpinnerInterest()

        jmlUang.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val jumlahUang = (progress + 1) * 100000
                txtPinjaman.text = "Rp $jumlahUang"

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

        imgBack.setOnClickListener(View.OnClickListener {
            intent = Intent (this, MainMenu::class.java)
            startActivity(intent)
        })

        btnHitung.setOnClickListener( View.OnClickListener {
            hitungCicilan()
        })
    }
        fun setupSpinnerInterest(){
            interestArray = arrayOf(0.0027, 0.003)
            val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, interestArray)
            lstInterest.adapter = adapter
        }

        fun hitungCicilan(){
            val jumlahUang = (jmlUang.progress+1)*100000
            val tenor = grpTenor.checkedRadioButtonId
            var nilaiTenor =0

            when(tenor){
                R.id.radio3 -> nilaiTenor = 3
                R.id.radio6 -> nilaiTenor = 6
                R.id.radio12 -> nilaiTenor =12
            }

            var selectedBunga = interestArray[lstInterest.selectedItemPosition]

            val r = selectedBunga/12
            var cicilan = jumlahUang * r/(1-Math.pow((1+r),-nilaiTenor.toDouble()))

            Toast.makeText(this, "cicilannya adalah $cicilan", Toast.LENGTH_SHORT).show()
            val formater = DecimalFormat("##,###")
            findViewById<TextView>(R.id.txtCicilan).text = "Total Cicilan Rp ${formater.format(cicilan)}"
        }
    }
