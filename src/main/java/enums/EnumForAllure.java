package enums;

public enum EnumForAllure {
    DIF_ELEM_PAGE("Home page", "Login on 'Home page' as PITER CHAILOVSKY and check 'Different elements' interface");

    public final String name;
    public final String firstStory;

    EnumForAllure(String name, String story) {
        this.name = name;
        this.firstStory = story;
    }
}
