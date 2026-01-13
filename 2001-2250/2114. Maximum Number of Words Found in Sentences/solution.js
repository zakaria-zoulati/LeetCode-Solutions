/**
 * @param {string[]} sentences
 * @return {number}
 */
var mostWordsFound = function(sentences) {
    let rs = 0 ; 
    for( let item of sentences ){
        rs = Math.max( rs , item.split(" ").length ) ; 
    }
    return rs ; 
};