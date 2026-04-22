package code.java.project.version;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice=0;
        Scanner sc=new Scanner(System.in);
        Shelter s=new Shelter();

        while(true){
            System.out.println("\n **** 宠物收养中心 ****");
            System.out.println("1. 添加动物--小狗");
            System.out.println("2. 添加动物--小猫");
            System.out.println("3. 领养动物");
            System.out.println("4. 查看所有的小狗");
            System.out.println("5. 查看所有的小猫");
            System.out.println("6. 查看所有动物");
            System.out.println("7. 按年龄升序查看所有成年动物");
            System.out.println("8. 让所有动物叫一声");
            System.out.println("9. 退出系统");

            while(true){
                try{
                    System.out.println("请输入数字：");
                    choice =sc.nextInt();
                    sc.nextLine();
                    break;
                }catch(InputMismatchException e){
                    System.out.println("输入错误，请重新输入");
                    sc.nextLine();
                }
            }

            if(choice==1){
                int age=0;
                String name=null;
                Dog d=new Dog();


                System.out.println("请输入小狗名字:");
                 name=sc.nextLine();
                d.setName(name);


                while(true){
                    try{
                        System.out.println("请输入小狗年龄:");
                        age =sc.nextInt();
                        sc.nextLine();
                        d.setAge(age);
                        break;
                    }catch(AnimalAgeIllegalException e){
                        System.out.println("输入年龄有误，请重新输入");
                    }catch(InputMismatchException e){
                        System.out.println("输入年龄有误，请重新输入");
                        sc.nextLine();
                    }
                }


                System.out.println("请输入小狗颜色:");
                String color=sc.nextLine();
                d.setColor(color);

                while(true){
                    try{
                        s.addAnimal(d);
                        break;
                    }catch(ShelterFullException e){
                        System.out.println("该收容所已经满员了");
                        break;
                    }catch(AnimalNameException e){
                        System.out.println("该名字重复，请取另一个名字");
                        name=sc.nextLine();
                        d.setName(name);
                    }
                }

            }
            else if(choice==2){
                int age=0;
                String name=null;
                Cat c=new Cat();


                System.out.println("请输入小猫名字:");
                name=sc.nextLine();
                c.setName(name);

                while(true){//年龄异常处理，防止系统崩溃
                    try{
                        System.out.println("请输入小猫年龄:");
                        age =sc.nextInt();
                        sc.nextLine();
                        c.setAge(age);
                        break;
                    }catch(AnimalAgeIllegalException e){
                        System.out.println("输入年龄有误，请重新输入");
                    }catch (InputMismatchException e){
                        System.out.println("输入年龄有误，请重新输入");
                        sc.nextLine();
                    }
                }


                System.out.println("请输入小猫颜色:");
                String color=sc.nextLine();
                c.setColor(color);

                while(true){
                    try{
                        s.addAnimal(c);
                        break;
                    }catch(ShelterFullException e){
                        System.out.println("该收容所已经满员了");
                    }catch(AnimalNameException e){
                        System.out.println("该名字重复，请取另一个名字");
                        name=sc.nextLine();
                        c.setName(name);
                    }
                }



            }

            else if(choice==3){

                System.out.println("请输入您想领养的动物的名字:");
                String name=sc.nextLine();
               try{
                   s.removeAnimal(name);
                   System.out.println("该收容所叫"+name+"的小动物已被领养");
               }catch (ShelterEmptyException e){
                   System.out.println("该收容所已经空");
               } catch (AnimalNotFoundException e) {
                   System.out.println("该收容所没有"+name+"该小动物");
               }


            }

            else if(choice==4){
                try{
                    s.showDog();
                }catch(DogEmptyException e){
                    System.out.println("该收容所已经没有狗");
                }

            }

            else if(choice==5){
                try{
                    s.showCat();
                }catch(CatEmptyException e){
                    System.out.println("该收容所已经没有猫");
                }

            }

            else if(choice==6){
                try{
                    s.showAnimals();
                }catch(ShelterEmptyException e){
                    System.out.println("该收容所已经没有动物");
                }
            }

            else if(choice==7){
                try{
                    s.showAnimalsInAge();
                }catch(ShelterEmptyException e){
                    System.out.println("该收容所已经没有动物");
                }
            }

            else if(choice==8){
                try{
                    s.showAllSounds();
                }catch(ShelterEmptyException e){
                    System.out.println("该收容所已经没有动物");
                }
            }

            else if(choice==9){
                System.out.println("退出系统");
                break;
            }
        }

        sc.close();
    }
}
