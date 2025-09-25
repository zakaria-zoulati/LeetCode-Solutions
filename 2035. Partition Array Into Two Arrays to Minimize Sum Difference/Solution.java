class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length ; 
        int sum = 0 ; 
        for( int i : nums ) sum += i ; 
        List<Integer>[] left = new ArrayList[n/2+1] ; 
        List<Integer>[] right = new ArrayList[n/2+1] ; 
        for( int i=0 ; i<=n/2 ; ++i ){
            left[i] = new ArrayList<>() ; 
            right[i] = new ArrayList<>() ; 
        }
        int len = ( 1 << (n/2) ) ; 
        for( int i=0 ; i<len ; ++i ){
            int curr = 0 ; 
            int count = 0 ; 
            for( int j=0 ; j<n/2 ; ++j ){
                if( ( (i>>j) & 1 ) == 1 ){
                    count++ ; 
                    curr += nums[j] ; 
                }
            } 
            left[count].add( curr ) ; 
        }
        for( int i=0 ; i<len ; ++i ){
            int curr = 0 ; 
            int count = 0 ; 
            for( int j=0 ; j<n/2 ; ++j ){
                if( ( (i>>j) & 1 ) == 1 ){
                    count++ ; 
                    curr += nums[n/2+j] ; 
                }
            } 
            right[count].add( curr ) ; 
        }
        int target = sum/2 ; 
        int rs = Integer.MAX_VALUE ; 
        for( int i=0 ; i<=n/2 ; ++i ){
            int rest = n/2-i ; 
            Collections.sort( left[i] ) ; 
            Collections.sort( right[rest] ) ; 
            int l = 0 ; int r = right[rest].size() - 1; 
            while( l < left[i].size() && r >= 0  ){
                int can = left[i].get(l) + right[rest].get(r) ; 
                if( can == target ) return Math.abs( 2*target - sum ) ; 
                rs = Math.min( rs , Math.abs( 2*can - sum ) ) ; 
                if( can < target ){
                    l++ ; 
                }else {
                    r-- ; 
                }
            }
        }
        return rs ; 
    }       
}