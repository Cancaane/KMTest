package com.example.kmtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ThirdScreenActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_screen)

        recyclerView = findViewById(R.id.rv_list_user)
        recyclerView.layoutManager = LinearLayoutManager(this)

        userAdapter = UserAdapter()
        recyclerView.adapter = userAdapter

        showUserList()
    }

    private fun showUserList() {
        val apiService = ApiConfig.apiService
        val call = apiService.getUsers()

        call.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    val userList = response.body()
                    userList?.let {
                        val user = it.data
                        userAdapter.submitList(user)
                    }
                }

            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.e("Network Error", "Error: ${t.message}", t)
            }
        })
    }
}