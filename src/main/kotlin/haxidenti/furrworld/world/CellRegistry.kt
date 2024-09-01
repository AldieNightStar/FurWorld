package haxidenti.furrworld.world

import haxidenti.furrworld.image.TextImage

class CellRegistry {
    private val map = mutableMapOf<Int, CellInfo>()

    fun register(id: Int, info: CellInfo) {
        map[id] = info
    }

    fun info(id: Int): CellInfo {
        return map[id] ?: CellInfo.DEFAULT
    }

    fun all() = map.entries
}

class CellInfo(
    val walkable: Boolean,
    val triggerable: Boolean,
    val pickable: Boolean,
    val image: TextImage,
) {
    companion object {
        val DEFAULT = CellInfo(
            walkable = true,
            triggerable = false,
            pickable = false,
            image = TextImage.EMPTY
        )
    }
}