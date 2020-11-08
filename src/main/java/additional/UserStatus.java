package additional;

public enum UserStatus {

    AVAILABLE("available"),
    UNAVAILABLE("unavailable");

    UserStatus(String name){
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}
