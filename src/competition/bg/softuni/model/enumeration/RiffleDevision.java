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
        switch (value) {
            case "Semi-auto Standard":
                return SAS;
            case "Semi-auto Open":
                return SAO;
            case "Manual Action Standard":
                return MAS;
            case "Manual Action Open":
                return MAO;

            default:
                throw new RuntimeException("Invalid riffle devision!");
        }
    }
}
