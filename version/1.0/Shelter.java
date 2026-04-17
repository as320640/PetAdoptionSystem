package code.java.project;

public class Shelter {
    private int cnt =0;//容量

    private int i=0;//数组下标

    private Animal [] animals=new Animal[10];

    public Shelter(){}
    
    public void addAnimal(Animal animal){
        if(cnt>10){
            System.out.println("该收容所已满员");
        }
        else if (cnt<10 && animals[i]==null){
            animals[i]=animal;
            i++;
            cnt++;
        }

        else{
            System.out.println("该位置已有动物");
            i++;
        }
    }

    public void removeAnimal(String animalName){
        if(cnt<1){
            System.out.println("该收容所已经没有动物了");
        }

        else{
            boolean animalMask=false;
            int temp_i=0;
            for(Animal i:animals){
                if(i.getName().equals(animalName)){
                    animals[temp_i]=null;
                    animalMask=true;
                    System.out.println(animalName+"已经被收养了");
                    cnt-=1;
                }
                temp_i++;
            }
            if(!animalMask){
                System.out.println("该收容所没有这只叫"+animalName+"名字的小动物哦");
            }
        }
    }

    public void showAnimals(){
        if(cnt<1){
            System.out.println("该收容所现在没有动物");
        }
        else {
            for(Animal i : animals){
                if( i instanceof Dog){
                    System.out.println("这是一只叫"+i.getName()+i.getAge()+"岁的小狗");
                }

                else if(  i instanceof Cat){
                    System.out.println("这是一只叫"+i.getName()+i.getAge()+"的小猫");
                }
            }
            System.out.println("该收容所现有"+cnt+"只动物");
        }
    }

    public void showAllSounds(){
        for(Animal i:animals){
            if(i!=null){
                i.makeSounds();
            }
        }
    }

}
