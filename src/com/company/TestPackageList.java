package com.company;


public class TestPackageList  {
    public static void main(String[] args)  {
        PackageList testPackage = new PackageList();
        int[] keys = {1,2,3,4,5,6};
        String[] values = {"a", "b", "c", "d", "e", "f"};
        for (int i = 0; i < keys.length ; i++) {
            testPackage.insert(keys[i], values[i]);
        }
        try{
//            testPackage.showPackageList();
            testPackage = testPackage.shuffle();
            testPackage.showPackageList();
            System.out.println("Po sortowaniu");
            testPackage = testPackage.sort();
            testPackage.showPackageList();



        } catch (EmptyException e){
            System.out.println(e.getMessage());
        }

    }
}
