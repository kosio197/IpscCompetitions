package competition.bg.softuni.model.enumeration;

public enum PowerFactor {
    MIN("Minor"), MAJ("Major");

    private String value;

    private PowerFactor(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static PowerFactor fromValue(String value) {
        switch (value) {
            case "Minor":
                return MIN;
            case "Major":
                return MAJ;

            default:
                throw new RuntimeException("Invalid power factor!");
        }
    }
}
