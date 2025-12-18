impl Solution {
    fn next( mut n : i32 ) -> i32 {
        let mut ans = 0 ; 
        while n > 0 {
            let d = n % 10 ; 
            ans += d*d; 
            n /= 10 ; 
        }
        ans 
    }
    pub fn is_happy(n: i32) -> bool {
        let mut slow = n; 
        let mut fast = Solution::next(n) ; 
        while slow != fast {
            slow = Solution::next( slow ) ; 
            fast = Solution::next( Solution::next(fast) ) ;  
        }
        return fast == 1 ; 
    }
}