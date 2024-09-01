package haxidenti.furrworld.world

class PlaceMap {
    val places = mutableMapOf<String, Place>()

    operator fun get(name: String): Place {
        return places[name] ?: throw RuntimeException("No such place: $name")
    }
}