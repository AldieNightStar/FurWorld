package haxidenti.furrworld.script.parsing

private val SPACE = "\\S".toRegex()

object ScriptLexer {
    fun lex(s: String) = s.split(SPACE)
}