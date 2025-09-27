package ps2.clinica_app;

import java.util.Scanner;

public class ES {
    private static final Scanner sc = new Scanner(System.in);

    public static String input(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }

    public static void print(String msg) {
        System.out.println(msg);
    }
}
