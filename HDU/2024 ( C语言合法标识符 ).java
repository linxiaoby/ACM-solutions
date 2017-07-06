import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str;
        int n;
        boolean flag;
        while(in.hasNext()) {
            n = Integer.valueOf(in.nextLine());
            for(int i = 0; i < n; i++) {
                str = in.nextLine();
                flag = true;
                if(str.charAt(0) >= '0' && str.charAt(0) <= '9') {
                    System.out.println("no");
                    continue;
                }
                for(int j = 0; j < str.length(); j++) {
                    char ch = str.charAt(j);
                    if(!((ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'Z') 
                      || (ch >= 'a' && ch <= 'z') || (ch == '_') )) {
                        System.out.println("no");
                        flag = false;
                        break;
                    }
                }
                if(flag)
                    System.out.println("yes");
            }
        }
    }
}