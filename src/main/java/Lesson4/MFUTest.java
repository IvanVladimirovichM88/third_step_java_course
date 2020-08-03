package Lesson4;

public class MFUTest {

    public static void main(String[] args) {
        final  MFU mfu = new MFU();

        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.print();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.copy();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.scan();
            }
        }).start();

    }

}
