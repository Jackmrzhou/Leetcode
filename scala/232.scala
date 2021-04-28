import scala.collection.mutable.Stack
class MyQueue() {

    /** Initialize your data structure here. */
  val readS = Stack[Int]()
  val writeS = Stack[Int]()

    /** Push element x to the back of queue. */
    def push(x: Int) {
        writeS.push(x)
    }

    /** Removes the element from in front of queue and returns that element. */
  def pop(): Int = {
    if (readS.isEmpty)
      while ( !writeS.isEmpty )
        readS.push(writeS.pop())
      readS.pop()
    }

    /** Get the front element. */
    def peek(): Int = {
      val n = pop()
      readS.push(n)
      n
    }

    /** Returns whether the queue is empty. */
    def empty(): Boolean = {
       readS.isEmpty && writeS.isEmpty 
    }

}
