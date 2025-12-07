package edu.alonso.andy_collection

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * This annotation marks the class as a Room database.
 * @param entities An array of all the entity classes (tables) that are part of this database. Here, it's just the 'Game' table.
 * @param version The version number of the database. This is important for handling database migrations in the future.
 * @param exportSchema If set to true, Room exports the database's schema into a JSON file in the project.
 *                     It's good practice for version control but set to false here for simplicity.
 */
@Database(entities = [Game::class], version = 1, exportSchema = false)
abstract class GameDatabase : RoomDatabase() {

    /**
     * An abstract function that returns an instance of the GameDao (Data Access Object).
     * Room will automatically generate the implementation for this method, providing a way
     * to interact with the 'Game' table.
     */
    abstract fun gameDao(): GameDao

    /**
     * The companion object allows us to define static methods and properties for the class.
     * This is used to implement the Singleton pattern, ensuring only one instance of the
     * database exists at any given time to prevent memory leaks and race conditions.
     */
    companion object {
        /**
         * @Volatile annotation ensures that the INSTANCE variable is always up-to-date and the same
         * to all execution threads. It makes sure that changes made by one thread are immediately
         * visible to all other threads.
         */
        @Volatile
        private var INSTANCE: GameDatabase? = null

        /**
         * A static method to get the singleton instance of the database.
         * @param context The application context, needed to create the database instance.
         * @return The singleton GameDatabase instance.
         */
        fun getDatabase(context: Context): GameDatabase {
            // The elvis operator (?:) checks if INSTANCE is null.
            // If it's not null, it returns the existing instance.
            // If it is null, it executes the synchronized block to create the instance.
            return INSTANCE ?: synchronized(this) {
                // The synchronized block ensures that only one thread can execute this code at a time,
                // preventing multiple database instances from being created simultaneously.

                // Uses Room's databaseBuilder to create a new database instance.
                val instance = Room.databaseBuilder(
                    context.applicationContext, // Use the application context to prevent memory leaks.
                    GameDatabase::class.java,   // The database class.
                    "my_collections_db"         // The name of the actual database file on the device.
                )
                    // This line allows database queries to be run on the main UI thread.
                    // WARNING: This is generally a bad practice as it can freeze the UI.
                    // It is used here for simplicity in a small project, but for a real app,
                    // you should use coroutines or another background threading solution.
                    .allowMainThreadQueries()
                    .build() // Finalizes the database creation.

                // Assign the newly created instance to the static INSTANCE variable.
                INSTANCE = instance

                // Return the instance. This value will also be returned by the synchronized block.
                instance
            }
        }
    }
}
