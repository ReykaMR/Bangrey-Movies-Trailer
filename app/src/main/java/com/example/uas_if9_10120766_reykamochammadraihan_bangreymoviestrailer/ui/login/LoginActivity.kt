package com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.ui.login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.MainActivity
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.databinding.ActivityLoginBinding
import com.example.uas_if9_10120766_reykamochammadraihan_bangreymoviestrailer.utils.Profile

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)
        supportActionBar?.hide()

        loginBinding.btnLogin.setOnClickListener {
            val valueGender : String = if(loginBinding.radioGender.checkedRadioButtonId == loginBinding.radioMale.id){
                Profile.MALE_VALUE
            } else {
                Profile.FEMALE_VALUE
            }
            val sharedPref = getSharedPreferences(Profile.KEY_APP, Context.MODE_PRIVATE)
            with (sharedPref.edit()) {
                putString(Profile.KEY_NAME, loginBinding.editName.text.toString())
                putString(Profile.KEY_GENDER, valueGender)
                apply()
            }
            val i = Intent(applicationContext, MainActivity::class.java)
            startActivity(i)
            finish()
        }
    }
}