import java.util.Scanner;

public class Main {
    static boolean judgeLeap(int year) {
        return (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] leapMon = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int[] mon = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int year, month, day, ans;
        String str;
        while (in.hasNext()) {
            ans = 0;
            str = in.next();
            String[] strs = str.split("/");
            year = Integer.valueOf(strs[0]);
            month = Integer.valueOf(strs[1]);
            day = Integer.valueOf(strs[2]);
            for (int i = 1; i < month; i++) {
                if (judgeLeap(year)) {
                    ans += leapMon[i];
                } 
                else {
                    ans += mon[i];
                }
            }
            ans += day;
            System.out.println(ans);
        }
    }
}