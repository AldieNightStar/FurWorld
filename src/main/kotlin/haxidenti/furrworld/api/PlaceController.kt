package haxidenti.furrworld.api

import haxidenti.furrworld.api.mapper.BinaryMapper
import haxidenti.furrworld.world.PlaceMap
import io.javalin.Javalin
import io.javalin.http.Context

class PlaceController(
    val placeMap: PlaceMap,
) {
    fun serve(j: Javalin) {
        j.get("/api/place/{name}", ::getPlace)
        j.get("/api/place/{name}/cells", ::getCells)
    }

    fun getPlace(c: Context) {
        val place = placeMap[c.pathParam("name")]
        c.result(BinaryMapper.place(place))
    }

    fun getCells(c: Context) {
        val place = placeMap[c.pathParam("name")]
        c.result(BinaryMapper.cellRegistry(place.registry))
    }
}