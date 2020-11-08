package additional;

import java.util.Date;

public interface Printer {

    void printId();

    default void printCurrentDate(){
        System.out.println("Current date: " + new Date());
    }

    default String getSecretField(String secretField){
        int count = secretField.trim().toCharArray().length;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append("*");
        }
        return builder.toString();
    }

}
