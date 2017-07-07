    /*用f(n)表示n个格子首尾两格不同的种类数
    用s(n)表示不区分首尾两格不同的所有种类数, s(n) = 3 * Math.pow(2, i - 1);


    第n - 1 个格子的颜色如果与第1个不同，那么第n个就只有1种涂法，否则有2种涂法。
    在考虑第n个格子时，将第n - 1个格子的涂法分为两种：
        1）与第1个颜色不同；==》f(n - 1)种 ==》对应第n个的涂法是 f(n - 1) * 1
        2）与第1个颜色不同。==》(s(n - 1) - f(n - 1))种 ==》对应第n个的涂法是 (s(n - 1) - f(n - 1)) * 2

    f(n) = f(n - 1) * 1 + (s(n - 1) - f(n - 1)) * 2
         = f(n - 1) * 1 + (3 * Math.pow(2, i - 2) - f(n - 1)) * 2
         = 3 * Math.pow(2, i - 2) - f(n - 1)*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        long[] a = new long [51];
        a[1] = 3; a[2] = 6;
        for(int i = 3; i <= 50; i++)
            a[i] =  (long) (a[i - 1] + (3 * Math.pow(2, i - 2) - a[i - 1]) * 2);
        
        Scanner in = new Scanner(System.in);
        int n;
        while(in.hasNext()) {
            n = in.nextInt();
            System.out.println(a[n]);
        }
    }
}


