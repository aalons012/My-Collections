package edu.alonso.andy_collection

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import edu.alonso.andy_collection.databinding.ActivityGameDetailBinding

class GameDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            binding = ActivityGameDetailBinding.inflate(layoutInflater)
            setContentView(binding.root)

            title = "Game Details"

            val actionBar: ActionBar? = supportActionBar
            actionBar?.setDisplayHomeAsUpEnabled(true)

            val title = intent.getStringExtra("title") ?: "No Title"
            val platform = intent.getStringExtra("platform") ?: "No Platform"
            val description = intent.getStringExtra("description") ?: "No Description"

            binding.txtGameTitle.text = title
            binding.txtGamePlatform.text = "Platform: $platform"
            binding.txtGameDescription.text = description

            binding.btnBackToList.setOnClickListener {
                finish()
            }
        } catch (e: Exception) {
            Log.e("GameDetailActivity", "Error in onCreate", e)
            throw e // Re-throw the exception to ensure the app still crashes and the error is visible
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == android.R.id.home) {
            onBackPressedDispatcher.onBackPressed()
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }
}
