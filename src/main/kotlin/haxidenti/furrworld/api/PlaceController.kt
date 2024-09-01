package haxidenti.furrworld.api

import haxidenti.furrworld.world.PlaceMap
import io.javalin.Javalin
import io.javalin.http.Context

class PlaceController(
    val placeMap: PlaceMap,
) {
    fun serve(j: Javalin) {
        j.get("/api/place/{name}", ::getPlace)
        j.get("/api/place/{name}/cellImages", ::getPlaceCellImages)
    }

    fun getPlace(c: Context) {
        val place = placeMap[c.pathParam("name")]
        c.result(BinaryMapper.placeToBinary(place))
    }

    fun getPlaceCellImages(c: Context) {
        val place = placeMap[c.pathParam("name")]
        c.result(JsonMapper.cellRegistryToJson(place.registry).toString())
    }
}