学习笔记
在第六周中，学习了字典树、并查集及一些高级搜索，并且了解了AVL树及红黑树的原理。

字典树的模板  
```
//Java
class Trie {
    private boolean isEnd;
    private Trie[] next;
    /** Initialize your data structure here. */
    public Trie() {
        isEnd = false;
        next = new Trie[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0) return;
        Trie curr = this;
        char[] words = word.toCharArray();
        for (int i = 0;i < words.length;i++) {
            int n = words[i] - 'a';
            if (curr.next[n] == null) curr.next[n] = new Trie();
            curr = curr.next[n];
        }
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        return node != null;
    }

    private Trie searchPrefix(String word) {
        Trie node = this;
        char[] words = word.toCharArray();
        for (int i = 0;i < words.length;i++) {
            node = node.next[words[i] - 'a'];
            if (node == null) return null;
        }
        return node;
    }
}
```

并查集的模板  
```
// Java
class UnionFind { 
	private int count = 0; 
	private int[] parent; 
	public UnionFind(int n) { 
		count = n; 
		parent = new int[n]; 
		for (int i = 0; i < n; i++) { 
			parent[i] = i;
		}
	} 
	public int find(int p) { 
		while (p != parent[p]) { 
			parent[p] = parent[parent[p]]; 
			p = parent[p]; 
		}
		return p; 
	}
	public void union(int p, int q) { 
		int rootP = find(p); 
		int rootQ = find(q); 
		if (rootP == rootQ) return; 
		parent[rootP] = rootQ; 
		count--;
	}
}
```

双向bfs模板  
```
bool helper(queue<int>&Q,vector<int>&visited,vector<vector<int>>&graph){
	int size=Q.size();
	for(int i=0;i<size;i++){
		int pres=Q.front();
		Q.pop();
		for(auto nxt:graph[pre]){
			if(visited[nxt]==false){
				visited[nxt]=visited[pres];//访问标识设置成和当前一样的
				Q.push(nxt);
			}
			else if(visted[nxt]!=visted[pres]){//已访问过，访问标志不同
				return true;
			}
		}
	}
	
	return false;
}
int bfs(int start,int end,int n,vector<vector<int>>&graph){
	int n=graph.size();
	int dist=0;
	vector<bool> visited(n,false);//访问标识,初始化为false

	queue<int> head2tail,tail2head;
	head2tail.push(start);
	tail2head.push(end);
	visited[head]=1;
	visited[tail]=2;
	while(head2tail.empty()!=true||tail2head.empty()!=true){
		bool flag=false;
		//每一次都选择规模小的方向扩展
		if(head2tail.empty()==true||tail2head.size()<head2tail.size()){
			flag=helper(tail2head,visited,graph);
		}
		else if(tail2head.empty()==true||
				tail2head.size()>=head2tail.size()){
			flag=helper(head2tail,visited,graph);
		}
		
		if(flag==true){
			break;
		}
		dist++;
	}

	return dist;
}
```