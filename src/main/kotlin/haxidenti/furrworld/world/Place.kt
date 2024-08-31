package haxidenti.furrworld.world

val PLACE_CHUNKS_COUNT = 16

class Place {
    val chunks = Array(PLACE_CHUNKS_COUNT) { Array(PLACE_CHUNKS_COUNT) { Chunk() } }

    private fun validateChunkPos(x: Int, y: Int) {
        if (x < 0 || y < 0 || x >= PLACE_CHUNKS_COUNT || y >= PLACE_CHUNKS_COUNT)
            throw RuntimeException("Chunk is out of range: $PLACE_CHUNKS_COUNT")
    }

    private fun validatePos(x: Int, y: Int) {
        val size = size()
        if (x < 0 || y < 0 || x >= size || y >= size)
            throw RuntimeException("Cell position in the Place is out of range: $size")
    }

    fun chunkAt(x: Int, y: Int): Chunk {
        validateChunkPos(x, y)
        return chunks[y][x]
    }

    fun getCell(x: Int, y: Int): Cell {
        validatePos(x, y)
        val cx = x / PLACE_CHUNKS_COUNT
        val cy = y / PLACE_CHUNKS_COUNT
        return chunkAt(cx, cy).getAt(x % PLACE_CHUNKS_COUNT, y % PLACE_CHUNKS_COUNT)
    }

    fun setCell(x: Int, y: Int, cell: Cell): Boolean {
        validatePos(x, y)
        val cx = x / PLACE_CHUNKS_COUNT
        val cy = y / PLACE_CHUNKS_COUNT
        return chunkAt(cx, cy).setAt(x % PLACE_CHUNKS_COUNT, y % PLACE_CHUNKS_COUNT, cell)
    }

    fun size(): Int {
        return PLACE_CHUNKS_COUNT * CHUNK_SIZE
    }
}