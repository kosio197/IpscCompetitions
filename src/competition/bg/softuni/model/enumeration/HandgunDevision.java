package competition.bg.softuni.model.enumeration;

public enum HandgunDevision {
    PRD("Production"), STD("Standard"), OPN("Open"), REV("Revolver"), CLS("Classic");

    private String value;

    private HandgunDevision(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static HandgunDevision fromValue(String value) {
        if (value.equals("Production")) {
            return PRD;
        }

        if (value.equals("Standard")) {
            return STD;
        }

        if (value.equals("Open")) {
            return OPN;
        }

        if (value.equals("Revolver")) {
            return REV;
        }

        if (value.equals("Classic")) {
            return CLS;
        }

        throw new RuntimeException("Invalid handgun devision!");
    }
}
