package edu.alonso.andy_collection

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ds_collection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ds_collection)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun onClickPokemonPt(view: View) {
        
    }
    fun onClickpvz(view: View) {

    }
    fun onClickPMzD(view: View) {

    }
    fun onClickWhite(view: View) {

    }
    fun onClickBlack(view: View) {

    }
    fun onClickBack(view: View) {
        finish()
    }
}