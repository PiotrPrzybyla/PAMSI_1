package com.company;

import java.util.Scanner;

public class Menu {
    public Menu() {
        Sender sender = new Sender();
        Recipient recipient = new Recipient();
        Server server = new Server();
        Scanner scanner = new Scanner(System.in);
        int packageSize;
        System.out.println("Welcome in program to send messages");
        System.out.println("What size would you have your package: ");
        packageSize = scanner.nextInt();
        System.out.println("Write your Message: ");
        sender.writeMessage();
        System.out.println("Message is divided to packages, shuffled, and send to recipient");
        System.out.println("Message is sorted and taken by the recipient. Sorting algorithm was:  ");
        System.out.println("");
        server.sendMessage(sender, recipient, packageSize);





    }

}
