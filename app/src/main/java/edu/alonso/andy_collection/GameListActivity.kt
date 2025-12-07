package edu.alonso.andy_collection

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import edu.alonso.andy_collection.databinding.ActivityGamesListBinding

/**
 * This Activity is responsible for displaying a list of games from the database.
 * It uses a RecyclerView to efficiently display the list and allows users to tap on a game
 * to see its details. It also handles adding some default games if the database is empty.
 */
class GameListActivity : AppCompatActivity() {

    // A lateinit property for view binding. This allows for safe and easy access to the views
    // defined in the activity_games_list.xml layout file without using findViewById.
    private lateinit var binding: ActivityGamesListBinding

    // A lateinit property for the Data Access Object (DAO) for the Game entity.
    // The DAO provides methods to interact with the 'games' table in the Room database.
    private lateinit var gameDao: GameDao

    /**
     * This function is called when the activity is first created. It's where the main
     * setup logic for the UI and data is handled.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflates the layout XML file into a binding object for easy view access.
        binding = ActivityGamesListBinding.inflate(layoutInflater)
        // Sets the root view of the binding object as the content view for this activity.
        setContentView(binding.root)

        // Sets the title displayed in the action bar for this activity.
        title = "My Collections - Games"

        // Gets a reference to the activity's action bar.
        val actionBar: ActionBar? = supportActionBar
        // Enables the "Up" button (the back arrow) in the action bar, allowing for easy navigation.
        actionBar?.setDisplayHomeAsUpEnabled(true)

        // Initializes the gameDao by getting a reference to the Room database instance.
        gameDao = GameDatabase.getDatabase(this).gameDao()

        // Checks if the database is empty by querying the number of games.
        if (gameDao.getGameCount() == 0) {
            // If the database is empty, it inserts a predefined list of default games.
            gameDao.insertGames(getDefaultGames())
        }

        // Retrieves all games from the database to display them.
        val gameList = gameDao.getAllGames()
        // Creates an instance of the GameAdapter, passing the list of games to it.
        val gameAdapter = GameAdapter(gameList)

        // Sets a click listener on the adapter. This code block will run when a user taps on any item in the RecyclerView.
        gameAdapter.setOnItemClickListener { game ->
            // Creates an Intent to navigate from this activity to the GameDetailActivity.
            val intent = Intent(this, GameDetailActivity::class.java).apply {
                // 'apply' allows us to conveniently add extra data (extras) to the intent.
                // We pass the title, platform, and description of the clicked game to the next activity.
                putExtra("title", game.title)
                putExtra("platform", game.platform)
                putExtra("description", game.description)
            }
            // Starts the GameDetailActivity with the prepared intent.
            startActivity(intent)
        }

        // Configures the RecyclerView using the binding object.
        binding.recyclerViewGames.apply {
            // Sets the layout manager, which determines how items are arranged.
            // LinearLayoutManager arranges items in a vertical list, one after the other.
            layoutManager = LinearLayoutManager(this@GameListActivity)
            // Attaches the adapter to the RecyclerView to populate it with data and manage its views.
            adapter = gameAdapter
        }

        // Sets an OnClickListener for the 'Back to Main' button.
        binding.btnBackToMain.setOnClickListener {
            // 'finish()' closes the current activity and returns the user to the previous one on the back stack (MainActivity).
            finish()
        }
    }

    /**
     * Creates and returns a hardcoded list of default Game objects.
     * This is used to populate the database with initial data the first time the app is run.
     */
    private fun getDefaultGames(): List<Game> {
        return listOf(
            Game(title = "Elden Ring", platform = "PS5", description = "Open world action RPG with tough bosses."),
            Game(title = "Astro’s Playroom", platform = "PS5", description = "Platformer that shows off the DualSense."),
            Game(title = "Stray", platform = "PS5", description = "Adventure game where you are a cat in a cyber city."),
            Game(title = "Mario Kart 8 Deluxe", platform = "Switch", description = "Colorful arcade kart racing game."),
            Game(title = "The Legend of Zelda: BOTW", platform = "Switch", description = "Exploration-focused open world adventure.")
        )
    }

    /**
     * This function is called when a menu item in the action bar is selected.
     * It's used here to handle clicks on the "Up" button (the back arrow).
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Checks if the selected item's ID is the standard Android "home" ID (which corresponds to the Up button).
        return if (item.itemId == android.R.id.home) {
            // If it is, trigger the system's back press behavior, which is the same as pressing the back button.
            onBackPressedDispatcher.onBackPressed()
            // Return true to indicate that the event has been handled.
            true
        } else {
            // If it's not the Up button, let the default system behavior handle it.
            super.onOptionsItemSelected(item)
        }
    }
}

