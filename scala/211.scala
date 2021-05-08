import scala.collection.mutable
class WordDictionary() {

    /** Initialize your data structure here. */
    
  case class Node (val ch: Char) {
    val next = mutable.Set[Node]()
  }

  val root = Node('a')

  def _insert(word: String, root: Node) {
    if (word.isEmpty()) {
      root.next.add(Node('\u0000'))
      return 
    }
    val e = root.next.find(n => n.ch == word.head)
    e match {
      case None => {
        val node = Node(word.head)
        root.next.add(node)
        _insert(word.substring(1), node)
      }
      case Some(value) => _insert(word.substring(1), value)
    }
  }
  
    def addWord(word: String) {
        _insert(word, root)
    }
  
  def _search(word: String, root: Node, isPre: Boolean): Boolean = {
    if (word.isEmpty()) {
      if (root.next.find(n => n.ch == '\u0000').isDefined) return true
      else if (isPre) return true
      else return false
    } else {
      root.next.filter(n => word.head == '.' || word.head == n.ch).exists(n => _search(word.substring(1), n, isPre))
    }
  }
  
    def search(word: String): Boolean = {
        _search(word, root, false)
    }

}
