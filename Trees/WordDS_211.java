package Trees;

public class WordDS_211 {
    class WordDictionary {
        WordDictionary[] child;
        boolean isWordEnd;

        public WordDictionary() {
            child = new WordDictionary[26];
            isWordEnd = false;
        }
        
        public void addWord(String word) {
            WordDictionary curr = this;
            for(char c: word.toCharArray()) {
                if(curr.child[c-'a']==null) curr.child[c-'a'] = new WordDictionary();
                curr = curr.child[c-'a'];
            }

            curr.isWordEnd = true;
        }
        
        public boolean search(String word) {
            WordDictionary curr = this;
            for(int i=0;i<word.length();i++) {
                char c = word.charAt(i);
                if(c=='.') {
                    for(WordDictionary ch: curr.child) {
                        if(ch!=null && ch.search(word.substring(i+1))) return true;
                    }
                    return false;
                }
                if(curr.child[c-'a']==null) return false;
                curr = curr.child[c-'a'];
            }

            return curr!=null && curr.isWordEnd;
        }
    }
}
