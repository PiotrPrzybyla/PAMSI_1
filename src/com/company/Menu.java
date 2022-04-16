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
        server.sendMessage(sender, recipient, packageSize);





    }

}
