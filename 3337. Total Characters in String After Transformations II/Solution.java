class Solution {
    int mod = (int) 1e9 + 7;
    public int[][] matMul(int[][] A, int[][] B) {
        int[][] rs = new int[26][26];
        for (int i = 0; i < 26; ++i) {
            for( int k=0 ; k<26 ; ++k ){
                if( A[i][k] != 0 ){
                    for( int j=0 ; j<26 ; ++j ){
                        rs[i][j] = (int) (( rs[i][j] + 1L * A[i][k] * B[k][j]) % mod) ;
                    }
                }
            }
        }
        return rs;
    }
    public int[][] matE(int[][] mat, int k) {
        if (k == 1) return mat;
        int[][] half = matE(mat, k / 2);
        int[][] rs = matMul(half, half);
        if (k % 2 == 1) rs = matMul(rs, mat);
        return rs;
    }
    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        int[] f = new int[26];
        for (char c : s.toCharArray()) {
            f[c-'a']++;
        }
        int[][] mat = new int[26][26];
        for( int i=0 ; i<26 ; ++i ){
            int next = nums.get(i) ; 
            int in = i ; 
            for(int j=0 ; j<next ; ++j ){
                in = ( in + 1 )% 26 ; 
                mat[in][i] = 1 ; 
            }
        }
        int[][] base = matE(mat,t);
        int rs = 0;
        for (int j = 0; j<26; ++j) {
            if( f[j] == 0 ) continue ; 
            int add = 0;
            for (int i = 0; i < 26; ++i) {
                add = (int) ((add + 1L * base[i][j] * f[j]) % mod);
            }
            rs = (rs + add) % mod;
        }
        return rs;
    }
}
