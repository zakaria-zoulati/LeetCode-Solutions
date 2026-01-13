class Solution {
    public boolean isValid( String a , String b ,int x , int y  ){
        if( x == y ) return false ; 
        if( a.length() != b.length() ) return false;
        int count = 0 ;
        for( int i=0 ; i<a.length() ; ++i ){
            if( a.charAt(i) != b.charAt(i) ){
                if( ++count > 1 ) return false ; 
            }
        }
        return count == 1 ; 
    }
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = groups.length ; 
        int[] dp = new int[n] ; 
        int[] parent = new int[n] ; 
        int last = n-1 ; 
        Arrays.fill( parent , -1 ) ; 
        for( int i=n-1 ; i>=0 ; --i ){
            for( int j=i ; j<n ; ++j ){
                if( dp[j]>=dp[i] && isValid( words[i] , words[j] , groups[i] , groups[j] ) ){
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