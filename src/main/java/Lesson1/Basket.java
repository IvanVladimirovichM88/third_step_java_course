package Lesson1;

import java.util.ArrayList;

public class Basket<T extends Fruit> {
    ArrayList<T> arrayList;

    public Basket() {
        this.arrayList = new ArrayList<T>();
    }

    public void addFruit (T fruit){
        arrayList.add(fruit);
    }

    public float getWeight(){
        float weight = 0.0f;
        for (T o : arrayList) {
            weight += o.getMass();
        }
        return weight;
    }

    public boolean compare(Basket<?> box){
        return Math.abs(this.getWeight() - box.getWeight()) < 0.001;
    }

    //пересыпает из козины this в корзину box
    public void transfer(Basket<T> box){
        for (T o : arrayList) {
            box.addFruit(o);
        }
        arrayList.clear();
    }

    public int getAmountOfFruit(){
        return arrayList.size();
    }
}
