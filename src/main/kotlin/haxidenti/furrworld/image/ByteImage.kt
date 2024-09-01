package haxidenti.furrworld.image

import haxidenti.furrworld.api.exception.GameException


val BYTE_IMAGE_SIZE = 16

class ByteImage {
    val data = Array(BYTE_IMAGE_SIZE) { Array(BYTE_IMAGE_SIZE) { 0.toByte() } }

    private fun validatePos(x: Int, y: Int) {
        if (x < 0 || y < 0 || x >= BYTE_IMAGE_SIZE || y >= BYTE_IMAGE_SIZE)
            throw GameException("Invalid position $x,$y for size $BYTE_IMAGE_SIZE")
    }

    fun pixelAt(x: Int, y: Int): Byte {
        validatePos(x, y)
        return data[y][x]
    }

    fun setPixelAt(x: Int, y: Int, b: Byte) {
        validatePos(x, y)
        data[y][x] = b
    }

    companion object {
        val EMPTY = ByteImage()
    }
}