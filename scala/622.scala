class MyCircularQueue(_k: Int) {

    val arr = Array.ofDim[Int](_k)
    var tail = 0
    var head = 0
    var size = 0
    def enQueue(value: Int): Boolean = {
        if (isFull()) false
        else {
            arr(head) = value
            head = (head+1)%_k
            size += 1
            true
        }
    }

    def deQueue(): Boolean = {
        if (isEmpty()) false
        else {
            tail = (tail + 1)%_k
            size -= 1
            true
        }
    }

    def Front(): Int = {
        if (isEmpty) -1
        else arr(tail)
    }

    def Rear(): Int = {
        if (isEmpty) -1
        else {
            if(head == 0) arr.last
            else arr(head-1)
        }
    }

    def isEmpty(): Boolean = {
        size == 0
    }

    def isFull(): Boolean = {
        size == _k
    }

}