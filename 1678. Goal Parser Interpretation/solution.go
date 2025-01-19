package solution 

func interpret(command string) string {
    n := len(command) 
    rs := ""
    for i:=0 ; i<n ;  {
        if command[i] == 'G' {
            rs = rs + "G" 
            i++  
        }else if( command[i+1] == ')' ){
            rs = rs + "o" 
            i += 2
        }else {
            rs = rs + "al" 
            i += 4
        }
    }
    return rs 
}
