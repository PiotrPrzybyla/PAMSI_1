package com.company;

public class Server {
    public void sendMessage(Sender sender, Recipent recipent, int sizeOfPackage){
        sender.divideMessage(sizeOfPackage);
        try {
            sender.setMessageList(sender.getMessageList().shuffle());
        } catch (EmptyException e) {
            System.out.println(e.getMessage());
        }
        recipent.getMessage(sender.getMessageList());

    }
}
