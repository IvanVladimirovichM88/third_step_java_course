package Lesson5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class  MainClass {
    public static final int CARS_COUNT = 4;
    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        Race race = new Race(new Road(60), new Tunnel( (int)(CARS_COUNT/2) ), new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }

        Thread[] myThreads = new Thread[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
              myThreads[i] = new Thread(cars[i]);
              myThreads[i].start();
        }

        for (int i=0; i<cars.length;i++){
            try {
                myThreads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("ПОБЕДИТЕЛЕМ ГОНКИ СТАНОВИТЬСЯ >>>> " +  Car.getFirstCar());

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");


    }
}

class Car implements Runnable {
    private static int CARS_COUNT;
    private static CountDownLatch cdl;//для подновременного старта
    private static String firstCar;
    private static Lock lockFinish;

    static {
        CARS_COUNT = 0;

        cdl = null;
        firstCar = null;
        lockFinish = null;
    }

    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public static Lock getLockFinish() {
        return lockFinish;
    }

    public static String getFirstCar() {
        return firstCar;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;

    }

    @Override
    public void run() {
        if (cdl == null) {
            cdl = new CountDownLatch(CARS_COUNT);
        }

        if (lockFinish == null){
            lockFinish = new ReentrantLock();
        }

        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cdl.countDown();
            if (cdl.getCount() == 0){
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // ждем пока все приготовятся
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        try {
            lockFinish.lock();
            if(firstCar == null){ //определяем имя победителя
                firstCar = this.name;
            }
        }finally {
            lockFinish.unlock();
        }

    }
}
abstract class Stage {
    protected int length;
    protected String description;

    public String getDescription() {
        return description;
    }
    public abstract void go(Car c);
}

class Road extends Stage {

    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Tunnel extends Stage {
    private int maxCarsIn;
    private Semaphore smp;

    public Tunnel(int maxCarsIn ) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        this.maxCarsIn = maxCarsIn;
        smp = new Semaphore(maxCarsIn);
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                smp.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                smp.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class Race {
    private ArrayList<Stage> stages;
    public ArrayList<Stage> getStages() { return stages; }
    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }
}

