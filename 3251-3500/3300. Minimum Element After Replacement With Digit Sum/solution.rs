impl Solution {
    pub fn min_element(nums: Vec<i32>) -> i32 {
      let n = nums.len() ; 
      let mut ans = 1_000_000_000 ; 
      for i in 0..n {
        let mut curr = nums[i] ; 
        let mut can = 0 ; 
        while curr > 0 { 
            can += curr % 10 ; 
            curr /= 10 ; 
        }
        ans = ans.min(can);
      } 
      return ans ;  
    }
}