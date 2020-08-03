package Lesson4;

import java.util.concurrent.TransferQueue;

public class MainClass {

    public static void main(String[] args) {

        final PrintLetter printLetter= new PrintLetter();
        Thread threadPrintA = new Thread(new Runnable() {
            @Override
            public void run() {
                printLetter.printA();
            }
        });

        Thread threadPrintB = new Thread(new Runnable() {
            @Override
            public void run() {
                printLetter.printB();
            }
        });

        Thread threadPrintC = new Thread(new Runnable() {
            @Override
            public void run() {
                printLetter.printC();
            }
        });

        threadPrintA.start();
        threadPrintB.start();
        threadPrintC.start();

    }

}

class PrintLetter{
    private final Object mon = new Object();
    private volatile char currentLetter = 'A';
    private final  int MAX = 5;

    public void printA(){
        synchronized (mon){
            try {
                for (int i=0; i<MAX; i++){
                    while(currentLetter != 'A'){
                        mon.wait();
                    }
                    System.out.println('A');
                    currentLetter = 'B';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void printB(){
        synchronized (mon){
            try {
                for (int i=0; i<MAX; i++){
                    while(currentLetter != 'B'){
                        mon.wait();
                    }
                    System.out.println('B');
                    currentLetter = 'C';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void printC(){
        synchronized (mon){
            try {
                for (int i=0; i<MAX; i++){
                    while(currentLetter != 'C'){
                        mon.wait();
                    }
                    System.out.println('C');
                    currentLetter = 'A';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}