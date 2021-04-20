import scala.collection.mutable.Stack
class MinStack() {

    /** initialize your data structure here. */
  var s = Stack[Int]()
  var minStack = Stack[Int]()

    def push(`val`: Int) {
      s.push(`val`)
      if (minStack.isEmpty || `val` <= minStack.top) minStack.push(`val`)
    }

    def pop() {
      val v = s.pop()
      if (!minStack.isEmpty && minStack.top == v) minStack.pop()
    }

    def top(): Int = {
        s.top
    }

    def getMin(): Int = {
        minStack.top
    }

}
