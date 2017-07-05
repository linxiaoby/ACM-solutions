import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, cnt1, cnt2, cnt3, cnt4, cnt5;
        n = Integer.valueOf(in.nextLine());
        String str;
        for(int i = 0; i < n; i++) {
            str = in.nextLine();
            cnt1 = cnt2 = cnt3 = cnt4 = cnt5 = 0;
            for (int j = 0; j < str.length(); j++) {
                switch (str.charAt(j)) {
                case 'a':
                    cnt1++;
                    break;
                case 'e':
                    cnt2++;
                    break;
                case 'i':
                    cnt3++;
                    break;
                case 'o':
                    cnt4++;
                    break;
                case 'u':
                    cnt5++;
                    break;
                default:
                    break;
                }
            }
            
            if(i != 0)
                System.out.println();
            System.out.println("a:" + cnt1);
            System.out.println("e:" + cnt2);
            System.out.println("i:" + cnt3);
            System.out.println("o:" + cnt4);
            System.out.println("u:" + cnt5);
        }
    }
}