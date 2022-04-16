package com.company;

public class Recipent {
    private PackageList messageList;
    public void getMessage(PackageList sentPackage){
        messageList = sentPackage.sort();
        try {
            messageList.showPackageList();
        } catch (EmptyException e) {
            System.out.println(e.getMessage());
        }

    }
}
