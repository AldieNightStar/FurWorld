package haxidenti.furrworld.api

import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.JsonPrimitive
import haxidenti.furrworld.image.TextImage
import haxidenti.furrworld.world.*

val GSON = Gson()

object JsonMapper {
    fun placeToJson(place: Place) = ofObject {
        for (y in 0 until PLACE_SIZE) {
            for (x in 0 until PLACE_SIZE) {
                add("$x:$y", cellToJson(place.getCell(x, y)))
            }
        }
    }

    fun cellRegistryToJson(reg: CellRegistry) = ofObject {
        for ((id, info) in reg.all()) {
            add("$id", cellInfoToJson(info))
        }
    }

    fun cellInfoToJson(info: CellInfo) = ofObject {
        add("walkable", JsonPrimitive(info.walkable))
        add("triggerable", JsonPrimitive(info.triggerable))
        add("pickable", JsonPrimitive(info.pickable))
        add("image", JsonPrimitive(textImageToJson(info.image)))
    }

    fun textImageToJson(t: TextImage): String {
        val sb = StringBuilder()
        for (y in 0 until t.h) {
            for (x in 0 until t.w) {
                sb.append(t.pixelAt(x, y))
            }
            sb.append('\n')
        }
        return sb.toString()
    }

    fun cellToJson(cell: Cell) = ofArray {
        add(cell.floorId)
        add(cell.objectId)
    }

    private inline fun ofObject(f: JsonObject.() -> Unit) = JsonObject().also(f)
    private inline fun ofArray(f: JsonArray.() -> Unit) = JsonArray().also(f)
}