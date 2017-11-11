package be.pxl.collections.linkedlist;

import java.util.Scanner;

public class BrowserUsage {

    public static void main(String[] args) {
        Browser browser = new Browser();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give url, BACK, FWD or STOP");
        String input = scanner.nextLine();
        while(!"STOP".equals(input.toUpperCase())) {
            switch (input) {
                case "BACK": browser.back(); break;
                case "FWD": browser.forward(); break;
                default: browser.visit(input);
            }
            browser.showCurrentPage();
            System.out.println("Give url, BACK or FWD");
            input = scanner.nextLine();
        }
        scanner.close();
    }
}
