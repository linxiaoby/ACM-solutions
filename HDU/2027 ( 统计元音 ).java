import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        n = Integer.valueOf(in.nextLine());
        String str;
        char[] a = {'a', 'e', 'i', 'o', 'u'};
        int[] cnt = new int[5 + 3];
        
        for(int i = 0; i < n; i++) {
            str = in.nextLine();
            cnt[0] = cnt[1] = cnt[2] = cnt[3] = cnt[4] = 0;
            for (int j = 0; j < str.length(); j++) {
                switch (str.charAt(j)) {
                case 'a':
                    cnt[0]++;
                    break;
                case 'e':
                    cnt[1]++;
                    break;
                case 'i':
                    cnt[2]++;
                    break;
                case 'o':
                    cnt[3]++;
                    break;
                case 'u':
                    cnt[4]++;
                    break;
                default:
                    break;
                }
            }
            
            if(i != 0)
                System.out.println();
            for(int t = 0; t < 5; t++)
                System.out.println(a[t] + ":" + cnt[t]);
        }
    }
}