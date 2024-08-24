class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        class BIT {
            int[] arr; 
            int n;
            public BIT(int n) {
                arr = new int[n];  
                this.n = n;
            }
            
            public int p(int n) {
                return n & -n;
            }
            public void insert(int index, int val) {
                while (index <n) {
                    arr[index] += val;
                    index += p(index); 
                }
            }
            
            public int sum(int x) {
                int rs = 0;
                while (x >= 1) {
                    rs += arr[x];
                    x -= p(x) ; 
                }
                return rs;
            }
        }
        int n = nums.length ; 
        BIT bit = new BIT(102) ; 
        int[] rs = new int[n] ;  
        int zeros = 0 ; 
        for(int i=0 ; i<n ; ++i ){
            if( nums[i] == 0 ){
                zeros++ ;
                continue ; 
            }
            bit.insert( nums[i] , 1 ) ; 
        }
        for(int i=0 ; i<n ; ++i){
            if( nums[i] == 0 ){
                rs[i] = 0 ; 
            }else {
                rs[i] = bit.sum( nums[i] -1 ) + zeros  ; 
            }
        }
        return rs ; 

    }
}