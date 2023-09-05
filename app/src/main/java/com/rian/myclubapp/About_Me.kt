package com.rian.myclubapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class About_Me : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me)

        val back: ImageView = findViewById(R.id.btn_back)
        back.setOnClickListener {
            finish()
        }
    }
}