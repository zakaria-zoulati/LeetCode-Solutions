class Solution {
    public int differenceOfSum(int[] nums) {
        int rs = 0 ; 
        int digits = 0 ; 
        int sum = 0 ; 
        for(int num : nums ){
            sum += num ; 
            while( num != 0 ){
                digits += num%10; 
                num /= 10 ; 
            }
        }
        return Math.abs( sum - digits ) ; 
    }
}