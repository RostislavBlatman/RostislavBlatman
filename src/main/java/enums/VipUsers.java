package enums;

public enum VipUsers {

    ROMAN(1, "Roman"), SERGEY_IVAN(2, "Sergey Ivan");

    public int number;
    public String name;

    VipUsers(int number, String name) {
        this.number = number;
        this.name = name;
    }

}
