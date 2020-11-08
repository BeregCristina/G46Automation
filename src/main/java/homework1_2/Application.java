package homework1_2;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        A objectA = new A();
        B objectB = new B();
        List<String> myList = objectA.firstMethod();
        objectB.secondMethod(myList);

        Parent p = new Parent("John");
        p.method();

        List<String> l = new ArrayList<>();
        l.add("First");
        l.add("Second");
        l.add("Third");
        l.add("Fourth");
        l.add("Fifth");


        objectA.charMethod(null);
        System.out.println("--------------");
        objectB.charMethod(objectA.firstMethod());
        System.out.println();
        System.out.println("--------------");
        objectB.charMethod(l);

    }
}
