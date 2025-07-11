package edu.alonso.andy_collection

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class gamecube_collection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_gamecube_collection)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun onClickPokemon(view: View) {
        startActivity(Intent(this, Pokemon_XD::class.java))
    }
    fun onClickssbm(view: View) {
        startActivity(Intent(this, Melee::class.java))
    }
    fun onClickX(view: View) {
        startActivity(Intent(this, WWF::class.java))
    }
    fun onClickMkdd(view: View) {
        startActivity(Intent(this, MarioKart::class.java))
    }
    fun onClickZelda(view: View) {
        startActivity(Intent(this, Zelda::class.java))
    }
    fun onClickBack(view: View) {
        finish()

    }
}