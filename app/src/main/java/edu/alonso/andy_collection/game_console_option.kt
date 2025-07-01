package edu.alonso.andy_collection

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class game_console_option : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_consoles_game_options)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }



    fun onClickBack(view: View) {
        finish()
    }

    fun onClickGamecube(view: View) {
        val intent = Intent(this, gamecube_collection::class.java)
        startActivity(intent)
    }
    fun onClickPC(view: View) {
        val intent = Intent(this, Steam_Collection::class.java)
        startActivity(intent)
    }
    fun onClickPS(view: View) {
        val intent = Intent(this, ps5_collection::class.java)
        startActivity(intent)
    }
    fun onClickDS(view: View) {
        val intent = Intent(this, ds_collection::class.java)
        startActivity(intent)
    }
}