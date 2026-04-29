package code.java.project.version;

public abstract class Animal implements MakeSounds{
    private String name;
    private int age;
    private String color;

    public Animal(){}

    public Animal(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age)throws AnimalAgeIllegalException {
        if(age>0 && age<40)
            this.age = age;
        else
            throw new AnimalAgeIllegalException();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString(){
        String  animal ="["+"姓名："+name+","+"年龄："+Integer.toString(age)+","+"颜色："+color+"]";
        return animal;
    }

}
