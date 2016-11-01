package competition.bg.softuni.model.enumeration;

public enum HandgunDevision {
    NONE("None"), PRD("Production"), STD("Standard"), OPN("Open"), REV("Revolver"), CLS("Classic");

    private String value;

    private HandgunDevision(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static HandgunDevision fromValue(String value) {
        switch (value) {
            case "None":
                return NONE;
            case "Production":
                return PRD;
            case "Standard":
                return STD;
            case "Open":
                return OPN;
            case "Revolver":
                return REV;
            case "Classic":
                return CLS;

            default:
                throw new RuntimeException("Invalid handgun devision!");
        }
    }
}
