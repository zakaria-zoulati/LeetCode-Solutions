class Solution {
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public int subarrayGCD(int[] nums, int k) {
        int n = nums.length ; 
        int rs = 0 ; 
        for(int i=0 ; i<n ; ++i){
            if( nums[i] % k != 0 ) continue ; 
            if( nums[i] == k ){
               rs++  ;
               int j = i ; 
               while( j+1 <n && nums[j+1]%k == 0 ){
                    rs++ ;
                    j++  ;  
               }
            }else {
                int j = i ; 
                int curr = nums[i] ; 
                while( j+1<n && gcd( curr , nums[j+1] ) >= k ){
                    curr = gcd( curr , nums[j+1] ) ; 
                    j++ ;
                    if( curr == k ){
                        rs++ ; 
                    }
                }
            }
        }
        return rs ; 
    }
}