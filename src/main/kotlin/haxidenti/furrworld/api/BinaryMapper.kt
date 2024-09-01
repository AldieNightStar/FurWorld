package haxidenti.furrworld.api

import haxidenti.furrworld.util.for2d
import haxidenti.furrworld.world.PLACE_SIZE
import haxidenti.furrworld.world.Place
import java.nio.ByteBuffer

object BinaryMapper {
    fun placeToBinary(place: Place) = binaryOf(2 + (PLACE_SIZE * PLACE_SIZE * 4)) {
        // First two bytes is place size
        putShort(PLACE_SIZE.toShort())

        // Then sequence of shorts [floorId, objectId]
        // Each two shorts is a cell indicating floorId and objectId
        for2d(PLACE_SIZE, PLACE_SIZE) { x, y ->
            val cell = place.getCell(x, y)
            putShort(cell.floorId.toShort())
            putShort(cell.objectId.toShort())
        }
    }

    private fun binaryOf(cap: Int, f: ByteBuffer.() -> Unit): ByteArray {
        return ByteBuffer.allocate(cap).also(f).array()
    }
}