class Solution {
    public int HamDist( String a , String b ){
        int n = a.length() ; 
        int rs = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            if( a.charAt(i) != b.charAt(i) ){
                if( ++rs == 2 ) return rs ; 
            }
        }
        return 1 ; 
    }
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = groups.length ; 
        int[] dp = new int[n] ; 
        int[] parent = new int[n] ; 
        int last = n-1 ; 
        Arrays.fill( parent , -1 ) ; 
        for( int i=n-1 ; i>=0 ; --i ){
            for( int j=i ; j<n ; ++j ){
                if( groups[i] != groups[j] &&  words[i].length() == words[j].length() 
                    && HamDist( words[i] , words[j] ) == 1 && dp[j] >= dp[i] ){
                    dp[i] = dp[j] + 1; 
                    parent[i] = j ; 
                }
            }
            if( dp[i] > dp[last] ){
                last = i ; 
            }
        }
        List<String> rs = new ArrayList<>( dp[last] ) ; 
        while( last != -1 ){
            rs.add( words[last] ) ; 
            last = parent[ last ] ; 
        }
        return rs ; 
    }
}