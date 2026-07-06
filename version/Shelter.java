package code.java.project.version;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Shelter {
    private final int CNT =10;//容量

    private ArrayList <Animal> list =new ArrayList<>();
    private HashMap<String,Animal> hashMap=new HashMap<>();


    public Shelter() throws IOException {}

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


    public void removeAnimal(String animalName) {
        Animal temp=findAnimal(animalName);

        if(listIsEmpty()){
            throw new ShelterEmptyException();
        }
        else if(temp!=null){
            list.remove(temp);
            hashMap.remove(animalName);

        }
        else
            throw new AnimalNotFoundException();

    }

    public void showAnimals() {
        if(list.isEmpty()){
            throw new ShelterEmptyException();
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

    public void printCat() throws IOException{
        long catCount=list.stream()
                .filter(s->s instanceof Cat)
                .count();

        if(catCount<1)
            throw new CatEmptyException();

        try(FileWriter frc=new FileWriter("d:\\cat_message.txt");){
            for(Animal a:list){
                if(a instanceof Cat){
                    frc.write(a.toString()+"\r\n");
                }
            }
        }
    }

    public void printDog() throws IOException{
        long dogCount=list.stream()
                .filter(s->s instanceof Dog)
                .count();
        if(dogCount<1)
            throw new DogEmptyException();

        try( FileWriter frd =new FileWriter("d:\\dog_message.txt");){
            list.stream()
                    .filter(s-> s instanceof Dog)
                    .forEach(s-> {
                        try {
                            frd.write(s.toString()+"\r\n");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        }

    }

    public void printAnimal() throws IOException {
        if(listIsEmpty()){
            throw new ShelterEmptyException();
        }

         try(FileWriter fra =new FileWriter("d:\\animal_message.txt");){
             for(Animal a: list){
                 String animal=a.toString();
                 fra.write(animal+"\r\n");
             }
         }
    }
}
