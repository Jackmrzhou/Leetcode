class PeekingIterator(_iterator: Iterator[Int]) {
    var cur = -1
    var _next = -1
    def peek(): Int = {
        if (_next == -1) _next = _iterator.next()
        _next
    }
    
    def next(): Int = {
        cur = peek()
        _next = if (_iterator.hasNext) _iterator.next() else -1
        cur
    }
    
    def hasNext(): Boolean = {
        _next != -1 || _iterator.hasNext
    }
}
