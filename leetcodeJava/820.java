package leetcodeJava;

class Solution {
    class Node {
        char val;
        List<Node> next;
        public Node(char v) {
            val = v;
            next = new LinkedList<Node>();
        }
    }
    
    Node trie = new Node('a');
    
    private void add(Node root, String word) {
        if (word == null || word.length() == 0) return;
        var found = false;
        for (var node : root.next) {
            if (node.val == word.charAt(0)) {
                add(node, word.substring(1, word.length()));
                found = true;
                break;
            }
        }
        if (!found) {
            Node node = new Node(word.charAt(0));
            root.next.add(node);
            add(node, word.substring(1, word.length()));
        }
    }
    
    private int count(Node root, int cur) {
        if (root == null || root.next.size() == 0) {
            return cur + 1;
        }
        var res = 0;
        for (var node: root.next) {
            res += count(node, cur+1);
        }
        return res;
    }
    
    
    public int minimumLengthEncoding(String[] words) {
        for (var word: words) {
            add(trie, new StringBuilder(word).reverse().toString());
        }
        return count(trie, 0);
    }
}
