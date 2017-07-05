import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        while (in.hasNext()) {
            n = in.nextInt();
            if(n >= 90 && n <= 100) {
                System.out.println("A");
            }
            else if(n >= 80 && n <= 89) {
                System.out.println("B");
            }
            else if(n >= 70 && n <= 79) {
                System.out.println("C");
            }
            else if(n >= 60 && n <= 69) {
                System.out.println("D");
            }
            else if(n >= 0 && n <= 59) {
                System.out.println("E");
            }
            else {
                System.out.println("Score is error!");
            }
        }
    }
}