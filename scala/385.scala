import scala.collection.mutable.ListBuffer

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
 
import scala.collection.mutable.ListBuffer
object Solution {
    case class int(v: Int) extends NestedInteger {
        override def isInteger: Boolean = true
        
        override def getInteger: Int = v
        
        override def setInteger(i: Int): Unit = {}
        
        override def getList: Array[NestedInteger] = null 
        
        override def add(ni: NestedInteger): Unit = {}
        
    }
    case class list(nis: Array[NestedInteger]) extends NestedInteger {
        override def isInteger: Boolean = false
        
        override def getInteger: Int = 0
        
        override def setInteger(i: Int): Unit = {}
        
        override def getList: Array[NestedInteger] = nis
        
        override def add(ni: NestedInteger): Unit = {}
        
    } 
    // s -> int | '[' s{,s} ']'
    def deserialize(s: String): NestedInteger = {
        var pos = 0
        def hasNext(): Boolean = pos < s.length()
        def next(): String = {
            s(pos) match {
                case '[' => pos += 1; "["
                case ']' => pos += 1; "]"
                case ',' => pos += 1; next()
                case ch => {
                    val start = pos
                    if (ch == '-') pos += 1
                    while (hasNext() && s(pos).isDigit) {
                        pos += 1
                    }
                    s.slice(start, pos)
                }
            }
        }

        def getList(): list = {
            val l = ListBuffer[NestedInteger]()
            var n = next()
            while (n != "]"){
                n match {
                    case "[" => l += getList()
                    case numStr => l += int(numStr.toInt)
                }
                n = next()
            }
            list(l.toArray)
        }

        def parse(): NestedInteger = {
            next() match {
                case "[" => getList()
                case numStr => int(numStr.toInt)
            }
        }
        parse()
    }
}