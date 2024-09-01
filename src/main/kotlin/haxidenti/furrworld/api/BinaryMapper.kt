package haxidenti.furrworld.api

import haxidenti.furrworld.image.BYTE_IMAGE_SIZE
import haxidenti.furrworld.image.ByteImage
import haxidenti.furrworld.util.for2d
import haxidenti.furrworld.world.CellInfo
import haxidenti.furrworld.world.CellRegistry
import haxidenti.furrworld.world.PLACE_SIZE
import haxidenti.furrworld.world.Place
import java.nio.ByteBuffer

private val BYTE_IMAGE_LEN = BYTE_IMAGE_SIZE * BYTE_IMAGE_SIZE
private val CELL_INFO_LEN = 3 + BYTE_IMAGE_LEN

object BinaryMapper {
    fun place(place: Place) = binaryOf(2 + (PLACE_SIZE * PLACE_SIZE * 4)) {
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

    fun cellRegistry(reg: CellRegistry) = binaryOf(calculateRegistryLen(reg)) {
        // Sequence of [id (short), ...cellInfo]
        for ((id, info) in reg.all()) {
            putShort(id.toShort())
            put(cellInfo(info))
        }
    }

    fun cellInfo(info: CellInfo) = binaryOf(CELL_INFO_LEN) {
        // First 3 bytes indicates what is cell
        put(info.walkable.toByte())
        put(info.triggerable.toByte())
        put(info.pickable.toByte())

        // Then image bytes
        put(byteImage(info.image))
    }

    fun byteImage(img: ByteImage) = binaryOf(BYTE_IMAGE_LEN) {
        for2d(BYTE_IMAGE_SIZE, BYTE_IMAGE_SIZE) { x, y ->
            put(img.pixelAt(x, y))
        }
    }

    private fun calculateRegistryLen(reg: CellRegistry) = (reg.size * CELL_INFO_LEN) + (reg.size * 2)

    private fun Boolean.toByte() = if (this) 0.toByte() else 1.toByte()

    private fun binaryOf(cap: Int, f: ByteBuffer.() -> Unit): ByteArray {
        return ByteBuffer.allocate(cap).also(f).array()
    }
}