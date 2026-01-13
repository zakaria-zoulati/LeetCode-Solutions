impl Solution {
    pub fn contains_duplicate(nums: Vec<i32>) -> bool {
        use std::collections::HashSet ; 
        let mut set = HashSet::new() ; 
        for n in nums {
            if set.contains(&n){
                return true ; 
            }
            set.insert(n) ; 
        }
        false 
    }
}