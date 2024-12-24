class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length ; 
        int rs = 0 ; 
        int[] nums = new int[n] ; 
        for( int i=0; i<n ; ++i ){
            nums[i] = arr[i] ; 
        }
        Arrays.sort( nums ) ; 
        HashMap<Integer , Integer > map = new HashMap<>() ; 
        for( int i=0 ; i<n ; ++i ){
            map.put( nums[i] , i ) ; 
            while( i+1 < n && nums[i+1] == nums[i] ){
                ++i ; 
            }
        }
        boolean[] f = new boolean[n] ; 
        int in = -1 ; 
        for( int i=0 ; i<n ; ++i ){ 
            int curr_index = map.get( arr[i] ) ; 
            map.put( arr[i] , curr_index + 1 ) ; 
            f[ curr_index ] = true ; 
            while( in+1<n && f[ in+1 ] ){
                in++ ; 
            } 
            if( i == in ) ++rs ; 
        }

        return rs ; 
    }
}