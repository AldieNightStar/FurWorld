package haxidenti.furrworld.script

import haxidenti.furrworld.world.Player

interface Script {
    fun callOnTrigger(who: Player, x: Int, y: Int): Boolean
    fun callOnMove(who: Player, x: Int, y: Int): Boolean
    fun callOnPick(who: Player, x: Int, y: Int, item: Int): Boolean
    fun callOnPut(who: Player, x: Int, y: Int, item: Int): Boolean

    companion object {
        val DEFAULT = object : Script {
            override fun callOnTrigger(who: Player, x: Int, y: Int): Boolean = true
            override fun callOnMove(who: Player, x: Int, y: Int): Boolean = true
            override fun callOnPick(who: Player, x: Int, y: Int, item: Int): Boolean = true
            override fun callOnPut(who: Player, x: Int, y: Int, item: Int): Boolean = true
        }
    }
}