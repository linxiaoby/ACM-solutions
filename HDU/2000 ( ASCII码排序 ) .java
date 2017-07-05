import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Character> list = new ArrayList<Character>();
            while (in.hasNext()) {
                list.clear();
                String str = in.next();
                for (int i = 0; i < str.length(); i++) {
                    char ch = str.charAt(i);
                    boolean flag = false;
                    for(int j = 0; j < list.size(); j++) {
                        if(list.get(j) > ch) {
                            list.add(j, ch);
                            flag = true;
                            break;
                        }
                    }
                    if(list.size() == 0 || !flag) {
                        list.add(ch);
                    }
                }
                for (int i = 0; i < list.size(); i++) {
                    System.out.print(list.get(i));
                    if(i != list.size() - 1) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
    }
}