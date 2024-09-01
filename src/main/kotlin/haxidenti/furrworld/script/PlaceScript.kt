package haxidenti.furrworld.script

import haxidenti.furrworld.world.Place
import haxidenti.furrworld.player.Player

interface PlaceScript {
    fun callOnTrigger(place: Place, who: Player, x: Int, y: Int): Boolean
    fun callOnMove(place: Place, who: Player, x: Int, y: Int): Boolean
    fun callOnPick(place: Place, who: Player, x: Int, y: Int, item: Int): Boolean
    fun callOnPut(place: Place, who: Player, x: Int, y: Int, item: Int): Boolean
    fun getSourceCode(): String

    companion object {
        /**
         * Just a default script. Do whatever you want on the map
         */
        val DEFAULT = object : PlaceScript {
            override fun callOnTrigger(place: Place, who: Player, x: Int, y: Int): Boolean = true
            override fun callOnMove(place: Place, who: Player, x: Int, y: Int): Boolean = true
            override fun callOnPick(place: Place, who: Player, x: Int, y: Int, item: Int): Boolean = true
            override fun callOnPut(place: Place, who: Player, x: Int, y: Int, item: Int): Boolean = true
            override fun getSourceCode() = ""
        }

        /**
         * Don't allow any actions to the map
         */
        val READONLY = object : PlaceScript {
            override fun callOnTrigger(place: Place, who: Player, x: Int, y: Int): Boolean = false
            override fun callOnMove(place: Place, who: Player, x: Int, y: Int): Boolean = true
            override fun callOnPick(place: Place, who: Player, x: Int, y: Int, item: Int): Boolean = false
            override fun callOnPut(place: Place, who: Player, x: Int, y: Int, item: Int): Boolean = false
            override fun getSourceCode() = ""
        }
    }
}