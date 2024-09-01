package haxidenti.furrworld.image


class TextImage(val w: Int, val h: Int) {
    val data = Array(h) { Array(w) { ' ' } }

    private fun validatePos(x: Int, y: Int) {
        if (x < 0 || y < 0 || x >= w || y >= h)
            throw RuntimeException("Invalid position $x,$y for size $w,$h")
    }

    fun pixelAt(x: Int, y: Int): Char {
        validatePos(x, y)
        return data[y][x]
    }

    fun setPixelAt(x: Int, y: Int, c: Char) {
        validatePos(x, y)
        data[y][x] = c
    }

    companion object {
        val EMPTY = TextImage(0, 0)
    }
}