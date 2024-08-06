class Solution {
public:
    char nextGreatestLetter(vector<char>& letters, char target) {
        // int n = letters.size() ; 
        // for(int i=0; i<n ; ++i){
        //     if( letters[i] > target ){
        //         return letters[i] ; 
        //     }
        // }
        // return letters[0] ; 
        auto it = lower_bound(letters.begin() , letters.end() , target+1) ; 
        if( it == letters.end() ){
            return letters[0] ; 
        }else {
            return *it  ;
        }

    }
};