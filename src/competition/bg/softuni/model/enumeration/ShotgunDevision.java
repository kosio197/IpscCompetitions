package competition.bg.softuni.model.enumeration;

public enum ShotgunDevision {
    STM("Standard Manual"), STD("Standard"), OPN("Open"), MOD("Modified");

    private String value;

    private ShotgunDevision(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ShotgunDevision fromValue(String value) {
        switch (value) {
            case "Standard Manual":
                return STM;
            case "Standard":
                return STD;
            case "Open":
                return OPN;
            case "Modified":
                return MOD;

            default:
                throw new RuntimeException("Invalid shotgun devision!");
        }
    }
}
