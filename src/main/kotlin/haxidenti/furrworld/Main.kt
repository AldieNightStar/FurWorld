package haxidenti.furrworld

import haxidenti.furrworld.api.PlaceController
import haxidenti.furrworld.image.TextImage
import haxidenti.furrworld.util.for2d
import haxidenti.furrworld.world.*
import io.javalin.Javalin
import io.javalin.http.staticfiles.Location
import kotlin.random.Random

fun main() {
    val reg = CellRegistry()

    // Testing cell
    reg.register(
        1,
        CellInfo(
            walkable = true,
            triggerable = false,
            pickable = false,
            image = TextImage(16, 16)
        )
    )

    // Testing place
    val place = Place(reg)

    // Spawn random tiles
    for2d(PLACE_SIZE, PLACE_SIZE) { x, y ->
        place.setCell(x, y, Cell(Random.nextInt(32), Random.nextInt(32)))
    }

    val placeMap = PlaceMap()
    placeMap.places["Start"] = place

    serveGame(placeMap)
}

internal fun serveGame(places: PlaceMap) {
    val j = setup()
    PlaceController(places).serve(j)
    j.start(8080)
}

internal fun setup(): Javalin {
    return Javalin.create { config ->
        config.http.asyncTimeout = 10_000L
        config.staticFiles.add("./WEB", Location.EXTERNAL)
    }
}