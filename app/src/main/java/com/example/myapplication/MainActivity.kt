package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.button)
        button
            .setOnClickListener { sayHi() }
    }

    private fun sayHi() {
        Toast.makeText(
             this, "Hello Class!",
            Toast.LENGTH_SHORT).show()
    }


}