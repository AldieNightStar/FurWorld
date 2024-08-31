package haxidenti.furrworld.script

import haxidenti.furrworld.world.Player

interface Script {
    fun callOnTrigger(who: Player, x: Int, y: Int): Boolean
    fun callOnMove(who: Player, x: Int, y: Int): Boolean
    fun callOnPick(who: Player, x: Int, y: Int, item: Int): Boolean
    fun callOnPut(who: Player, x: Int, y: Int, item: Int): Boolean

    companion object {
        /**
         * Just a default script. Do whatever you want on the map
         */
        val DEFAULT = object : Script {
            override fun callOnTrigger(who: Player, x: Int, y: Int): Boolean = true
            override fun callOnMove(who: Player, x: Int, y: Int): Boolean = true
            override fun callOnPick(who: Player, x: Int, y: Int, item: Int): Boolean = true
            override fun callOnPut(who: Player, x: Int, y: Int, item: Int): Boolean = true
        }

        /**
         * Don't allow any actions to the map
         */
        val READONLY = object : Script {
            override fun callOnTrigger(who: Player, x: Int, y: Int): Boolean = false
            override fun callOnMove(who: Player, x: Int, y: Int): Boolean = true
            override fun callOnPick(who: Player, x: Int, y: Int, item: Int): Boolean = false
            override fun callOnPut(who: Player, x: Int, y: Int, item: Int): Boolean = false
        }
    }
}