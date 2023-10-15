package com.pluralsight;

import java.util.Scanner;

public class mainBook {
    public static void main(String[] args) {
        Book[] books = new Book[5];
                    //10001, "1234567890123","The Princess Bride", true,"yes");
        books[0] =new Book(10001, "1234567890123","The Princess Bride", true,"yes");
        books[1] =new Book(10002, "1234567890123","The Princess Bride", true,"yes");
        books[2] =new Book(10003, "1234567890123","The Princess Bride", true,"yes");
        books[3] =new Book(10004, "1234567890123","The Princess Bride", true,"yes");
        books[4] =new Book(10005, "1234567890123","The Princess Bride", true,"yes");


        Scanner scanner =  new Scanner(System.in);
        int choice = 0;


        while (choice != 3) {
            System.out.println("\n\n\n1. Show Available Books\n");
            System.out.println("2. Show Checked Out Books\n");
            System.out.println("3. Exit - closes out of the application\n");
            System.out.println("Choose one of the above: ");
            choice = scanner.nextInt();

            switch (choice){
                case  1:
                    System.out.println("You choose Number one:");
                    for (int x =0; x < 5; x++){
                        System.out.println(books[x].getTitle());
                    }
                    break;
                case 2:
                    System.out.println("I'm case two");
                break;
            }
        }

    }
}
