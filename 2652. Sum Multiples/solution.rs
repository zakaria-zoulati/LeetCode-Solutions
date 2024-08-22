impl Solution {
    pub fn sum_of_multiples(n: i32) -> i32 {
        let mut  rs : i32 = 0 ; 
        for  i in 3..n+1 {
            if i%3 == 0 || i%5 ==0 || i%7 ==0 {
                rs += i ; 
            }
        }
        return rs ;
    }
}