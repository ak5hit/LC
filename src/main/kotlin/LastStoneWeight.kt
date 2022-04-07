import java.util.*

class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        val heap = PriorityQueue<Int>(stones.size) { a, b -> b - a }

//        stones.forEach { heap.add(it) }
        for (stone in stones) {
            heap.add(stone)
        }
        while (heap.size > 1) {
            val a = heap.poll()
            val b = heap.poll()
            if (a != b) heap.add(a - b)
        }

        return if (heap.isEmpty()) 0 else heap.peek()
    }
}