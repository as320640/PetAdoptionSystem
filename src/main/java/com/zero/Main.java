 package com.zero;

import java.io.*;
import java.sql.*;
import java.util.*;

 public class Main {
    public static void main(String[] args) throws  SQLException {
        //mysql数据库创立链接
        String url="jdbc:mysql://127.0.0.1:3306/db";
        String username="root";
        String password="mysql";


        try(Connection conn= DriverManager.getConnection(url,username,password);Scanner sc=new Scanner(System.in)){


            int choice=0;

            Shelter s =new Shelter();
            //将Shelter对象从数据库中提取出来

            int tint= 0;
            String sqlSelect ="select * from petadoptcentel";
            try (Statement stat=conn.createStatement();ResultSet rs = stat.executeQuery(sqlSelect)){
                tint = 0;

                while(rs.next()){
                    String name = rs.getString(1);
                    int age = rs.getInt(2);
                    String color = rs.getString(3);
                    String type=rs.getString(4);
                    if("小狗".equals(type)){
                        Dog d =new Dog(name,age,color);
                        s.addAnimal(d);
                    }
                    else{
                        Cat c=new Cat(name,age,color);
                        s.addAnimal(c);
                    }
                    tint++;
                }
            }

            if(tint==0){
                System.out.println("文件为空，初始化新的收容所");
            }
            else{
                System.out.println("文件读取成功");
            }


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
                System.out.println("9.查看收容所动物的颜色");
                System.out.println("10.退出系统");


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
                        String sqlInsertDog="insert into petadoptcentel values(?,?,?,'小狗')";

                        try(PreparedStatement pstat = conn.prepareStatement(sqlInsertDog)){
                            //小狗的预编译sql语句

                            s.addAnimal(d);
                            pstat.setString(1,d.getName());
                            pstat.setInt(2,d.getAge());
                            pstat.setString(3,d.getColor());

                            pstat.execute();
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
                        String sqlInsertCat="insert into petadoptcentel values(?,?,?,'小猫')";
                        try( PreparedStatement pstat = conn.prepareStatement(sqlInsertCat);){
                            //小猫的预编译sql语句

                            s.addAnimal(c);
                            pstat.setString(1,c.getName());
                            pstat.setInt(2,c.getAge());
                            pstat.setString(3,c.getColor());

                            pstat.execute();
                            break;
                        }catch(ShelterFullException e){
                            System.out.println("该收容所已经满员了");
                            break;
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
                    }catch (ShelterEmptyException e){
                        System.out.println("该收容所已经空");
                        continue;
                    } catch (AnimalNotFoundException e) {
                        System.out.println("该收容所没有"+name+"该小动物");
                        continue;
                    }

                    String sqlDelete ="delete from petadoptcentel where name =?";
                    try(PreparedStatement pstat = conn.prepareStatement(sqlDelete);){
                        pstat.setString(1,name);
                        pstat.execute();
                        System.out.println("该收容所叫"+name+"的小动物已被领养");
                    }
                }

                else if(choice==4){
                    try{
                        s.showDog();//sql语句 : select * from 表名 where type = '小狗'
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
                        s.showAnimalsInAge();//
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

                    try {
                        s.showColor();
                    } catch (Exception e) {
                        System.out.println("该收容所现在没有动物");
                    }
                }

                else if(choice==10){
                    System.out.println("退出系统");
                    break;
                }


            }
        }
    }
}
