package haxidenti.furrworld.api

import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import haxidenti.furrworld.world.Cell

val GSON = Gson()

object JsonMapper {
    fun cellToJson(cell: Cell) = ofArray {
        add(cell.floorId)
        add(cell.objectId)
    }

    private inline fun ofObject(f: JsonObject.() -> Unit) = JsonObject().also(f)
    private inline fun ofArray(f: JsonArray.() -> Unit) = JsonArray().also(f)
}