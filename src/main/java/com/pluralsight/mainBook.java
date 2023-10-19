package com.pluralsight;

import java.util.Scanner;

public class mainBook {
    public static void main(String[] args) {
        Book[] books = new Book[5];
        books[0] = new Book(10001, "1234567890123", "The Princess Bride", false,"amjad");
        books[1] = new Book(10002, "1234567890123", "The Hobbit", false, "amjad");
        books[2] = new Book(10003, "1234567890123", "To Kill a Mockingbird", false,"amjad");
        books[3] = new Book(10004, "1234567890123", "1984", true, "amjad");
        books[4] = new Book(10005, "1234567890123", "The Catcher in the Rye", true,"amjad");

        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            theMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    showAvailableBooks(books);
                    int selectedBook = selectBook(books);
                    if (selectedBook != -1) {
                        System.out.print("Enter your name: ");
                        scanner.nextLine();
                        String userName = scanner.nextLine();
                        books[selectedBook].checkOut(userName);
                        System.out.println("You have checked out: " + books[selectedBook].getTitle());
                    }
                    break;
                case 2:
                    showCheckedOutBooks(books);
                    break;
                case 3:
                    System.out.println("Exiting the application.");
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    public static void theMenu() {
        System.out.println("\n\n1. Show Available Books");
        System.out.println("2. Show Checked Out Books");
        System.out.println("3. Exit - Close the application");
        System.out.print("Choose one of the above: ");
    }

    public static void showAvailableBooks(Book[] books) {
        System.out.println("Available Books:");
        for (int i = 0; i < books.length; i++) {
            if (!books[i].getCheckedOut()) {
                System.out.println(i + 1 + ". " + books[i].getId() + " " + books[i].getIsbn() + " " + books[i].getTitle());
            }
        }
    }

    public static void showCheckedOutBooks(Book[] books) {
        System.out.println("Checked Out Books:");
        for (int i = 0; i < books.length; i++) {
            if (books[i].getCheckedOut()) {
                System.out.println(i + 1 + ". " + books[i].getId() + " " + books[i].getIsbn() + " " + books[i].getTitle() + " (Checked Out to: " + books[i].getCheckedOutTo() + ")");
            }
        }
    }

    public static int selectBook(Book[] books) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select a book to check out (or enter 0 to return to the menu): ");
        int choice = scanner.nextInt();
        if (choice >= 1 && choice <= books.length && !books[choice - 1].getCheckedOut()) {
            return choice - 1;
        } else {
            System.out.println("Invalid choice or book is already checked out.");
            return -1;
        }
    }
}
