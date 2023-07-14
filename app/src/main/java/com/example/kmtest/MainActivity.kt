package com.example.kmtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    private lateinit var inputEditText: EditText
    lateinit var pict: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputEditText = findViewById(R.id.ed_palindrome)

        val btnNext: Button = findViewById(R.id.btn_next)
        btnNext.setOnClickListener {
            val intent = Intent(this, SecondScreenActivity::class.java)
            startActivity(intent)
        }

        pict = findViewById(R.id.iv_pict)
    }

    fun onCheckButtonClicked(view: View) {
        val inputString = inputEditText.text.toString().trim()
        if (inputString.isNotEmpty()) {
            val isPalindrome = isPalindromeString(inputString)
            if (isPalindrome) {
                showToast("$inputString is a Palindrome")
            }

            else {
                showToast("$inputString is not a Palindrome")
            }
        }

        else {
            showToast("Please enter the word")
        }
    }

    private fun isPalindromeString(inputStr: String): Boolean {

        val sb = java.lang.StringBuilder(inputStr)
        val reverseStr = sb.reverse().toString()

        return inputStr.equals(reverseStr, ignoreCase = true)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}