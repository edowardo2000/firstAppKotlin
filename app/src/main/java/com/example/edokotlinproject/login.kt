package com.example.edokotlinproject

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import org.w3c.dom.Text

class login : AppCompatActivity() {
    lateinit var btnLogin: Button
    lateinit var username: TextView
    lateinit var password: TextView
    lateinit var txtPassword: TextInputEditText
    lateinit var txtUsername: TextInputEditText
    lateinit var txtLostPassword: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        btnLogin= findViewById(R.id.btnLogin)
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        txtPassword = findViewById(R.id.password)
        txtUsername = findViewById(R.id.username)
        txtLostPassword = findViewById(R.id.txtLostPassword)


        btnLogin.setOnClickListener( View.OnClickListener {
            var result = validation(username.text.toString(), password.text.toString())
            if (result){
            intent = Intent (this, ListMenu::class.java)
            startActivity(intent)}
            else{
                val snackBar = Snackbar.make(findViewById<View>(android.R.id.content) , "Login gagal", Snackbar.LENGTH_SHORT)
                snackBar.setAction("Try Again", View.OnClickListener {
                    snackBar.dismiss()
                })
                snackBar.show()
            }
        })

        findViewById<TextView>(R.id.txtLostPassword).setOnClickListener(View.OnClickListener {
            intent = Intent(Intent.ACTION_VIEW, Uri.parse("tel: 0823232323"))
            startActivity(intent)
        })
    }

    fun validation(username: String, password: String): Boolean {


//        The email couldn't start or finish with a dot
//        The email shouldn't contain spaces into the string
//        The email shouldn't contain special chars (<:, *,ecc)
//        The email could contain dots in the middle of mail address before the @
//        The email could contain a double doman ( '.de.org' or similar rarity)
        val emailRegex = "^((?!\\.)[\\w\\-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])\$".toRegex()

//        password must contain 1 number (0-9)
//        password must contain 1 uppercase letters
//        password must contain 1 lowercase letters
//        password must contain 1 non-alpha numeric number
//        password is 8-16 characters with no space
        val passwordRegex = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\d\\s:])([^\\s]){8,16}\$".toRegex()

        if(username.matches(emailRegex) && password.matches(passwordRegex)){
            Toast.makeText(this, "Berhasil Login", Toast.LENGTH_SHORT).show()
            return true
        }
        else{
            txtPassword.error = "Password tidak memenuhi format"
        }

        if(username.isBlank()){
            txtUsername.error = "Username tidak boleh kosong"
        }

        return false

    }
}