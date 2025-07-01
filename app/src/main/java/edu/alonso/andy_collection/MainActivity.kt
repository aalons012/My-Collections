/**
 * BY Andy Alonso
 * Project started in 6/25/2024
 */
package edu.alonso.andy_collection

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun onClickConsoles(view: View) {
        startActivity(Intent(this, console_collection::class.java))
        startActivity(intent)

    }
    fun onClickGames(view: View) {
        startActivity(Intent(this, game_console_option::class.java))
        startActivity(intent)
    }
    fun onClickAbout(view: View) {
        startActivity(Intent(this, About::class.java))
        startActivity(intent)
    }
}