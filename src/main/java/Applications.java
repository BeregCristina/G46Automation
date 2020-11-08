import additional.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Applications {

    static int a = 25;

    private final static Logger LOG = LogManager.getLogger("Our Main Class");




    public static void main(String[] args) {


        int[][] ints = new int[3][2];
        ints[0][0] = 1;
        ints[0][1] = 2;

        ints[1][0] = 3;
        ints[1][1] = 4;

        ints[2][0] = 5;
        ints[2][1] = 6;
        System.out.println("====BEGIN====");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println(ints[i][j]);
            }
        }

        List<List<String>> strings = new ArrayList<>();
        List<String> listOne = new ArrayList<>();
        listOne.add("String 1");
        listOne.add("String 2");
        listOne.add("String 3");
        listOne.add("String 4");

        strings.add(listOne);

        Map<String, User> userMap = new HashMap<>();

        //List<User> users = new ArrayList<>();

        User admin = new User("administrator", "1234qweqwe");
        User businessA = new User("businessA", "1235678999qweqwe");
        User customer = new User("customer", "123qweqwe");

        User availableUser = new User(UserStatus.AVAILABLE);

        userMap.put("administrator", admin);
        userMap.put("businessA", businessA);
        userMap.put("customer", customer);


        int[] ints2 = new int[1];
        try{
            LOG.info(ints2[2]);
        } catch (IndexOutOfBoundsException e){
            LOG.error(" There is NO such element!");
        }


        for (String username : userMap.keySet()) {
            User cycleUser = userMap.get(username);
            StringBuilder builder = new StringBuilder();
            builder.append("\nCurrent user data: {")
                    .append("\n")
                    .append("User id:")
                    .append(cycleUser.getId())
                    .append(" Hidden Password: ")
                    .append(cycleUser.getPassword(true))
                    .append("\n}");
            LOG.info(builder.toString());
        }

    }
}
