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
        if (value.equals("Standard Manual")) {
            return STM;
        }

        if (value.equals("Standard")) {
            return STD;
        }

        if (value.equals("Open")) {
            return OPN;
        }

        if (value.equals("Modified")) {
            return MOD;
        }

        throw new RuntimeException("Invalid shotgun devision!");
    }
}
