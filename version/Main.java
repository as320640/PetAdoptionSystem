package code.java.project.version;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Shelter s=new Shelter();

        while(true){
            System.out.println("\n **** 宠物收养中心 ****");
            System.out.println("1. 添加动物--小狗");
            System.out.println("2. 添加动物--小猫");
            System.out.println("3. 领养动物");
            System.out.println("4. 查看所有动物");
            System.out.println("5. 让所有动物叫一声");
            System.out.println("6. 退出系统");

            int choice =sc.nextInt();

            sc.nextLine();
            if(choice==1){
                System.out.println("请输入小狗名字:");
                String name=sc.nextLine();
                System.out.println("请输入小狗年龄:");
                int age=sc.nextInt();
                sc.nextLine();
                System.out.println("请输入小狗颜色:");
                String color=sc.nextLine();
                Dog d=new Dog(name,age,color);
                s.addAnimal(d);
            }
            else if(choice==2){
                System.out.println("请输入小猫名字");
                String name= sc.nextLine();
                System.out.println("请输入小猫年龄");
                int age=sc.nextInt();
                sc.nextLine();
                System.out.println("请输入小猫颜色");
                String color=sc.nextLine();
                Cat c=new Cat(name,age,color);
                s.addAnimal(c);
            }

            else if(choice==3){
                boolean x=true;
                System.out.println("请输入您想领养的动物的名字:");
                String name=sc.nextLine();
                ArrayList<Animal> temp=s.getList();
                for(Animal i:temp){
                    if(i.getName().equals(name) && temp.size()<=10){
                        x=false;
                        s.removeAnimal(i);
                        System.out.println("叫"+i.getName()+"的小动物已被领养");
                        break;
                    }

                    else if(temp.isEmpty()){
                        System.out.println("该收容所已经没有动物了");
                    }
                }
                if(x){
                    System.out.println("该收容所没有叫"+name+"的小动物");
                }
            }

            else if(choice==4){
                s.showAnimals();
            }

            else if(choice==5){
                s.showAllSounds();
            }

            else if(choice==6){
                System.out.println("退出系统");
                break;
            }

            else{
                System.out.println("请输入正确的数字");
            }
        }


    }
}
