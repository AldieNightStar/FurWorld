package haxidenti.furrworld.player

class PlayerInventory(
    val items: MutableList<Int> = mutableListOf()
)
{
    val size get() = items.size

    fun add(item: Int) {
        this.items.add(item)
    }

    fun remove(item: Int) {
        this.items.remove(item)
    }

    operator fun contains(item: Int) = item in items
}