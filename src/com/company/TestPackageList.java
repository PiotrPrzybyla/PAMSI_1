package com.company;


public class TestPackageList {
    public static void main(String[] args){
        PackageList testPackage = new PackageList();
        int[] keys = {5,2,7,34,1,23,9};
        String[] values = {"a", "b", "c", "d", "e", "f"};
        for (int i = 0; i < keys.length - 1; i++) {
            testPackage.insert(keys[i], values[i]);
        }

    }
}
