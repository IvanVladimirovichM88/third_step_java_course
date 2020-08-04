package Lesson1;

import sun.dc.path.FastPathProducer;

import java.util.ArrayList;
import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {

        Integer[] iArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] sArr = {"a","b","c","d","e","f","g","h",};

        MyArray intArr = new MyArray(iArr);
        MyArray strArr = new MyArray(sArr);

        intArr.print();
        intArr.change(1,7);
        intArr.print();

        strArr.print();
        strArr.change(1,7);
        strArr.print();


        ArrayList<Object> stringArrayList = new ArrayList<Object>();
        stringArrayList = strArr.convert();

        System.out.println(stringArrayList);



        //проверка третьего задания
        Basket<Apple> appleBasket = new Basket<Apple>();
        Basket<Apple> appleBasket1 = new Basket<Apple>();
        Basket<Orange> orangeBasket = new Basket<Orange>();

        for(int i=0 ; i<10; i++){
            appleBasket.addFruit( new Apple() );
            orangeBasket.addFruit( new Orange() );
        }

        for (int i=0;i<5;i++){
            appleBasket1.addFruit(new Apple());
        }

        System.out.println("масса яблок в первой корзине - " + appleBasket.getWeight());
        System.out.println("масса яблок во второй корзине - " + appleBasket1.getWeight());
        System.out.println("масса апельсинов в третьей корзине - " + orangeBasket.getWeight());

        System.out.println("сравниваем вес коробки яблок и апельсинов - " + appleBasket.compare(orangeBasket));

        //пересыпаем яблоки из коробки в коробку
        appleBasket.transfer(appleBasket1);
        System.out.println("масса яблок во второй корзине - " + appleBasket1.getWeight());

        System.out.println("сравниваем вес коробки яблок и апельсинов - " + appleBasket1.compare(orangeBasket));

        System.out.println("количество яблок в appleBasket1 - " + appleBasket.getAmountOfFruit());

    }
}

class MyArray{
    Object[] array;

    public MyArray(Object[] array) {
        this.array = array;
    }

    public void print(){
        System.out.print("[ ");
        for (int i=0; i<array.length-1; i++){
            System.out.print( array[i] + ",  ");
        }
        System.out.print(array[array.length-1]+" ]");
        System.out.println();
    }
    //меняет элементы с заданными индексами метсами
    public void change(int index1, int index2){

        if ( (index1 < 0) || (index2<0) || (index2>array.length) || (index1>array.length) ){
            System.out.println("индексы выходят за гарницы массива");
            return;
        }

        Object temp= array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    //преобразует массив в ArrayList
    public ArrayList<Object> convert(){

        ArrayList<Object> arrayList = new ArrayList<Object>();

        arrayList.addAll(Arrays.asList(array));

        return arrayList;
    }
}
