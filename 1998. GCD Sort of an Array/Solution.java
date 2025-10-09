class Solution {
    void union( int[] rep , int a , int b ){
        int r1 = find( rep , a ) ; 
        int r2 = find( rep , b ) ; 
        if( r1 != r2 ) rep[r1] = r2 ; 
    }
    int find( int[] rep , int a ){
        if( rep[a] != a ) rep[a] = find( rep , rep[a] ) ; 
        return rep[a] ; 
    }

    public boolean gcdSort(int[] nums) {
        int n = nums.length ; 
        if( n == 1 ) return true ; 
        int m = -1 ; 
        for( int num : nums ) m = Math.max( m , num ) ; 
        int[] rep = new int[m+1] ; 
        for( int i=2 ; i<=m ; ++i ) rep[i] = i ; 
        boolean[] exist = new boolean[m+1] ; 
        for( int num : nums ) exist[num] = true ; 
        
        boolean[] seen = new boolean[m+1] ; 
        for( int i=2 ; i<=m ; ++i ){
            int start = -1 ; 
            if( !seen[i] ){
                for( int j=i ; j<=m ; j += i ){
                    seen[j] = true ; 
                    if( exist[j] ){
                        if( start == -1 ) start = j; 
                        else union( rep , start , j ) ; 
                    }
                }
            }
        }
        List<Integer>[] inter = new ArrayList[m+1] ;  
        for( int i=0 ; i<n; ++i ){
            int r = find( rep , nums[i] ) ; 
            if( inter[r] == null ){
                inter[r] = new ArrayList<>() ; 
            }
            inter[r].add( nums[i] ) ; 
        }
        for( int i=2 ; i<=m ; ++i ){
            if( inter[i] != null  ){
                Collections.sort( inter[i] ) ; 
            }
        }
        int[] ans = new int[n] ; 
        int[] idx = new int[m+1] ;  
        for( int i=0 ; i<n ; ++i ){
            int r = find( rep , nums[i] ) ;  
            ans[i] = inter[r].get( idx[r]++ ) ; 
            if( i > 0 && ans[i] < ans[i-1] ) return false ; 
        }
        return true ; 
    }
}