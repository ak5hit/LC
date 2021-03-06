class Solution {
    private val MODULO = 1000000007

    fun threeSumMulti(arr: IntArray, target: Int): Int {
        var ans = 0
        val end = arr.lastIndex
        for (i in 0..end - 2) {
            ans += twoSum(arr, i + 1, end, target - arr[i])
            ans %= MODULO
        }

        return ans
    }

    fun twoSum(arr: IntArray, start: Int, end: Int, target: Int): Int {
        var couples = 0
        val hashMap = mutableMapOf<Int, Int>()

        for (i in start..end) {
            couples += hashMap.getOrDefault(target - arr[i], 0)
            couples %= MODULO
            if (hashMap[arr[i]] == null) {
                hashMap[arr[i]] = 1
            } else hashMap[arr[i]] = hashMap[arr[i]]!!.plus(1)
        }

        return couples
    }
}