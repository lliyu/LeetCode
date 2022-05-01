package com.mashibing.queue;

import com.entity.Cat;
import com.entity.Dog;
import com.entity.Pet;

import java.util.ArrayList;
import java.util.List;

public class AnimalQueue<T> {

    private List<T> animals = new ArrayList<>();

    private List<Cat> cats = new ArrayList<>();

    private List<Dog> dogs = new ArrayList<>();

    public boolean add(T t){
        if(t instanceof Dog){
            dogs.add((Dog) t);
        }else if(t instanceof Cat){
            cats.add((Cat) t);
        }
        animals.add(t);
        return true;
    }

    public T pollAll(){
        if (animals.size()>0) {
            T t = animals.get(0);
            if(t instanceof Dog){
                dogs.remove(0);
            }else if(t instanceof Cat){
                dogs.remove(0);
            }
            animals.remove(0);
            return t;
        }else {
            throw new IndexOutOfBoundsException("队列已经空了");
        }
    }

    public T pollDog(){
        if (dogs.size()>0) {
            Dog dog = dogs.get(0);
            int index = 0;
            int len = animals.size();
            while(index<len){
                if(dog == animals.get(index)){
                    T t = animals.remove(index);
                    dogs.remove(0);
                    return t;
                }
                index++;
            }
            return null;
        }else {
            throw new IndexOutOfBoundsException("队列已经空了");
        }
    }

    public static void main(String[] args) {
        AnimalQueue<Pet> animalQueue  = new AnimalQueue<>();
        animalQueue.add(new Cat());
        animalQueue.add(new Dog());
        animalQueue.add(new Dog());

        System.out.println(animalQueue.pollDog());
    }

}
