class Solution {
    public int takeCharacters(String s, int k) {
        if( k == 0 ) return 0 ; 
        int n = s.length() ; 
        if( n < 3*k ) return -1 ; 
        int[][] arr = new int[n+1][3] ; 
        int a = 0 ; 
        int b = 0 ; 
        int c = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            if( s.charAt(i) == 'a' ){
                arr[++a][0] = i ;  
            }else if( s.charAt(i) == 'b' ){
                arr[++b][1] = i ; 
            }else {
                arr[++c][2] = i ; 
            }
        }

        if( a<k || b<k || c<k ) return -1 ; 

        int rs = 0 ; 
        for( int i=0; i<3 ; ++i ){
            rs = Math.max( rs , arr[k][i] + 1 ) ; 
        } 
        a = 0 ; 
        b = 0 ; 
        c = 0 ; 
        for( int i=n-1 ; i>=0 ; --i ){
            if( a >= k && b>=k && c>=k ) break; 
            int cu = n-i ; 
            int other = 0 ; 
            if( s.charAt(i) == 'a' ){
                ++a ; 
            }else if( s.charAt(i) == 'b' ){
                ++b ; 
            }else {
                ++c ; 
            }
            if( a < k ){
                other = arr[k-a][0] + 1 ; 
            }
            if( b < k ){
                other = Math.max( other , arr[k-b][1] + 1 ) ; 
            }
             if( c < k ){
                other = Math.max( other , arr[k-c][2] + 1 ) ; 
            }
            rs = Math.min( rs , cu + other ) ; 
        }
        return rs ; 
    }
}