package haxidenti.furrworld.world

import haxidenti.furrworld.api.exception.GameException

class PlaceMap {
    val places = mutableMapOf<String, Place>()

    operator fun get(name: String): Place {
        return places[name] ?: throw GameException("No such place: $name")
    }
}