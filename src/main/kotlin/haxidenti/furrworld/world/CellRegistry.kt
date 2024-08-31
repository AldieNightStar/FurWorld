package haxidenti.furrworld.world

class CellRegistry {
    private val map = mutableMapOf<Int, CellInfo>()

    fun register(id: Int, info: CellInfo) {
        map[id] = info
    }

    fun info(id: Int): CellInfo {
        return map[id] ?: CellInfo.DEFAULT
    }
}

class CellInfo(
    val walkable: Boolean,
    val triggerable: Boolean,
    val pickable: Boolean,
) {
    companion object {
        val DEFAULT = CellInfo(
            walkable = true,
            triggerable = false,
            pickable = false
        )
    }
}