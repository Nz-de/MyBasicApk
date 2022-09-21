package com.aproduction.myapplist1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity  : AppCompatActivity() {
    private lateinit var rvGame: RecyclerView
    private var list: ArrayList<Game> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvGame = findViewById(R.id.rv_game)
        rvGame.setHasFixedSize(true)

        list.addAll(GameData.listData)
        rvGame.layoutManager = LinearLayoutManager(this)
        val listBijuuAdapter = ListGameAdapter(list, this)
        rvGame.adapter = listBijuuAdapter
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.about -> {
                val about = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(about)
            }
        }
    }
}