package code.java.project.version;

public class Dog extends Animal{
    public Dog() {
    }

    public Dog(String name, int age, String color) {
        super(name, age, color);
    }

    @Override
    public void makeSounds(){
        System.out.println("汪汪汪~");
    }

    @Override
    public String toString(){
        String  dog="["+"姓名："+super.getName()+","+"年龄："+Integer.toString(getAge())+","+"颜色："+getColor()+","+"种类：小狗"+"]";
        return dog;
    }
}
