package com.example.kmtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondScreenActivity : AppCompatActivity() {

    private lateinit var tvWelcome: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)

        tvWelcome = findViewById(R.id.tv_welcome)

        val userName = intent.getStringExtra("user_name")
        val welcomeMessage = "Welcome ${userName ?: "Guest"}!"
        tvWelcome.text = welcomeMessage

        val btnChooseUser: Button = findViewById(R.id.btn_choose_user)
        btnChooseUser.setOnClickListener {
            val intent = Intent(this, ThirdScreenActivity::class.java)
            startActivity(intent)
        }
    }
}