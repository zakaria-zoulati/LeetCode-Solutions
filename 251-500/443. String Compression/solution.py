class Solution:
    def compress(self, chars: List[str]) -> int:
        n = len( chars ) 
        write = 0 
        i = 0 
        while i < n : 
            c = chars[i]
            curr = 1 
            while i+1<n and chars[i+1] == chars[i] : 
                i += 1
                curr += 1 
            chars[write] = c 
            write += 1 
            if curr > 1 :
                for digit in str( curr ) : 
                    chars[write] = digit 
                    write += 1 
            i += 1 
        return write  
