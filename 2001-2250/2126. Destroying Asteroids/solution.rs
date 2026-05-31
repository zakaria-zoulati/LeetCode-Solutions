impl Solution {
    pub fn asteroids_destroyed(mass: i32, mut asteroids: Vec<i32>) -> bool {
        asteroids.sort_unstable() ; 
        let mut curr:i64 = mass as i64 ; 
        for &a in &asteroids {
            let astr = a as i64 ; 
            if curr >= astr {
                curr += astr ; 
            }else {
                return false ; 
            }
        }
        true    
    }
}