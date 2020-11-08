package homework1_2;

import java.util.ArrayList;
import java.util.List;

public class A extends Parent{

    private String name;
    private int num;

    public A() {
        super("Aqua-1");
        System.out.println("It's a new empty object of class " + A.class.getSimpleName());
    }

    public A(String name, int num) {
        super("'Aqua-2");
        this.name = name;
        this.num = num;
    }



    String[] str = new String[]{"dbc", "acb", "zxc", "d", "lof", "RdA"};

    /**
     * Creating the list of strings composed
     * from the 5 first elements from the initial array "str"
     */
    public List<String> firstMethod() {
        List<String> res = new ArrayList<>();
        int k = 0;
        while (k <= 4) {
            res.add(str[k++]);
        }
        return res;
    }


}
