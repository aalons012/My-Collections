package edu.alonso.andy_collection

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ps5_collection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ps5_collection)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun onClickElden(view: View) {
        startActivity(Intent(this, EldenRing::class.java))
    }
    fun onClickFFXVI(view: View) {
        startActivity(Intent(this, Final_Fantasy::class.java))
    }
    fun onClickStray(view: View) {
        startActivity(Intent(this, Stray::class.java))
    }
    fun onClickABot(view: View) {
        startActivity(Intent(this, Astro::class.java))
    }

    fun onClickBack(view: View) {
        finish()

    }
}