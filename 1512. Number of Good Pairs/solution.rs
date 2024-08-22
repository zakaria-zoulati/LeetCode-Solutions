impl Solution {
    pub fn num_identical_pairs(nums: Vec<i32>) -> i32 {
        let mut  rs : i32 = 0 ; 
        let n = nums.len() ; 
        for i in 0..n {
            for j in i+1..n {
                if nums[i] == nums[j] {
                    rs += 1 ; 
                }
            }
        }
        return rs ; 
    }
}