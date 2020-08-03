package Lesson4;

public class MFU {

    Object printObg = new Object();
    Object scanObg  = new Object();

    public void print (){
        System.out.println("MFU started printing");

        synchronized (printObg){
            System.out.println("MFU is  Printing!");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("MFU finished Printing");
        }

    }

    public void scan (){
        System.out.println("MFU started Scanning");

        synchronized (scanObg){
            System.out.println("MFU is Scanning!");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("MFU finished Scanning");
        }
    }

    public void copy(){
        System.out.println("MFU started Copying");

        synchronized (scanObg){
            System.out.println("MFU is Copying (scan)!");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("MFU finished Copying (scan)!");
        }
        synchronized (printObg){
            System.out.println("MFU is Copying (print)!");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("MFU finished Copying (print)!");
        }
    }
}
