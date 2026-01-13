class Solution {
    public int maximumSum(int[] nums) {
        int n = nums.length ; 
        List<Integer>[] arr = new ArrayList[3] ; 
        for( int i=0 ; i<3 ; ++i ){
            arr[i] = new ArrayList<>() ; 
        }
        for( int i=0 ; i<n ; ++i ){
            arr[ nums[i] % 3 ].add( nums[i] ) ; 
        }
        Collections.sort( arr[0] ) ; 
        Collections.sort( arr[1] ) ; 
        Collections.sort( arr[2] ) ; 

        int ans = 0 ; 
        
        for( int i=0 ; i<3 ; ++i ){
            if( arr[i].size() >= 3 ){
                int m = arr[i].size() ; 
                ans = Math.max( ans , arr[i].get(m-1) + arr[i].get(m-2) + arr[i].get(m-3) ) ; 
            }
        }

        if( arr[0].size() > 0 && arr[1].size() > 0 && arr[2].size() > 0 ){
            ans = Math.max( ans , arr[0].get( arr[0].size() - 1 ) 
                                + arr[1].get( arr[1].size() - 1 ) 
                                + arr[2].get( arr[2].size() - 1 )
                                 );
        }
        
        return ans ; 
    }
}