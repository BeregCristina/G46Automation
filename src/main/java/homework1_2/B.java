package homework1_2;

import java.util.*;

public class B extends Parent{

    private String name;
    private int num;

    public B() {
        super("Bob-1");
        System.out.println("It's a new empty object of class " + B.class.getSimpleName());
    }

    public B(String name, int num) {
        super("Bob-2");
        this.name = name;
        this.num = num;
    }

    /**
     * Sorting the input list
     * and printing it out into the console
     */
    public void secondMethod(List<String> list) {
        Collections.sort(list);
        for (String i : list) {
            System.out.println(i);
        }
    }
}
