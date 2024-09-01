package haxidenti.furrworld.api.mapper

import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject

val GSON = Gson()

object JsonMapper {
    private inline fun ofObject(f: JsonObject.() -> Unit) = JsonObject().also(f)
    private inline fun ofArray(f: JsonArray.() -> Unit) = JsonArray().also(f)
}