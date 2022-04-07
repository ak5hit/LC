import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> {
            if (o1 > o2) return -1;
            else return 1;
        });
        for (int stone : stones) {
            heap.add(stone);
        }


        while (heap.size() > 1) {
            int a = heap.poll();
            int b = heap.poll();

            if (a != b) {
                heap.add(a - b);
            }
        }

        if (heap.isEmpty()) return 0;
        else return heap.peek();
    }
}