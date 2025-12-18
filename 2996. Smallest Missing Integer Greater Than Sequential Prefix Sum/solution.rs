impl Solution {
    pub fn missing_integer(nums: Vec<i32>) -> i32 {
        let mut pref_sum = nums[0] ; 
        for i in 1..nums.len() {
            if nums[i] == nums[i-1] + 1 {
                pref_sum += nums[i] ;  
            }else {
                break ; 
            }
        }
        let mut sorted = nums.clone() ;
        sorted.sort() ;  
        let mut x = pref_sum ; 
        for &num in sorted.iter() {
            if x < num { 
                break ; 
            }
            if x == num {
                x += 1 ; 
            }
        }
        x 
    }
}