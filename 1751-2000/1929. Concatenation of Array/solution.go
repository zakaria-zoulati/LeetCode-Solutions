package solution

func getConcatenation(nums []int) []int {
    n := len(nums)  
    rs := make( []int , 2*n )
    for i:=0 ; i<n ; i++ {
        rs[i] = nums[i] 
        rs[i+n] = nums[i]
    }
    return rs 
}