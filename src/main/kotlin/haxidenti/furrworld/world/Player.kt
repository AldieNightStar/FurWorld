package haxidenti.furrworld.world

const val PLAYER_MAX_ITEMS = 32

class Player(
    val place: Place,
    var x: Int,
    var y: Int,
) {
    val items = mutableListOf<Int>()

    fun walk(x: Int, y: Int): Boolean {
        if (!place.isWalkable(x, y)) return false
        if (place.script.callOnMove(this, x, y)) {
            this.x = x
            this.y = y
            return true
        } else {
            return true
        }
    }

    fun pickUp(x: Int, y: Int): Boolean {
        if (items.size >= PLAYER_MAX_ITEMS) return false
        if (!place.isPickable(x, y)) return false
        val cell = place.getCell(x, y)
        if (place.script.callOnPick(this, x, y, cell.objectId)) {
            place.removeObject(x, y)

            if (cell.objectId > 0) {
                items.add(cell.objectId)
                return true
            } else {
                return false
            }
        } else {
            return false
        }
    }

    fun putDown(x: Int, y: Int, item: Int): Boolean {
        if (item !in items) return false
        if (!place.isFree(x, y)) return false
        if (place.script.callOnPut(this, x, y, item)) {
            place.setObject(x, y, item)
            items.remove(item)
            return true
        } else {
            return false
        }
    }

    fun trigger(x: Int, y: Int): Boolean {
        if (!place.isTriggerable(x, y)) return false
        return place.script.callOnTrigger(this, x, y)
    }
}