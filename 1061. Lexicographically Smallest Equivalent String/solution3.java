class Solution {
    int[] parent ; 
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        parent = new int[26];
        int n = s1.length() ; 
        for (int i = 0; i < 26; ++i) {
            parent[i] = i;
        }
        for (int i = 0; i<n ; ++i) {
            int a = s1.charAt(i) - 'a';
            int b = s2.charAt(i) - 'a';
            union(a, b );
        }
        StringBuilder result = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            result.append((char) (find(c - 'a'  ) + 'a'));
        }

        return result.toString();
    }
    int find(int x ) {
        if (parent[x] != x) {
            parent[x] = find(parent[x] );
        }
        return parent[x];
    }
    void union(int x, int y  ) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rootX < rootY) {
                parent[rootY] = rootX;
            } else {
                parent[rootX] = rootY;
            }
        }
    }
}
