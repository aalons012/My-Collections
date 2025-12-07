package edu.alonso.andy_collection

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


/**
 * The GameAdapter is a crucial component for the RecyclerView. Its job is to take a list of `Game` objects
 * and "adapt" them into views that can be displayed and recycled by the RecyclerView.
 *
 * @param games The list of Game objects that the adapter will display.
 */
class GameAdapter(private val games: List<Game>) : RecyclerView.Adapter<GameAdapter.GameViewHolder>() {

    // A property to hold a lambda function. This will be used to handle click events on items.
    // It's nullable, so it doesn't have to be set. The function takes a 'Game' object as a parameter.
    private var onItemClickListener: ((Game) -> Unit)? = null

    /**
     * This function is called by the RecyclerView when it needs a new ViewHolder to display an item.
     * It's responsible for creating and initializing the ViewHolder but NOT for populating it with data.
     *
     * @param parent The ViewGroup into which the new View will be added (this is the RecyclerView itself).
     * @param viewType An integer used if you have multiple types of views in your list (not used here).
     * @return A new GameViewHolder instance that holds the inflated view for a single list item.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        // The LayoutInflater takes an XML layout file and "inflates" it into a corresponding View object.
        val view = LayoutInflater.from(parent.context).inflate(R.layout.game_list_item, parent, false)
        // Creates a new ViewHolder instance, passing the inflated view to its constructor.
        return GameViewHolder(view)
    }

    /**
     * This function is called by the RecyclerView to bind data to a specific ViewHolder at a given position.
     * This is where you take the data from your list and put it into the views inside the ViewHolder.
     *
     * @param holder The ViewHolder that should be updated to represent the contents of the item at the given position.
     * @param position The position of the item within the adapter's data set.
     */
    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        // Get the specific Game object from the list based on its position.
        val game = games[position]
        // Set the text of the title TextView inside the ViewHolder to the game's title.
        holder.titleTextView.text = game.title
        // Set the text of the platform TextView inside the ViewHolder to the game's platform.
        holder.platformTextView.text = game.platform

        // Set a click listener on the entire item view (the card or row).
        holder.itemView.setOnClickListener {
            // When the item is clicked, invoke the onItemClickListener lambda (if it's not null),
            // passing the specific 'game' object associated with this ViewHolder.
            onItemClickListener?.invoke(game)
        }
    }

    /**
     * This function returns the total number of items in the data set held by the adapter.
     * The RecyclerView uses this to know how many items it needs to display.
     *
     * @return The size of the 'games' list.
     */
    override fun getItemCount() = games.size

    /**
     * A public function that allows the Activity or Fragment to set the click listener for the adapter.
     *
     * @param listener A lambda function that will be executed when an item is clicked.
     */
    fun setOnItemClickListener(listener: (Game) -> Unit) {
        onItemClickListener = listener
    }

    /**
     * The ViewHolder class describes an item view and metadata about its place within the RecyclerView.
     * It holds references to the individual views within a single list item layout (like TextViews),
     * so you don't have to repeatedly call `findViewById`.
     *
     * @param itemView The root view of a single list item (inflated from R.layout.game_list_item).
     */
    class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Initializes the TextView for the game title by finding it within the itemView.
        val titleTextView: TextView = itemView.findViewById(R.id.textViewGameTitle)
        // Initializes the TextView for the game platform by finding it within the itemView.
        val platformTextView: TextView = itemView.findViewById(R.id.textViewGamePlatform)
    }
}
