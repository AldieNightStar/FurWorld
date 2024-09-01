package haxidenti.furrworld.world

import haxidenti.furrworld.image.ByteImage

class CellRegistry {
    private val map = mutableMapOf<Short, CellInfo>()

    fun register(id: Short, info: CellInfo) {
        map[id] = info
    }

    fun info(id: Short): CellInfo {
        return map[id] ?: CellInfo.DEFAULT
    }

    fun all() = map.entries

    val size get() = map.size
}

class CellInfo(
    val walkable: Boolean,
    val triggerable: Boolean,
    val pickable: Boolean,
    val image: ByteImage,
) {
    companion object {
        val DEFAULT = CellInfo(
            walkable = true,
            triggerable = false,
            pickable = false,
            image = ByteImage.EMPTY
        )
    }
}