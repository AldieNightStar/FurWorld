package haxidenti.furrworld.world

data class Cell(val floorId: Int, val objectId: Int) {
    companion object {
        val VOID = Cell(0, 0)
    }

    fun objectInfo(reg: CellRegistry): CellInfo {
        return reg.info(objectId)
    }

    fun floorInfo(reg: CellRegistry): CellInfo {
        return reg.info(floorId)
    }
}