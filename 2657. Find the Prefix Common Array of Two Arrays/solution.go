package solution

func findThePrefixCommonArray(A []int, B []int) []int {
    n := len(A)
    rs := make( []int , n )
    f :=  make( []int , n+1 )
    if( A[0] == B[0] ){
        rs[0] = 1 
    }else {
        f[ A[0] ]++
        f[ B[0] ]++
    }
    for i:=1 ; i<n ; i++ {
        rs[i] = rs[i-1]
        if( f[ A[i] ] == 1 ){
            rs[i]++
        }else {
            f[ A[i] ]++ 
        }
        
        if( f[ B[i] ] == 1 ){
            rs[i]++
        }else {
            f[ B[i] ]++ 
        }  
    }
    return rs 
}