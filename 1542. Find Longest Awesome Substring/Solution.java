class Solution {
    public int longestAwesome(String s) {
        int n = s.length() ; 
        int rs = 0 ; 
        int len = (1<<10) ; 
        char[] chars = s.toCharArray() ; 
        int[] mask = new int[len] ;
        for( int i=0 ; i<len ; ++i ){
            mask[i] = n ; 
        }
        int curr = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            int num = chars[i] - '0' ; 
            curr ^= ( 1 << num ) ; 
            if( curr == 0 || (curr&(curr-1)) == 0 ){
                rs = i+1 ; 
            }else {
                if( mask[curr] != -1 ){
                    rs = Math.max( rs , i - mask[curr] ) ; 
                }
                for( int j=0 ; j<=9 ; ++j ){
                    rs = Math.max( rs , i - mask[curr^(1<<j)] ) ; 
                }
            }
            if( mask[curr] == n ){
                mask[curr] = i ; 
            }
        }
        return rs ; 
    }
}