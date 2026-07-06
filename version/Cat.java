package code.java.project.version;

public class Cat extends Animal{
    public Cat(){}

    public Cat(String name,int age,String color){
        super(name,age,color);
    }

    @Override
    public void makeSounds(){
        System.out.println("喵喵喵~");
    }

    @Override
    public String toString(){
        String  cat="["+"姓名："+super.getName()+","+"年龄："+Integer.toString(getAge())+","+"颜色："+getColor()+","+"种类：小猫"+"]";
        return cat;
    }
}
