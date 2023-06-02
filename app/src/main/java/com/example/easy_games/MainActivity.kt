package com.example.easy_games

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var btnRPS : Button
    lateinit var btnXox: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRPS = findViewById(R.id.btnRPS)
        btnXox = findViewById(R.id.btnXox)


        btnXox.setOnClickListener(){
            var intent = Intent(this, Xox::class.java)
            startActivity(intent)
        }

        btnRPS.setOnClickListener(){
            var intent = Intent(this, RPS::class.java)
            startActivity(intent)
        }



    }
}