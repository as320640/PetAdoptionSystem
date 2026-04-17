package code.java.project;

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
}
