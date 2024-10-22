package base.class07;

public class Code01_TrieTree {

    public static class TrieNode {
        public int pass;
        public int end;
        // HashMap<Char, Node> nexts; 如果数（字符种类）特别多，不适合用数组表示路，可以用HashMap表示 key表示有某一条路，node表示通过下级走到那一个node上去
        public TrieNode[] nexts;

        public TrieNode() {
            pass = 0;
            end = 0;
            // nexts[0] == null 没有走向'a'的路
            // nexts[0] != null 有走向'a'的路
            // ...
            // nexts[25] != null
            nexts = new TrieNode[26];
        }
    }

    public static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] chs = word.toCharArray();
            TrieNode node  = root;
            node.pass++;
            int index = 0;
            for (int i = 0; i  < chs.length; i++) { // 从左往右遍历字符
                index = chs[i] - 'a'; // 由字符，对应成走向哪条路？
                if (node.nexts[index] == null) {
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];
                node.pass++;
            }
            node.end++;
        }

        public void delete(String word) {
            if (search(word) != 0) { // 确定树中确实加入过word，才删除
                char[] chs = word.toCharArray();
                TrieNode node = root;
                node.pass--;
                int index = 0;
                for (int i = 0; i < chs.length; i++) {
                    index = chs[i] - 'a';
                    if (--node.nexts[index].pass == 0) {
                        // java C++ 要遍历到底去析构
                        node.nexts[index] = null;
                        // ...
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
        }


        // word这个单词之前加入过几次
        public int search(String word) {
            if (word == null) {
                return 0;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

        // 所有加入的字符串中，有几个是以pre这个字符串作为前缀的
        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }
            char[] chs = pre.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.pass;
        }
    }
}
