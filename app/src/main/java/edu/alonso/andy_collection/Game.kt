package edu.alonso.andy_collection

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "games")
data class Game(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val title: String,
    val platform: String,
    val description: String
)
