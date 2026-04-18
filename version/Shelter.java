package code.java.project.version;

import java.util.ArrayList;

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
        for(Animal i:list){
            if(i.getName().equals(animalName)){
                return i;
            }
        }
        return null;
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



    public void showAllSounds(){
        if(list.isEmpty())
            System.out.println("该收容所现在没有动物");
        for(Animal i:list){
                i.makeSounds();
        }
    }

}
