package Lesson1;

import sun.util.resources.LocaleData;

import java.util.Random;

public class Fruit {
    float mass;
    String name;
    long id;

    public void setMass(float mass) {
        this.mass = mass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getMass() {
        return mass;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }
}

class Apple extends Fruit{

    public Apple() {
        setMass(1.0f);
        setName("Apple");
        Random random = new Random();
        setId( random.nextLong() ) ;
    }
}

class Orange extends Fruit{
    public Orange(){
        setMass(1.5f);
        setName("Orange");
        Random random = new Random();
        setId( random.nextLong() ) ;
    }
}


