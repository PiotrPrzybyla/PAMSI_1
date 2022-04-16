package com.company;

public class Recipient {
    private PackageList messageList;
    public void getMessage(PackageList sentPackage){
        messageList = sentPackage.sort();
        try {
            messageList.showPackageList();
        } catch (EmptyException e) {
            System.out.println(e.getMessage());
        }

    }
    public String getStringMessage(PackageList sentPackage){
        messageList = sentPackage.sortTest();

        try {
         return messageList.makeString();
        } catch (EmptyException | CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

}
