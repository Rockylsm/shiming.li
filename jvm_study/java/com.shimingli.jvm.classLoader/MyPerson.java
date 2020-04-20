package com.shimingli.jvm.classLoader;

/**
 * @author shiming.li
 * @version $ v1.0 20-4-20 $
 */
public class MyPerson {
    private MyPerson person;

    public Object getPerson() {
        return person;
    }

    public void setPerson(Object person) {
        this.person = (MyPerson) person;
    }
}
