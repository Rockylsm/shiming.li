package com.shimingli.origin.test;

/**
 * @author shiming.li
 * @version $ v1.0 20-3-26 $
 */
public class MyCat {

    private String name;

    public MyCat() {
    }

    public MyCat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyCat{" +
                "name='" + name + '\'' +
                '}';
    }
}
