package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class PackageList implements Cloneable{

    private Package head, tail;

    public Package getHead() {
        return head;
    }

    public void setHead(Package head) {
        this.head = head;
    }

    public Package getTail() {
        return tail;
    }

    public void setTail(Package tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    //length of the list
    private int size;



    public PackageList() {
        size = 0;
        head = new Package();
        tail = new Package();
    }

    //check if is empty
    public boolean isEmpty(){
        return(size == 0);
    }

    // insert a new package
    public void insert(int key, String value){

    if(isEmpty()){
           head = tail = new Package(key, value);
    }
//           System.out.println(tmp.value);
    else {
        Package newPackage = new Package(key,value, head);
        head.nextPackage = newPackage;
        head = newPackage;

    }
//        System.out.println("Head: " + head.value);
  //      System.out.println("Tail: " + tail.value);


        ++size;


    }
    public Package popHead() throws EmptyException{
        if(size == 0){
            throw new EmptyException("No packages!");
        }
        if (size>1) {
            int key = head.key;
            String value = head.value;
            Package tempPackage = new Package(key, value);
            head.previousPackage.nextPackage = null;
            head = head.previousPackage;
            --size;
            return tempPackage;
        }
        else{
            int key = head.key;
            String value = head.value;
            Package tempPackage = new Package(key, value);
            head = null;
            tail = null;
            size = 0;
//            --size;
            return tempPackage;
        }
    }
    public Package peekHead() throws EmptyException{
        if(size == 0){
            throw new EmptyException("No packages!");
        }else{
            int key = head.key;
            String value = head.value;
            Package tempPackage = new Package(key, value);
            return  tempPackage;
        }
    }
    public void showPackageList() throws EmptyException{
        if(size == 0){
            throw new EmptyException("No packages!");
        }else {

            try{
                PackageList tempPackageList = (PackageList) this.clone();
                for (int i = 0; i < size; i++) {
                    Package tempPackage = tempPackageList.popHead();
                    System.out.println("Key: " + tempPackage.key + " . Value: " + tempPackage.value);
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }


        }
    }

    public PackageList shuffle() throws EmptyException {
        if(size == 0){
            throw new EmptyException("No packages!");
        }else{

            ArrayList<Integer> numbers = new ArrayList<Integer>();
            for (int i = 0; i < size ; i++) {
                numbers.add(i+1);
            }
            Collections.shuffle(numbers);
           PackageList shuffledPackage = new PackageList();
           try {
               for (int i = 0; i < size; i++) {

                   PackageList tempPackageList = (PackageList) this.clone();

                   int drawnNumber = numbers.remove(0);
                   for (int j = 0; j < size; j++) {
                       Package tempPackage = tempPackageList.popHead();

                       if (tempPackage.getKey() == drawnNumber) {
                           shuffledPackage.insert(tempPackage.getKey(), tempPackage.getValue());

                       }
                   }

               }
           }catch (Exception e){
               System.out.println(e.getMessage());
           }
//           shuffledPackage.showPackageList();
            return shuffledPackage;

        }
    }
    public PackageList sort(){
        PackageList tempPackageList = new PackageList();
        try{
            while(!isEmpty()) {
                Package tempPackage = popHead();
//                tempPackageList.insert(tempPackage.getKey(), tempPackage.getValue());
                while (!tempPackageList.isEmpty() && tempPackageList.peekHead().getKey() < tempPackage.getKey()) {
                    Package tempTempPackage = tempPackageList.popHead();
                    insert(tempTempPackage.getKey(), tempTempPackage.getValue());
                }
                tempPackageList.insert(tempPackage.getKey(), tempPackage.getValue());
            }
        }catch (EmptyException e){
            System.out.println(e.getMessage());
        }

        return tempPackageList;
    }
    private static final class Package {
        // key( number of package)
        private int key;
        // value( content of package)
        private String value;

        private Package nextPackage, previousPackage;

        public Package(int key, String value, Package previousPackage) {
            this.key = key;
            this.value = value;
            this.previousPackage = previousPackage;
            this.nextPackage = null;
        }

        public Package getPreviousPackage() {
            return previousPackage;
        }

        public void setPreviousPackage(Package previousPackage) {
            this.previousPackage = previousPackage;
        }

        public Package getNextPackage() {
            return nextPackage;
        }

        public void setNextPackage(Package nextPackage) {
            this.nextPackage = nextPackage;
        }

        public Package() {
        }

        public Package(int key, String value) {
            this.key = key;
            this.value = value;
            nextPackage = null;
            previousPackage = null;
        }

        // reference to next package
        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;

        }
    }

}
