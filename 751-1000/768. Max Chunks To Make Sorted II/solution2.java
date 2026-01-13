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
        int ele = 0 ; 
        int start = 0 ; 
        int sum = 0 ; 
        for( int i=0 ; i<n ; ++i ){ 
            ele++ ; 
            int curr_index = map.get( arr[i] ) ; 
            sum += curr_index ; 
            map.put( arr[i] , curr_index + 1 ) ; 
            if( sum == ele*( 2*start + ele -1  )/2 ){
                rs++ ; 
                sum = 0 ;
                ele = 0 ; 
                start = i+1 ; 
            }
        }
        return rs ; 
    }
}