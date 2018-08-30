public class Solution {
	class TrieNode {
		Map<Character, TrieNode> children;
		String word;
		TrieNode() {
			children = new HashMap<>();
			word = "";
		}
	}
	TrieNode root;
	public List<List<String>> wordSquares(String[] words) {
		List<List<String>> res = new ArrayList<>();
		if (words == null || words.length == 0) {
			return res;
		}
		
		//first: store all the words in to trie
		root = new TrieNode();
		buildTrie(words);

		//loop through the words for the first word to be put into square, and do DFS from there
		for (String word : words) {
			List<String> square = new ArrayList<>();
			int len = word.length();
			DFS(words, len, square, res);
		}
		return res;
	}

	private void DFS(String[] words, int len, List<String> square, List<List<String>> res) {
		//basecase: when length of square equals the len	
	    if (square.size() == len) {
			res.add(new ArrayList<>(square));
			return;
		}
		//get the prefix we need to match
		StringBuilder sb = new StringBuilder();
		int l = square.size();
		for (int i = 0; i < l; i++) {
			sb.append(square.get(i).charAt(l));
		}
		//search the trie for the prefix
		List<String> next = searchPrefix(sb.toString());
		if (next.size() == 0) {
			return;
		}
		for (String n : next) {
			if (n.length() == len) {
				square.add(n);
				DFS(words, len, square, res);
				square.remove(square.size() - 1);
			}
		}
	}

	private List<String> searchPrefix(String word) {
		List<String> res = new ArrayList<>();
		TrieNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (!cur.children.containsKey(c)) {
				return res;
			}
			cur = cur.children.get(c);
		}
		//now do dfs from the cur trieNode and get all the word cur TrieNode can get to
		Stack<TrieNode> stack = new Stack<>();
		stack.push(cur);
		while (!stack.isEmpty()) {
			TrieNode node = stack.pop();
			if (!node.word.isEmpty()) {
				res.add(word);
			}
			for (TrieNode n : cur.children.values()) {
				stack.push(n);
			}
		}
		return res;
	}
	
	private void buildTrie(String[] words) {
		for (String word : words) {
			TrieNode cur = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (!cur.children.containsKey(c)) {
					cur.children.put(c, new TrieNode(c));
				}
				cur = cur.children.get(c);
			}
			cur.word = word;
		}
	}
}