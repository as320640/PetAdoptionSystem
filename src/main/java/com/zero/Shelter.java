package com.zero;

import java.io.*;
import java.util.*;

public class Shelter implements Serializable {

    private static final long serialVersionUID = -5912640294945955328L;
    private final int CNT =10;//容量
    private final ArrayList <Animal> list =new ArrayList<>();//地址不变
    private final HashMap<String,Animal> hashMap=new HashMap<>();
    private final HashSet<String> color=new HashSet<>();


    public Shelter(){}

    public boolean listIsEmpty(){//判断list是否为空
        return list.isEmpty();
    }


    public void addAnimal(Animal animal) {
        if(list.size()>=CNT){
            throw new ShelterFullException();
        }

        else if(hashMap.containsKey(animal.getName())){//结构体执行，表示有重名
            throw new AnimalNameException();
        }

        else{
            list.add(animal);
            hashMap.put(animal.getName(),animal);
            color.add(animal.getColor());
            return;
        }
    }



    private Animal findAnimal(String animalName){//作为Shelter内部使用的方法
            /*return list.stream()
                   .filter(s-> s.getName().equals(animalName))
                   .findFirst()
                   .orElse(null);*/
        return hashMap.get(animalName);
    }

    private boolean judge(String color){
        for(Animal a:list){
            if(a.getColor().equals(color))
                return true;
        }
        return false;
    }

    public void removeAnimal(String animalName) {
        Animal temp=findAnimal(animalName);

        if(listIsEmpty()){
            throw new ShelterEmptyException();
        }
        else if(temp!=null){
            list.remove(temp);
            hashMap.remove(animalName);

            if(!judge(temp.getColor())){
                color.remove(temp.getColor());
            }
        }
        else
            throw new AnimalNotFoundException();

    }

    public void showColor(){//展示颜色
        if(color.isEmpty()){
            throw new ShelterEmptyException();
        }
        else{
            System.out.println("现在有"+color.size()+"种颜色");
            System.out.println(color);
        }
    }

    public void showAnimals() {
        if(list.isEmpty()){
            throw new ShelterEmptyException();
        }
        else {
            /*1.普通for循环
            for(int i=0;i< list.size();i++){
                Animal temp=list.get(i);
                if(temp instanceof Dog)
                    System.out.println("这是一只"+temp.getAge()+"岁的叫作"+temp.getName()+"的小狗");
                else
                    System.out.println("这是一只"+temp.getAge()+"岁的叫作"+temp.getName()+"的小猫");
            }
            System.out.println("该收容所现有"+list.size()+"只动物");*/
            Iterator<Animal> it=list.iterator();
            while(it.hasNext()){
                Animal temp=it.next();
                if(temp instanceof Dog)
                    System.out.println("这是一只"+temp.getAge()+"岁的叫作"+temp.getName()+"的小狗");
                else
                    System.out.println("这是一只"+temp.getAge()+"岁的叫作"+temp.getName()+"的小猫");
            }
            System.out.println("该收容所现有"+list.size()+"只动物");
        }
    }

    //利用stream流 链式操作按年龄升序来展示动物
    public void showAnimalsInAge() {
        if(list.isEmpty()){
            throw new ShelterEmptyException();
        }

        list.stream()
                .filter(s ->s.getAge()>1)
                .sorted(Comparator.comparingInt(Animal::getAge)//(Animal a) -> a.getAge()
                        .thenComparing(a -> a instanceof Dog ?0:1))//当年龄相同时  0表示先显示，1表示后显示
                .forEach(s ->{
                    if(s instanceof Dog)
                        System.out.println("这是一只"+s.getAge()+"岁的叫作"+s.getName()+"的小狗");
                    else
                        System.out.println("这是一只"+s.getAge()+"岁的叫作"+s.getName()+"的小猫");
                });
        System.out.println("该收容所现有"+list.size()+"只动物");
    }

    //利用stream流展示狗
    public void showDog() {
        long dogCount=list.stream()
                .filter(animal -> animal instanceof Dog)
                .count();

        if(dogCount<1){
            throw new DogEmptyException();
        }

        list.stream()
                .filter(animal -> animal instanceof Dog)
                .forEach(animal -> System.out.println("这是一只"+animal.getAge()+"岁的叫作"+animal.getName()+"的小狗"));

        System.out.println("该收容所现有"+dogCount+"只小狗");
    }

    public void showCat(){
        long catCount=list.stream()
                .filter(animal -> animal instanceof Cat)
                .count();

        if(catCount<1){
            throw new CatEmptyException();
        }

        list.stream()
                .filter(animal -> animal instanceof Cat)
                .forEach(animal -> System.out.println("这是一只"+animal.getAge()+"岁的叫作"+animal.getName()+"的小猫"));

        System.out.println("该收容所现有"+catCount+"只小猫");
    }

    public void showAllSounds() {
        if(list.isEmpty())
            throw new ShelterEmptyException();
        for(Animal i:list){
                i.makeSounds();
        }
    }



}
