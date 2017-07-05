import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str;
        String[] strList =  new String[100 + 3];
        while(in.hasNextLine()) {
            str = in.nextLine();
            strList = str.split(" ");
            for (int j = 0; j < strList.length; j++) {
                String s = strList[j];
                char[] chs = s.toCharArray();
                chs[0] = (char) (chs[0] - 32);
                if(j != 0)
                    System.out.print(" ");
                for(int i = 0; i < chs.length; i++) {
                    System.out.print(chs[i]);
                }
             }
            System.out.println();
        }
    }
}