class Bank {
    long[] balance ; 
    int n ; 
    public Bank(long[] balance) {
        this.balance = balance ; 
        this.n = balance.length ; 
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if( account1 < 0 || account1 > n ) return false ; 
        if( account2 < 0 || account2 > n ) return false ; 
        if( money > balance[account1-1] ) return false ; 
        balance[ account1 - 1 ] -= money ;  
        balance[ account2 - 1 ] += money ;  
        return true ; 
    }
    
    public boolean deposit(int account, long money) {
        if( account < 0 || account > n ) return false ; 
        balance[account-1] += money ; 
        return true ; 
    }
    
    public boolean withdraw(int account, long money) {
        if( account < 0 || account > n ) return false ; 
        if( balance[account-1] < money ) return false ; 
        balance[account-1] -= money ; 
        return true ;  
    }
}
