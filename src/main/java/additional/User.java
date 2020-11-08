package additional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;

public class User extends Record implements Printer {

    private final static Logger LOG = LogManager.getLogger("USER");

    private String username;
    private String password;
    private UserStatus status;
    private Date created;

    private static int countOfUsers = 0;

    public User(String username, String password) {
        super(countOfUsers);
        this.username = username;
        this.password = password;
        this.created = new Date();
        countOfUsers++;
        LOG.info(String.format("Create user: %s. created at: %s. count of users. %s", username, created, countOfUsers));
    }

    public User(UserStatus status) {
        super(countOfUsers);
        this.status = status;
        LOG.info("Create empty user");
    }


    @TestAnnotation(value = 2)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getPassword(boolean isForReporting) {
        if (isForReporting) {
            return getSecretField(this.password);
        } else {
            return password;
        }
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void printId() {
        LOG.info("id: " + this.getId());
    }
}
