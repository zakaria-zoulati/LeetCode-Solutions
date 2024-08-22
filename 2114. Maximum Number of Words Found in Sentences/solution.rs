impl Solution {
    pub fn most_words_found(sentences: Vec<String>) -> i32 {
        let mut rs : i32 = 0 ; 
        let n = sentences.len() ;
        for  i  in 0..n {
            let count  = sentences[i].split_whitespace().count() ; 
            rs = std::cmp::max( rs , count as i32 ) ; 
        }
        return rs ; 
    }
}