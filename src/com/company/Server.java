package com.company;

public class Server {
    public void sendMessage(Sender sender, Recipient recipent, int sizeOfPackage){
        sender.divideMessage(sizeOfPackage);
        try {
            sender.setMessageList(sender.getMessageList().shuffle());
        } catch (EmptyException e) {
            System.out.println(e.getMessage());
        }
        recipent.getMessage(sender.getMessageList());

    }
    public String testMessage(Sender sender, Recipient recipent, int sizeOfPackage){
        sender.testDivideMessage(sizeOfPackage);
        try {
            sender.setMessageList(sender.getMessageList().shuffle());
        } catch (EmptyException e) {
            System.out.println(e.getMessage());
        }
        return recipent.getStringMessage(sender.getMessageList());

    }

}
