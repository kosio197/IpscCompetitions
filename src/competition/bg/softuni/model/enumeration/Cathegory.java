package competition.bg.softuni.model.enumeration;

public enum Cathegory {
    REGULAR("Regular"), JUNIOR("Junior (till 21 years)"), LADY("Lady"), SENIOR("Senior (over 50 years)"), SSENIOR("Super Senior (over 60 years)");

    private String value;

    private Cathegory(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Cathegory fromValue(String value) {
        switch (value) {
            case "Regular":
                return REGULAR;
            case "Junior (till 21 years)":
                return JUNIOR;
            case "Lady":
                return LADY;
            case "Senior (over 50 years)":
                return SENIOR;
            case "Super Senior (over 60 years)":
                return SSENIOR;

            default:
                throw new RuntimeException("Invalid cathegory!");
        }
    }
}
