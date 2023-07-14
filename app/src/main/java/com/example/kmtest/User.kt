package com.example.kmtest

data class User(
    val data: List<UserList>
)

data class UserList(
    val email : String,
    val first_name: String,
    val last_name: String,
    val avatar: String
)
