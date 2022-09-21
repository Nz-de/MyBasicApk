package com.aproduction.myapplist1

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvName: TextView = findViewById(R.id.game_name)
        val tvDetails: TextView = findViewById(R.id.game_desc)
        val tvPhoto: ImageView = findViewById(R.id.game_photo)

        val gameName = intent.getStringExtra("mName")
        val gameDetail = intent.getStringExtra("mDetail")
       // val gameDescription = intent.getStringExtra("mDescription")
        val gamePhoto = intent.getIntExtra("mPhoto", 1)
        // val bijuuBg = intent.getIntExtra("mBg", 1)

        tvName.text = gameName
        tvDetails.text = gameDetail
       // tvDescription.text = gameDescription
        tvPhoto.setImageResource(gamePhoto)
        //tvBg.setImageResource(bijuuBg)


//        favButton.setOnClickListener{
//            Toast.makeText(this, "Add To Favorite", Toast.LENGTH_SHORT).show()


        }
    }