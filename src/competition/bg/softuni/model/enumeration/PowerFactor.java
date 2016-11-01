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
        if (value.equals("Minor")) {
            return MIN;
        }

        if (value.equals("Major")) {
            return MAJ;
        }

        throw new RuntimeException("Invalid power factor!");
    }
}
