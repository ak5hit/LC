class Solution {
    fun maxArea(height: IntArray): Int {
        var l = 0;
        var r = height.size - 1;
        var currArea = 0

        while (l < r) {
            currArea = maxOf(currArea, (minOf(height[l], height[r]) * (r - l)))
            if (height[l] < height[r]) {
                l++
            } else r--
        }

        return currArea
    }
}

// using maxOf instead of max somehow decrease the execution time and also no need to imports with this.