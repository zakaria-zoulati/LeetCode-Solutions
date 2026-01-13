package solution 

func shuffle(nums []int, n int) []int {
    rs := make( []int , 2*n ) 
    curr := 0
    for i:=0 ; i<2*n ; i+=2 {
        rs[i+1] = nums[curr+n]
        rs[i] = nums[curr]
        curr++
    }
    return rs 
}
