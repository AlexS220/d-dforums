package ie.wit.models

import android.util.Log

var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class GameMemStore : GameStore {

    val games = ArrayList<gameModel>()

    override fun findAll(): List<gameModel> {
        return games
    }

    override fun findById(id:Long) : gameModel? {
        val foundGame: gameModel? = games.find { it.id == id }
        return foundGame
    }

    override fun create(game: gameModel) {
        game.id = getId()
        games.add(game)
        logAll()
    }

    fun logAll() {
        Log.v("Systems:","** Games List **")
        games.forEach { Log.v("Donate","${it}") }
    }
}