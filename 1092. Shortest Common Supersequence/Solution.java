class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        if( str1.length() < str2.length() ){
            String temp = str1 ; 
            str1 = str2 ; 
            str2 = temp ; 
        }
        char[] s1 = str1.toCharArray() ; 
        char[] s2 = str2.toCharArray() ; 
        int n = str1.length() ; 
        int m = str2.length() ; 
        int[][] dp = new int[n+1][m+1] ; 
        for( int i=n-1 ; i>=0 ;--i ){
            for( int j=m-1 ; j>=0 ; --j ){
                if( s1[i] == s2[j] ){
                    dp[i][j] = 1 + dp[i+1][j+1] ; 
                }else {
                    dp[i][j] = Math.max( dp[i+1][j] , dp[i][j+1] ) ; 
                }
            }
        }
        int i=0 , j=0 ;
        List<int[]> indices = new ArrayList<>() ; 
        while( i<n && j<m ){
            if( s1[i] == s2[j] ){
                indices.add( new int[]{i,j} ) ; 
                i++ ; j++ ; 
            }else if( dp[i+1][j] >= dp[i][j+1] ){
                i++ ; 
            }else {
                j++ ; 
            }
        }
        int in1 = 0 ; 
        int in2 = 0 ; 
        int curr = 0 ;
        StringBuilder rs = new StringBuilder() ; 
        while( in1<n && in2 <m && curr < indices.size() ){
            if( in1 == indices.get(curr)[0] || in2 == indices.get(curr)[1] ){
                while( in2 < indices.get(curr)[1] ){
                    rs.append( s2[in2++] ) ; 
                }
                rs.append( s1[in1] ) ;
                in1++ ; in2++ ; 
                curr++ ; 
            }else {
                rs.append( s1[in1++] ) ; 
            }
        } 
        while( in1<n ){
            rs.append( s1[in1++] ) ; 
        }
        while( in2<m ){
            rs.append( s2[in2++] ) ; 
        }
        return rs.toString() ; 
    }
}