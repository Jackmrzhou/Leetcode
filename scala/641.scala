class MyCircularDeque(_k: Int) {

    /** Initialize your data structure here. Set the size of the deque to be k. */
    val arr = Array.ofDim[Int](_k)
    var size = 0
    var front = 0
    var rear = 0

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    def insertFront(value: Int): Boolean = {
        if (isFull()) false
        else {
            arr(front) = value
            front = (front+1) % _k
            size += 1
            true
        }
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    def insertLast(value: Int): Boolean = {
        if (isFull()) false
        else {
            rear -= 1
            if (rear < 0) rear = _k + rear
            arr(rear) = value
            size += 1
            true
        }
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    def deleteFront(): Boolean = {
        if (isEmpty()) false
        else {
            front -= 1
            if (front < 0) front = _k + front
            size -= 1
            true
        }
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    def deleteLast(): Boolean = {
        if (isEmpty()) false 
        else {
            rear = (rear+1) % _k
            size -= 1
            true
        }
    }

    /** Get the front item from the deque. */
    def getFront(): Int = {
        if (isEmpty()) -1
        else {
            val tmp = if (front - 1 < 0) _k-1 else front - 1
            arr(tmp)
        }
    }

    /** Get the last item from the deque. */
    def getRear(): Int = {
        if (isEmpty()) -1
        else arr(rear)
    }

    /** Checks whether the circular deque is empty or not. */
    def isEmpty(): Boolean = {
        size == 0
    }

    /** Checks whether the circular deque is full or not. */
    def isFull(): Boolean = {
        size == _k
    }

}