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
        val intent = Intent(this, console_gamecube_collection::class.java)
        startActivity(intent)
    }
    fun onClickPC(view: View) {}
    fun onClickPS(view: View) {}
    fun onClickDS(view: View) {}
}