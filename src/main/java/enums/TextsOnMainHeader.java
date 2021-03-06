package enums;

public enum TextsOnMainHeader {

    MAIN_TITLE("EPAM FRAMEWORK WISHES…"),

    MAIN_TXT("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, " +
            "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. " +
            "UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT " +
            "ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN " +
            "VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR."),

    TEXT_CENTER("JDI GITHUB"),

    TEXT_CENTER_LINK("https://github.com/epam/JDI");

    public String text;

    TextsOnMainHeader(String text) {
        this.text = text;
    }
}
