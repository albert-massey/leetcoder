class Solution {
    class Trie {
        class TrieNode {
            boolean isEnd;
            TrieNode[] children;
            public TrieNode(){
                isEnd = false;
                children = new TrieNode[26];
            }
        }
        TrieNode root;
        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode curr = root;
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.isEnd = true;
        }

        public boolean canBeBuilt(String word) {
            TrieNode curr = root;
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(curr.children[c - 'a'] != null) {
                    curr = curr.children[c - 'a'];
                    if(curr.isEnd == false) return false;
                } else {
                    return false;
                }
            }
            return curr.isEnd;
        }
    }

    public String longestWord(String[] words) {
        Trie trie = new Trie();
        // String result = "";
        // for(String word: words) {
        //     trie.insert(word);
        //     if(trie.canBeBuilt(word) && (result.length() < word.length() || word.compareTo(result) < 0)) result = word;
        // }
        
                // Insert all words into the Trie
        for (String word : words) {
            trie.insert(word);
        }

        String longestWord = "";
        for (String word : words) {
            if (trie.canBeBuilt(word)) {
                // If the current word is longer than the longestWord, or same length but lexicographically smaller
                if (word.length() > longestWord.length() || 
                    (word.length() == longestWord.length() && word.compareTo(longestWord) < 0)) {
                    longestWord = word;
                }
            }
        }
        return longestWord;
    }
}