package haxidenti.furrworld.util

inline fun for2d(w: Int, h: Int, f: (x: Int, y: Int) -> Unit) {
    for (y in 0 until h) {
        for (x in 0 until w) {
            f(x, y)
        }
    }
}