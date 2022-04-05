class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun swapNodes(head: ListNode?, k: Int): ListNode? {
        val size = getLength(head)
        val list = arrayOfNulls<Int>(size)

        var curr = 0
        var temp = head
        while (temp != null) {
            list[curr] = temp.`val`
            temp = temp.next
            curr++
        }

        list[k - 1] = list[size - k].also { list[size - k] = list[k - 1] }

        val result = ListNode(list[0] ?: 0)
        temp = result
        curr = 1
        while (curr < size) {
            temp?.next = ListNode(list[curr] ?: 0)
            temp = temp?.next
            curr++
        }

        return result
    }

    fun getLength(h: ListNode?): Int {
        var head: ListNode? = h ?: return 0
        var length = 0

        while (head != null) {
            head = head.next
            length++
        }

        return length
    }
}