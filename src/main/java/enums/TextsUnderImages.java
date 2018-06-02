package enums;

public enum TextsUnderImages {

    ICON_PRACTISE("To include good practices\nand ideas from successful\nEPAM project"),

    ICON_CUSTOM("To be flexible and\ncustomizable"),

    ICON_MULTI("To be multiplatform"),

    ICON_BASE("Already have good base\n(about 20 internal and\nsome external projects),\n" +
            "wish to get more…");

    public String text;

    TextsUnderImages(String text) {
        this.text = text;
    }

}
