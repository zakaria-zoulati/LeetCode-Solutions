impl Solution {
    pub fn does_alice_win(s: String) -> bool {
        for ch in s.chars() {
            if( ch == 'a' || ch == 'e' || ch == 'i' || ch == 'u' || ch == 'o' ){
                return true ; 
            }
        }
        return false ; 
    }
}