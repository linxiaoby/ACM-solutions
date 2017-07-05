import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str;
        char ch;
        List<Integer> list = new ArrayList<Integer>();
        while(in.hasNext()) {
            str = in.next();
            ch = '0';
            list.clear();
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) > ch) {
                    ch = str.charAt(i);
                }
            }
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == ch)
                    list.add(i);
            }
            for(int i = 0; i < str.length(); i++) {
                System.out.print(str.charAt(i));
                if(list.contains(i))
                    System.out.print("(max)");
            }
            System.out.println();
        }
    }

}