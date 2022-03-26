package com.company;

public class PackageList {

    private Package head, tail;
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
    public void popHead() throws EmptyException {
        if(size == 0){
            throw new EmptyException("No packages!");
        }else{
            head.previousPackage.nextPackage = null;
            head = head.previousPackage;

        }
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
