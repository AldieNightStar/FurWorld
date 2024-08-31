package haxidenti.furrworld.script.parsing

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ScriptParserTest {
    @Test
    fun testGatherNesting() {
        val testData = "position at 5 10 center xxx".split(" ")

        val parsed = ScriptParser.parse(mapOf(
            "position" to 2,
            "at" to 2
        ), testData)

        assertEquals(2, parsed.size)
        assertEquals("position", parsed[0].name)
        assertEquals(2, parsed[0].args.size)
        assertEquals("at", parsed[0].args[0].name)
        assertEquals("center", parsed[0].args[1].name)
    }

    @Test
    fun testNestingBlocks() {
        val testData = "code a b code 22 33 44 end end 1".split(" ")

        val parsed = ScriptParser.parse(mapOf(
            "code" to -1,
        ), testData)

        assertEquals(2, parsed.size)
        assertEquals("code", parsed[0].name)
        assertEquals("1", parsed[1].name)
    }
}