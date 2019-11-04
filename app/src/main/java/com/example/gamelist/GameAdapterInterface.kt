package com.example.gamelist

interface GameAdapterInterface {
    val games : Array<Game>
    fun open(game: Game)

}