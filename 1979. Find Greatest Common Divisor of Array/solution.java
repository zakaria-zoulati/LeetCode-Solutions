class Solution {
    public int gcd(int a , int b){
        while( b!=0 ){
            int temp = a%b ; 
            a = b ; 
            b = temp ;
        }
        return a ; 
    }
    public int findGCD(int[] nums) {
        int n = nums.length;  
        int min = Integer.MAX_VALUE ; 
        int max = 0 ; 
        for(int i=0 ; i<n ; ++i){
            min = Math.min( nums[i] , min ) ; 
            max = Math.max( nums[i] , max ) ; 
        }
        return gcd(min,max) ;
    }
}