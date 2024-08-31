package haxidenti.furrworld.world

data class Cell(val floorId: Int, val objectId: Int) {
    companion object {
        val VOID = Cell(0, 0)
    }
}