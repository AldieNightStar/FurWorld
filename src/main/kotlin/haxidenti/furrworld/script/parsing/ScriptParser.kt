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
        // Args count determine how much arguments needed
        // If its -1 then until 'end' is met
        val argsCount = commandMap[command] ?: 0
        val args = mutableListOf<ParsedToken>()
        if (argsCount == -1) {
            while (true) {
                val subToken = parseIter(commandMap, iter) ?: break
                if (subToken.value == "end") break
                args.add(subToken)
            }
        } else {
            for (i in 0 until argsCount) {
                args.add(parseIter(commandMap, iter) ?: break)
            }
            return ParsedToken(command, args)
        }
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
    val value: String,
    val args: List<ParsedToken> = listOf(),
)