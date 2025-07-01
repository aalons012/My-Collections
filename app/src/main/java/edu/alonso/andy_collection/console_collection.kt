package edu.alonso.andy_collection

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class console_collection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_console_collection)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun onClickWii(view: View) {
        startActivity(Intent(this, wii::class.java))
    }

    fun onClickPS(view: View) {

    }
    fun onClickSwitch(view: View) {
        startActivity(Intent(this, Switch2::class.java))
    }
    fun onClickSteamdeck(view: View) {
        startActivity(Intent(this, SteamDeck::class.java))
    }
    fun onClickGamecube(view: View) {
        startActivity(Intent(this, gamecube::class.java))
    }

    fun onClickBack(view: View) {
        finish()
    }

}