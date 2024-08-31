package haxidenti.furrworld

import io.javalin.Javalin
import io.javalin.http.staticfiles.Location

fun main() {
    endpoints().start(8080)
}

internal fun endpoints(): Javalin {
    return setup()
        .get("/test") { ctx -> ctx.result("OK") }
}

internal fun setup(): Javalin {
    return Javalin.create { config ->
        config.http.asyncTimeout = 10_000L
        config.staticFiles.add("./WEB", Location.EXTERNAL)
    }
}