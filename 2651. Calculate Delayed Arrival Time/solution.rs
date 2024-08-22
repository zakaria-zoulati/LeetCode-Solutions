impl Solution {
    pub fn find_delayed_arrival_time(arrival_time: i32, delayed_time: i32) -> i32 {
        let mut rs:i32 = 0 ; 
        rs = ( delayed_time+ arrival_time ) % 24; 
        return rs ; 
    }
}