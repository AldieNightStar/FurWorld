package haxidenti.furrworld.world

val CHUNK_SIZE = 32

class Chunk {
    val data = Array(CHUNK_SIZE) { Array(CHUNK_SIZE) { Cell.VOID } }

    fun getAt(x: Int, y: Int): Cell {
        if (x < 0 || x >= CHUNK_SIZE || y < 0 || y >= CHUNK_SIZE) return Cell.VOID
        return data[y][x]
    }

    fun setAt(x: Int, y: Int, cell: Cell): Boolean {
        if (x < 0 || x >= CHUNK_SIZE || y < 0 || y >= CHUNK_SIZE) return false
        data[y][x] = cell
        return true
    }
}