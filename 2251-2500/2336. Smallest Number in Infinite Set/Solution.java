class SmallestInfiniteSet {
    boolean[] nums ; 
    int in = 1 ; 
    public SmallestInfiniteSet() {
        nums = new boolean[1001] ;  
        for( int i=1 ; i<=1000 ; ++i ) nums[i] = true; 
    }
    public int popSmallest() {
        int rs = in ; 
        nums[in] = false ; 
        while( in < 1001 && !nums[in] ) in++ ; 
        if( in == 1001 ) in = -1 ; 
        return rs ; 
        
    }
    public void addBack(int num) {
        if( in == -1 ){
            in = num ; 
        }else if( num < in ){
            in = num ;
        }
        nums[num] = true ; 
    }
}

