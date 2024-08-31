package haxidenti.furrworld.script.parsing

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ScriptLexerTest {
    @Test
    fun lexTest() {
        val tokens = ScriptLexer.lex("a b \n c")

        assertEquals(3, tokens.size)
        assertEquals("a", tokens[0])
        assertEquals("b", tokens[1])
        assertEquals("c", tokens[2])
    }
}