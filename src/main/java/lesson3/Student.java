package lesson3;

import java.io.Serializable;

public class Student implements Serializable {
    String name;
    int count;

    public Student(String name,int count){
        this.name = name;
        this.count = count;
    }

    public void info(){
        System.out.println(name + "\t" + count);
    }

}
