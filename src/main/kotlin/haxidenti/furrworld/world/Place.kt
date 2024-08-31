package haxidenti.furrworld.world

import haxidenti.furrworld.script.PlaceScript

const val PLACE_SIZE = 256

class Place(
    val registry: CellRegistry,
    val script: PlaceScript = PlaceScript.DEFAULT,
) {
    val data = Array(PLACE_SIZE) { Array(PLACE_SIZE) { Cell.VOID } }

    fun getCell(x: Int, y: Int): Cell {
        validatePos(x, y)
        return data[y][x]
    }

    fun setCell(x: Int, y: Int, cell: Cell) {
        validatePos(x, y)
        data[y][x] = cell
    }

    fun removeObject(x: Int, y: Int): Int {
        val oldCell = getCell(x, y)
        setCell(x, y, Cell(oldCell.floorId, 0))
        return oldCell.objectId
    }

    fun setObject(x: Int, y: Int, objectId: Int) {
        setCell(x, y, Cell(getCell(x, y).floorId, objectId))
    }

    fun isFree(x: Int, y: Int): Boolean {
        val cell = getCell(x, y)
        if (!cell.floorInfo(registry).walkable) return false
        if (cell.objectId > 0) return false
        return true
    }

    fun isWalkable(x: Int, y: Int): Boolean {
        val floorOk = getCell(x, y).floorInfo(registry).walkable
        val objectOk = getCell(x, y).objectInfo(registry).walkable
        return floorOk && objectOk
    }

    fun isTriggerable(x: Int, y: Int): Boolean {
        val floorOk = getCell(x, y).floorInfo(registry).triggerable
        val objectOk = getCell(x, y).objectInfo(registry).triggerable
        return floorOk || objectOk
    }

    fun isPickable(x: Int, y: Int): Boolean {
        return getCell(x, y).objectInfo(registry).triggerable
    }

    private fun validatePos(x: Int, y: Int) {
        if (x < 0 || y < 0 || x >= PLACE_SIZE || y >= PLACE_SIZE)
            throw RuntimeException("Cell position in the Place is out of range: $PLACE_SIZE")
    }
}
