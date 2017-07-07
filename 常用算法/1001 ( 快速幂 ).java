/*
非递归：
若b为奇数：
	a^b = a * a^(b - 1)
若b为偶数：
	a^b = (a^2)^b/2

*/
static int qmod(int a, int b) {
    	int res = 1;
    	while(b != 0) {
    		if((b&1) == 1) res *= a;
    		b >>= 1;
    		a = a * a;
    	}
        return res;
    }

/*
递归：
若b为奇数：
	a^b = a^(b - 1) * b
若b为偶数：
	a^b = (a^(b/2))^2

*/
static int qmod(int a, int b, int mod) {
        if(b == 1)
            return a % mod;
        else if(b == 0)
            return 1;
        
        int s;
        s = qmod(a, b>>1, mod);
        s = s * s % mod;
        if((b & 1) != 0) 
            s = s * a % mod;
        return s;
    }
    