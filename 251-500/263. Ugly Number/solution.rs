impl Solution {
    pub fn is_ugly(n: i32) -> bool {
        if n == 0 {
            return false ; 
        }
        let mut curr = n ; 
        while curr % 2 == 0 {
            curr /= 2 ; 
        }
        while curr % 3 == 0 {
            curr /= 3 ;
        }
        while curr % 5 == 0 { 
            curr /= 5 ; 
        }
        return curr == 1 ; 
    }
}