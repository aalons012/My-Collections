/**
 * BY Andy Alonso
 * Project started in 6/25/2024 (Version 1)
 *
 * Version 2
 * Started in 12/4/2025
 *
 */
package edu.alonso.andy_collection

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/**
 * MainActivity is the first screen the user sees when they launch the application.
 * It serves as the main menu, providing navigation to different sections of the app.
 */
class MainActivity : AppCompatActivity() {

    /**
     * This function is called when the activity is first created.
     * It's where you initialize the UI and set up listeners.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        // Calls the parent class's onCreate method to handle basic setup.
        super.onCreate(savedInstanceState)

        // Enables the app to draw its layout edge-to-edge, behind the system bars (status and navigation bars).
        // This creates a more modern, immersive look.
        enableEdgeToEdge()

        // Sets the user interface for this activity from an XML layout file named "activity_main".
        setContentView(R.layout.activity_main)

        // This listener is crucial for handling the edge-to-edge display.
        // It listens for "window insets," which are the spaces taken up by the system bars.
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            // Gets the pixel dimensions of the status bar (top) and navigation bar (bottom).
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            // Applies padding to the main view (the root layout, R.id.main) that is equal to the size
            // of the system bars. This prevents UI elements from being hidden underneath them.
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)

            // Returns the insets to allow the system to continue processing them.
            insets
        }

        // Programmatically sets the click listener for the "Games" button.
        val gamesButton: Button = findViewById(R.id.games)
        gamesButton.setOnClickListener {
            // Creates an Intent to start the 'GamesListActivity' and starts it.
            val intent = Intent(this, GameListActivity::class.java)
            startActivity(intent)
        }
    }

    /**
     * This function is called when the "Consoles" button is clicked in the layout (defined by android:onClick).
     * It intends to navigate the user to the console collection screen.
     */
    fun onClickConsoles(view: View) {
        // Creates an Intent to start the 'console_collection' activity.
        startActivity(Intent(this, console_collection::class.java))

        // WARNING: This second line is redundant and likely a bug.
        // It tries to restart the current activity (MainActivity) with its original intent.
        // This line should probably be removed.
        startActivity(intent)
    }

    /**
     * This function is called when the "About" button is clicked in the layout.
     * It intends to navigate the user to the "About" screen.
     */
    fun onClickAbout(view: View) {
        // Creates an Intent to start the 'About' activity.
        startActivity(Intent(this, About::class.java))

        // WARNING: This second line is also redundant and likely a bug.
        // It restarts MainActivity and should likely be removed.
        startActivity(intent)
    }
}
