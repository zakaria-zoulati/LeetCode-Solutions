impl Solution {
    pub fn min_cost_to_move_chips(position: Vec<i32>) -> i32 {
        let mut one : i32 = 0; 
        let mut two : i32 = 0 ; 
        let n = position.len() ; 
        for i in 0..n {
            if (position[i] -1 ) % 2 == 0{
                one += 1 ;
            }
            else {
                two += 1;  
            }
        }
        return std::cmp::min( one , two ) ; 
    }
}