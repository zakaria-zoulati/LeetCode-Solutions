/**
 * @param {string} s
 * @return {boolean}
 */
var doesAliceWin = function(s) {
    let n = s.length ; 
    let v = 0 ; 
    for( let i=0 ; i<n ; i++ ){
        if(  s.charAt(i) == 'e' ||  s.charAt(i) == 'a' || s.charAt(i) == 'o' || s.charAt(i) == 'i' || s.charAt(i) == 'u'    ){
            v++ ; 
        }
    }
    if( v!=0 ){
        return true ; 
    }
    return false ; 
    
};