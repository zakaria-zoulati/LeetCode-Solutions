impl Solution {
    pub fn longest_common_prefix(strs: Vec<String>) -> String {
        let n = strs.len() ; 
        let mut ans = strs[0].len() ; 
        for i in 1..n {
            ans = std::cmp::min( ans , strs[i].len() ) ; 
            for j in 0..ans { 
                if strs[i].as_bytes()[j] != strs[0].as_bytes()[j] {
                    ans = j ; 
                    break ;  
                }
            }
        }
        return strs[0][0..ans].to_string() ; 
    }
}