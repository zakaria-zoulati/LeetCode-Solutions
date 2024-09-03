class Solution {
    void findNotPrime(boolean[] notPrime, int n){
	for (int p = 2; p * p <= n; p++) {
		if (notPrime[p] == false) {
			for (int i = p * p; i <= n; i += p)
				notPrime[i] = true;
		}
	}
}

public int nonSpecialCount(int l, int r) {
	int limit = (int)Math.sqrt(r);
	boolean[] notPrime = new boolean[limit+1];
	findNotPrime(notPrime, limit);
	int special = 0, i = 2, last = 4;
	while(last <= r) {
		if(notPrime[i] == false) {
			if(last >= l) special++;
		}
		i++;
		last = i*i;
	}

	return (r-l+1)-special;
}
}
