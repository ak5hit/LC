class ListNode(var `val`: Int) {
    var next: ListNode? = null
}


// Really un-smart solution to convert to array and swap
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

// good solution
class Solution {
    fun swapNodes(head: ListNode?, k: Int): ListNode? {
        var nodeA: ListNode? = null
        var nodeB = head
        var temp = head
        var counter = 1

        while (temp != null) {
            if (nodeA != null) {
                nodeB = nodeB!!.next
            }

            if (counter == k) {
                nodeA = temp
            }

            temp = temp.next
            counter++
        }

        nodeA!!.`val` = nodeB!!.`val`.also { nodeB.`val` = nodeA.`val` }

        return head
    }
}