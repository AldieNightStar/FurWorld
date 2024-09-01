package haxidenti.furrworld.player

class PlayerInventory(
    val items: MutableList<Short> = mutableListOf(),
) {
    val size get() = items.size

    fun add(item: Short) {
        this.items.add(item)
    }

    fun remove(item: Short) {
        this.items.remove(item)
    }

    operator fun contains(item: Short) = item in items
}