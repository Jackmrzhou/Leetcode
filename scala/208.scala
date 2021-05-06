import scala.collection.mutable
class Trie() {

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

    /** Inserts a word into the trie. */
    def insert(word: String) {
      _insert(word, root)
    }

  def _search(word: String, root: Node, isPre: Boolean): Boolean = {
    if (word.isEmpty()) {
      if (root.next.find(n => n.ch == '\u0000').isDefined) return true
      else if (isPre) return true
      else return false
    } else {
      root.next.find(n => n.ch == word.head) match {
        case None => return false
        case Some(n) => return _search(word.substring(1), n, isPre)
      }
    }
  }
    /** Returns if the word is in the trie. */
    def search(word: String): Boolean = {
       _search(word, root, false)
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    def startsWith(prefix: String): Boolean = {
      _search(prefix, root, true)
    }

}
