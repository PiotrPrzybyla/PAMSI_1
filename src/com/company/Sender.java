package com.company;

import java.util.Scanner;

public class Sender {
    private String message;
    private PackageList messageList;

    public Sender() {
        messageList = new PackageList();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



    public PackageList getMessageList() {
        return messageList;
    }

    public void setMessageList(PackageList messageList) {
        this.messageList = messageList;
    }


    public void writeMessage(){
        Scanner scanner = new Scanner(System.in);
        message = scanner.nextLine();
    }

    public void divideMessage(int size) {

        String tempMessage=message;
        String partOfMessage;
        int iterator = 1;
        while(tempMessage!=null){
            if(tempMessage.length()>size){

                partOfMessage=tempMessage.substring(0, size);
                tempMessage=tempMessage.substring(size);
                messageList.insert(iterator, partOfMessage);
                ++iterator;

            } else{
                messageList.insert(iterator++, tempMessage);
                tempMessage=null;
            }
        }
        if(iterator > 1){
            System.out.println("Your message is too big. It will be sent in " + (iterator -1) + " packages");
        }
    }
    public void testDivideMessage(int size) {

        String tempMessage=message;
        String partOfMessage;
        int iterator = 1;
        while(tempMessage!=null){
            if(tempMessage.length()>size){

                partOfMessage=tempMessage.substring(0, size);
                tempMessage=tempMessage.substring(size);
                messageList.insert(iterator, partOfMessage);
                ++iterator;

            } else{
                messageList.insert(iterator++, tempMessage);
                tempMessage=null;
            }
        }

    }



}
