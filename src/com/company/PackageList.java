package com.company;


public class PackageList implements Cloneable{


    //head and tail of the list
    private Package head, tail;
    //length of the list
    private int size;


    //getters and setters
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




    //constructor with no arguments
    public PackageList() {
        size = 0;
        head = new Package();
        tail = new Package();
    }

    //check if is empty
    public boolean isEmpty(){
        return(size == 0);
    }

    // insert a new package to head of list
    public void insert(int key, String value){
    // check if is empty
    if(isEmpty()){
           head = tail = new Package(key, value);
    }
    // if not empty then insert key and value to head
    else {
        Package newPackage = new Package(key,value, head);
        head.nextPackage = newPackage;
        head = newPackage;

    }
    // increase size
        ++size;
    }

    // Pop an element from head
    public Package popHead() throws EmptyException{
        if(isEmpty()){
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
        if(isEmpty()){
            throw new EmptyException("No packages!");
        }else{
            Package tempPackage = new Package(head.key, head.value);
            return  tempPackage;
        }
    }
    public void showPackageList() throws EmptyException{
        if(isEmpty()){
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
        if(isEmpty()){
            throw new EmptyException("No packages!");
        }else{


           PackageList shuffledPackage = new PackageList();
            int[] usedNumbers = new int[size];
           try {
               for (int i = 0; i < size; i++) {

                   PackageList tempPackageList = (PackageList) this.clone();

                   int drawnNumber = (int)((Math.random() * size) + 1);
                   for ( int k=0; k<size; k++) {
                       if(usedNumbers[k] == drawnNumber){
                           drawnNumber = (int)((Math.random() * size) + 1);
                           k=-1;
                       }
                   }
                    usedNumbers[i] = drawnNumber;

                   for (int j = 0; j < size; j++) {
                       Package tempPackage = tempPackageList.popHead();

                       if (tempPackage.getKey() == drawnNumber) {
                           shuffledPackage.insert(tempPackage.getKey(), tempPackage.getValue());

                       }
                   }

               }
//               for (int usedNumber : usedNumbers) {
//                   System.out.println(usedNumber);
//               }
           }catch (Exception e){
               System.out.println(e.getMessage());
           }

            return shuffledPackage;

        }
    }
    public String makeString() throws CloneNotSupportedException, EmptyException {
        PackageList temp = (PackageList) (this.clone());
        String message = "";
        for (int i = 0; i < size; i++) {
            message = (message + temp.popHead().value );
        }
        return message;
    }
    public PackageList sort(){
        PackageList tempPackageList = new PackageList();
        int sortCounter = 0;
        try{
            while(!isEmpty()) {
                sortCounter++;
                Package tempPackage = popHead();
                System.out.println("");
                System.out.println("-------------------------------------");
                System.out.println("");
                System.out.println("Taking element - Key: " + tempPackage.key + ", Value: " + tempPackage.value);
                int tempPackageHead = 0;
                if(!tempPackageList.isEmpty()){

                    System.out.println("");
                    System.out.println("-------------------------------------");
                    System.out.println("");
                    System.out.println("Checking where element belongs");
                     tempPackageHead = tempPackageList.peekHead().getKey();
                }

                while (!tempPackageList.isEmpty() && tempPackageList.peekHead().getKey() < tempPackage.getKey()) {
                    sortCounter++;
                    System.out.println("");
                    System.out.println(tempPackageList.peekHead().getKey() + " is less than " + tempPackage.getKey() + " so it is not place where our element belong");
                    System.out.println("We should take " + tempPackageList.peekHead().getKey() + " element, and throw it back to shuffled list");
                    Package tempTempPackage = tempPackageList.popHead();
                    insert(tempTempPackage.getKey(), tempTempPackage.getValue());
                    System.out.println("");
                }

                if (tempPackageList.isEmpty()){
                    System.out.println("That is first element so we can put it here");
                }else{
                    System.out.println( tempPackage.getKey() + " is less than " + tempPackageHead +" so that's the place where our element belong");
                }
                tempPackageList.insert(tempPackage.getKey(), tempPackage.getValue());
            }
        }catch (EmptyException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Sorting loop was iterating " + sortCounter + " times");
        return tempPackageList;
    }

    public PackageList sortTest(){
        PackageList tempPackageList = new PackageList();
        try{
            while(!isEmpty()) {

                Package tempPackage = popHead();



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


