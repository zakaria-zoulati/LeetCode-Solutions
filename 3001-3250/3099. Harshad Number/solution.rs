impl Solution {
    pub fn sum_of_the_digits_of_harshad_number(x: i32) -> i32 {
        let mut inter = x ; 
        let mut rs :i32 = 0 ; 
        while( inter!=0){
            rs += inter%10 ; 
            inter /= 10  ;
        }
        if( x % rs ==0 ){
            return rs ; 
        }
        return -1 ; 
    }
}