package haxidenti.furrworld.script.parsing

private val SPACE = "\\s".toRegex()

object ScriptLexer {
    fun lex(s: String) = s.split(SPACE).filter { it.isNotEmpty() }
}