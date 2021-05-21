package com.example.shemajamebeli3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shemajamebeli3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val users = mutableListOf<UserModel>()
    private lateinit var adapter : UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        setData()
    }

    private fun init() {
        adapter = UserAdapter(users, object : ItemListener {
            override fun ItemOnClick(position: Int, buttonId : Int) {
                when(buttonId) {
                    R.id.btnEdit -> startIntent(users[position])
                    R.id.btnDetele -> users.removeAt(position)
                }
                startIntent(users[position])
            }
        })
        findViewById<RecyclerView>(R.id.recycler).layoutManager = LinearLayoutManager(this)
        findViewById<RecyclerView>(R.id.recycler).adapter = adapter
    }

    private fun setData() {
        users.add(UserModel("name", "surname", "email"))
        users.add(UserModel("name", "surname", "email"))

        adapter.notifyDataSetChanged()
    }

    private fun startIntent(item : UserModel) {
        val intent = Intent(this, ProfileActivity::class.java)
        intent.putExtra("name", item.name)
        intent.putExtra("title", item.surname)
        intent.putExtra("title", item.email)
        startActivity(intent)
    }
}