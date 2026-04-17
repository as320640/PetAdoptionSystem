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
}
