package ie.wit.models

interface GameStore {
    fun findAll(): List<gameModel>
    fun findById(id: Long): gameModel?
    fun create(game: gameModel)
}