import scala.collection.mutable.Stack
object Solution {
    def lengthLongestPath(input: String): Int = {
        val stack = Stack[String]()
        var curLen = 0
        var res = 0
        input.split("\n").foreach(line => {
            if (stack.isEmpty && line.contains('.')) {
                res = res.max(line.length)
            } else if (stack.isEmpty) {
                stack.push(line)
                curLen += line.length()
            }
            else { 
                val level = line.count(_ == '\t')
                while (stack.length > level) {
                    curLen -= stack.pop().length() + 1
                }
                if (line.contains('.')) {
                    res = res.max(curLen + line.length() - level + 1)
                } else {
                    curLen += line.length() - level + 1
                    stack.push(line.slice(level, line.length()))
                }
            }
        })
        res
    }
}