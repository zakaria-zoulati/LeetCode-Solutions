impl Solution {
    pub fn left_right_difference(nums: Vec<i32>) -> Vec<i32> {
        let n = nums.len() ; 
        let mut ans = vec![0; n] ; 
        ans[0] = nums[0] ; 
        for i in 1..n {
            ans[i] = ans[i-1] + nums[i] ; 
        }
        let mut left = nums[n-1] ; 
        for i in (0..n).rev() {
            ans[i] = ( ans[i] - left ).abs() ; 
            if i>0 {
                left += nums[i-1] ; 
            }
        }

        return ans ; 
    }
}