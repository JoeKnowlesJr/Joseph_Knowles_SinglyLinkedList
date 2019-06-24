package com.danasoft.singlylinkedlists;

import java.util.Scanner;

public class Main {
    private static Scanner scanner;

    public static void main(String[] args) {
        String input;
        scanner = new Scanner(System.in);
        clearScreen();
        System.out.println("\r\n\r\n\t\t\t--------------------\r\n\t\t\t|Singly Linked List|\r\n\t\t\t--------------------\r\n\r\n");
        pressEnterToContinue(true);
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.add(3);
        sll.printValues();
        pressEnterToContinue(true);
        sll.add(4);
        sll.printValues();
        pressEnterToContinue(true);
        sll.add(10);
        sll.printValues();
        pressEnterToContinue(true);
        sll.add(5);
        sll.printValues();
        pressEnterToContinue(true);
        sll.add(15);
        sll.printValues();
        pressEnterToContinue(true);
        sll.add(2);
        sll.printValues();
        pressEnterToContinue(true);
        sll.remove();
        sll.printValues();
        pressEnterToContinue(true);
        sll.remove();
        sll.printValues();
        pressEnterToContinue(false);
        input = getInput("\n\n\tEnter value to search:", true);
        Node node = sll.find(Integer.parseInt(input));
        if (node == null) {
            System.out.printf("No node found that contains the value: %s", input);
        } else {
            System.out.printf("Node found: %d, next node: %d", node.value, node.next.value);
        }
        pressEnterToContinue(false);
        input = getInput("\n\n\tEnter position to delete:", true);
        int result = sll.removeAt(Integer.parseInt(input));
        if (result == -1) {
            System.out.printf("Node not found: %s", input);
        } else {
            System.out.println("Deleted!");;
        }
        sll.printValues();

        scanner.close();
    }

    private static void pressEnterToContinue(boolean clr) {
        System.out.println("\r\n\tPress <ENTER> to continue...");
        scanner.nextLine();
        if (clr)
            clearScreen();
    }

    private static void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception ex) {
        }
    }

    private static String getInput(String msg, boolean nums) {
        System.out.println(msg);
        String input = scanner.nextLine();
        if (nums) {
            return input.replaceAll("[^\\d.]", "");
        }
        return input;
    }
}
