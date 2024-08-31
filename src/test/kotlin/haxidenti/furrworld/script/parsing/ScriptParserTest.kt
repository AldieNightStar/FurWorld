package haxidenti.furrworld.script.parsing

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import javax.swing.text.html.parser.Parser

class ScriptParserTest {
    @Test
    fun testGatherNesting() {

        val testData = "position at 5 10 center".split(" ")

        val parsed = ScriptParser.parse(mapOf(
            "position" to 2,
            "at" to 2
        ), testData)

        assertEquals(1, parsed.size)
        assertEquals("position", parsed[0].name)
        assertEquals(2, parsed[0].args.size)
        assertEquals("at", parsed[0].args[0].name)
        assertEquals("center", parsed[0].args[1].name)

    }
}