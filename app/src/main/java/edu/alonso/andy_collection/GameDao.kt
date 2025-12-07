package edu.alonso.andy_collection

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/**
 * @Dao annotation marks this interface as a Data Access Object.
 * DAOs are the main component of Room and are responsible for defining the methods
 * that access the database. Instead of writing query boilerplate, you just define
 * the functions and annotate them with Room annotations.
 */
@Dao
interface GameDao {

    /**
     * @Query annotation means this method performs a read/write operation defined by the SQL query.
     * This specific query selects all columns (*) from the 'games' table and returns them
     * as a list of Game objects. The results are ordered alphabetically by the 'title' column.
     *
     * @return A List of all Game objects currently in the database.
     */
    @Query("SELECT * FROM games ORDER BY title")
    fun getAllGames(): List<Game>

    /**
     * This query counts the total number of rows in the 'games' table.
     * It's a convenient way to check if the database has any data in it.
     *
     * @return An integer representing the total number of games in the database.
     */
    @Query("SELECT COUNT(*) FROM games")
    fun getGameCount(): Int

    /**
     * @Insert annotation marks this method for inserting data into the database.
     * Room will generate the necessary code to insert all the provided Game objects
     * into the 'games' table in a single transaction.
     *
     * @param games A list of Game objects to be inserted into the database.
     */
    @Insert
    fun insertGames(games: List<Game>)
}
