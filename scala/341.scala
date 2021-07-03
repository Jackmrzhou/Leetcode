import scala.collection.mutable.Stack
import scala.annotation.tailrec

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
trait NestedInteger {

    // Return true if this NestedInteger holds a single integer, rather than a nested list.
    def isInteger: Boolean

    // Return the single integer that this NestedInteger holds, if it holds a single integer.
    def getInteger: Int

    // Set this NestedInteger to hold a single integer.
    def setInteger(i: Int): Unit

    // Return the nested list that this NestedInteger holds, if it holds a nested list.
    def getList: Array[NestedInteger]

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    def add(ni: NestedInteger): Unit
}

import scala.collection.mutable.Stack
class NestedIterator(_nestedList: List[NestedInteger]) {
    val stack = Stack[Iterator[NestedInteger]](_nestedList.iterator)
    var cur: Int = 0
    def next(): Int = {
        cur
    }
    
    @tailrec
    final def hasNext(): Boolean = {
        while (stack.nonEmpty && !stack.top.hasNext) stack.pop()
        if (stack.isEmpty) false
        else {
            val n = stack.top.next()
            if (n.isInteger) {
                cur = n.getInteger
                true
            } else {
                stack.push(n.getList.iterator)
                hasNext()
            }
        }
    }
}