package com.zero;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * Unit test for simple App.
 */
public class ShelterTest {
    //定义私有属性 s
    private Shelter s;

    @BeforeEach
    void setUp(){
         s=new Shelter();
    }

    @Test
    void addDog(){
        Dog d=new Dog("小黄",10,"黄色");
        s.addAnimal(d);
        assertFalse(s.listIsEmpty());
    }

    @Test
    void addCat(){
        Cat c=new Cat("小白",4,"白色");
        s.addAnimal(c);
        assertFalse(s.listIsEmpty());//结果为false 则测试通过
    }

    @Test
    void nameException(){
        Dog d1=new Dog("小黑",4,"黑色");
        Dog d2=new Dog("小黑",5,"白色");

        s.addAnimal(d1);
        assertThrows(AnimalNameException.class,()->s.addAnimal(d2));//如果抛出该异常，则测试通过
    }


}
