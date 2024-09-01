package haxidenti.furrworld.api.exception

import io.javalin.http.HttpResponseException

class GameException(message: String ) : HttpResponseException(400, message)