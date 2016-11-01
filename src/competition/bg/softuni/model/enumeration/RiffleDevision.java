package competition.bg.softuni.model.enumeration;

public enum RiffleDevision {
    SAS("Semi-auto Standard"), SAO("Semi-auto Open"), MAS("Manual Action Standard"), MAO("Manual Action Open");

    private String value;

    private RiffleDevision(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static RiffleDevision fromValue(String value) {
        if (value.equals("Semi-auto Standard")) {
            return SAS;
        }

        if (value.equals("Semi-auto Open")) {
            return SAO;
        }

        if (value.equals("Manual Action Standard")) {
            return MAS;
        }

        if (value.equals("Manual Action Open")) {
            return MAO;
        }

        throw new RuntimeException("Invalid riffle devision!");
    }
}
