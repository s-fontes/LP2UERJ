package P2n.utils;

import java.util.Scanner;

public final class Input {
    public static String get(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.nextLine();
    }
}
