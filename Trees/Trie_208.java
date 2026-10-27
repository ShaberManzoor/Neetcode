package Trees;

public class Trie_208 {
    class TrieNode {
        TrieNode[] children;
        boolean isWordEnd;
        TrieNode() {
            children = new TrieNode[26];
            isWordEnd = false;
        }
    }

    class Trie {
        TrieNode head;
        public Trie() {
            head = new TrieNode();
        }
        
        public void insert(String word) {
            TrieNode curr = head;
            for(char c: word.toCharArray()) {
                if(curr.children[c-'a']==null) curr.children[c-'a'] = new TrieNode();
                curr = curr.children[c-'a'];
            }

            curr.isWordEnd = true;
        }
        
        public boolean search(String word) {
            TrieNode curr = head;
            for(char c: word.toCharArray()) {
                if(curr.children[c-'a']==null) return false;
                curr = curr.children[c-'a'];
            }

            return curr.isWordEnd;
        }
        
        public boolean startsWith(String prefix) {
            TrieNode curr = head;
            for(char c: prefix.toCharArray()) {
                if(curr.children[c-'a']==null) return false;
                curr = curr.children[c-'a'];
            }

            return true;
        }
    }
}
