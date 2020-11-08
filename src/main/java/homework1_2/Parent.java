package homework1_2;

import java.util.List;

public class Parent {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    protected String name;

    public Parent(String name) {
        this.name = name;
    }

    public void method() {
        System.out.println(this.name + ": How Do You do?");
    }

    public void charMethod(List<String> list) {

        try {
            String[] myArray = list.toArray(new String[0]);
            for (String s : myArray) {
                char[] stringToChar = s.toCharArray();
                for (char ch : stringToChar) {
                    System.out.print(ch + " ");
                }
            }
        } catch (NullPointerException e) {
            System.out.println(ANSI_YELLOW + "My ERROR! An array is not defined. Please check the correctness of the entered values!");
        } catch (Exception e){
            System.out.println("Another Error!");
        }

    }

}
