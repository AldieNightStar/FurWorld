package haxidenti.furrworld.script.parsing

object ScriptParser {
    fun parse(commandMap: Map<String, Int>, tokens: List<String>) = buildList {
        val iter = tokens.iterator()
        while (true) {
            add(parseIter(commandMap, iter) ?: break)
        }
    }

    private fun parseIter(commandMap: Map<String, Int>, iter: Iterator<String>): ParsedToken? {
        val command = iter.poll() ?: return null
        val argsCount = commandMap[command] ?: 0
        val args = (0 until argsCount).mapNotNull { parseIter(commandMap, iter) }
        return ParsedToken(command, args)
    }

    private fun Iterator<String>.poll(): String? {
        if (this.hasNext()) {
            return this.next()
        } else {
            return null
        }
    }
}

data class ParsedToken(
    val name: String,
    val args: List<ParsedToken> = listOf()
)