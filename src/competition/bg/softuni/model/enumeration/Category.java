package competition.bg.softuni.model.enumeration;

public enum Category {
    REGULAR("Regular"), JUNIOR("Junior (till 21 years)"), LADY("Lady"), SENIOR("Senior (over 50 years)"), SSENIOR("Super Senior (over 60 years)");

    private String value;

    private Category(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Category fromValue(String value) {
        if (value.equals("Regular")) {
            return REGULAR;
        }

        if (value.equals("Junior (till 21 years)")) {
            return JUNIOR;
        }

        if (value.equals("Lady")) {
            return LADY;
        }

        if (value.equals("Senior (over 50 years)")) {
            return SENIOR;
        }

        if (value.equals("Super Senior (over 60 years)")) {
            return SSENIOR;
        }

        throw new RuntimeException("Invalid category!");
    }
}
