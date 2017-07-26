static boolean judgePrime(int n) {
        boolean flag = true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

【素数打表】
static void primeTable() {
		Arrays.fill(num, true);
		int sq = (int)Math.sqrt(MAXN);
		for(int i = 2; i < sq; i++) {
			for(int j = i + i; j < MAXN; j += i) 
				num[j] = false;
		}
	}    