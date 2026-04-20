package code.java.project.version;

import java.util.ArrayList;
import java.util.Comparator;

public class Shelter {
    private final int CNT =10;//容量

    private ArrayList <Animal> list =new ArrayList<>();

    public Shelter(){}

    public boolean listIsEmpty(){//判断list是否为空
        return list.isEmpty();
    }


    public void addAnimal(Animal animal){
        if(list.size()>=CNT){
            System.out.println("该收容所已满员");
            return;
        }

        else{
            list.add(animal);
            return;
        }
    }

    public Animal findAnimal(String animalName){
            return list.stream()
                   .filter(s-> s.getName().equals(animalName))
                   .findFirst()
                   .orElse(null);
            }


    public boolean removeAnimal(String animalName){
        Animal temp=findAnimal(animalName);
        if(temp!=null){
            list.remove(temp);
            return true;
        }
        return false;
    }

    public void showAnimals(){
        if(list.isEmpty()){
            System.out.println("该收容所现在没有动物");
        }
        else {
            for(int i=0;i< list.size();i++){
                Animal temp=list.get(i);
                if(temp instanceof Dog)
                    System.out.println("这是一只"+temp.getAge()+"岁的叫作"+temp.getName()+"的小狗");
                else
                    System.out.println("这是一只"+temp.getAge()+"岁的叫作"+temp.getName()+"的小猫");
            }
            System.out.println("该收容所现有"+list.size()+"只动物");
        }
    }

    //利用stream流 链式操作按年龄升序来展示动物
    public void showAnimalsInAge(){
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
    public void showDog(){
        long dogCount=list.stream()
                .filter(animal -> animal instanceof Dog)
                .count();

        list.stream()
                .filter(animal -> animal instanceof Dog)
                .forEach(animal -> System.out.println("这是一只"+animal.getAge()+"岁的叫作"+animal.getName()+"的小狗"));

        System.out.println("该收容所现有"+dogCount+"只小狗");
    }

    public void showCat(){
        long catCount=list.stream()
                .filter(animal -> animal instanceof Cat)
                .count();

        list.stream()
                .filter(animal -> animal instanceof Cat)
                .forEach(animal -> System.out.println("这是一只"+animal.getAge()+"岁的叫作"+animal.getName()+"的小猫"));

        System.out.println("该收容所现有"+catCount+"只小猫");
    }

    public void showAllSounds(){
        if(list.isEmpty())
            System.out.println("该收容所现在没有动物");
        for(Animal i:list){
                i.makeSounds();
        }
    }

}
