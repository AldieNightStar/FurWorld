package haxidenti.furrworld.script

import haxidenti.furrworld.world.Place
import haxidenti.furrworld.player.Player

interface Script {
    fun callOnTrigger(place: Place, who: Player, x: Int, y: Int): Boolean
    fun callOnMove(place: Place, who: Player, x: Int, y: Int): Boolean
    fun callOnPick(place: Place, who: Player, x: Int, y: Int, item: Int): Boolean
    fun callOnPut(place: Place, who: Player, x: Int, y: Int, item: Int): Boolean

    companion object {
        /**
         * Just a default script. Do whatever you want on the map
         */
        val DEFAULT = object : Script {
            override fun callOnTrigger(place: Place, who: Player, x: Int, y: Int): Boolean = true
            override fun callOnMove(place: Place, who: Player, x: Int, y: Int): Boolean = true
            override fun callOnPick(place: Place, who: Player, x: Int, y: Int, item: Int): Boolean = true
            override fun callOnPut(place: Place, who: Player, x: Int, y: Int, item: Int): Boolean = true
        }

        /**
         * Don't allow any actions to the map
         */
        val READONLY = object : Script {
            override fun callOnTrigger(place: Place, who: Player, x: Int, y: Int): Boolean = false
            override fun callOnMove(place: Place, who: Player, x: Int, y: Int): Boolean = true
            override fun callOnPick(place: Place, who: Player, x: Int, y: Int, item: Int): Boolean = false
            override fun callOnPut(place: Place, who: Player, x: Int, y: Int, item: Int): Boolean = false
        }
    }
}