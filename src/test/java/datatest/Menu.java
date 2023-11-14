package datatest;

public enum Menu {
    MAIN (""),
    FOOTBALL ("football"),
    HOCKEY ("hockey");

    private final String menu;
    Menu(String value) {
        this.menu = value;
    }
    public String getPage() {
        return menu;
    }
}