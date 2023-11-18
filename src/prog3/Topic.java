package src.prog3;

public enum Topic {
    COMEDY,
    ROMANCE,
    OTHER;

    public static Topic fromString(String topicString) {
        if (topicString != null) {
            switch (topicString) {
                case "COMEDY":
                    return COMEDY;
                case "ROMANCE":
                    return ROMANCE;
                case "OTHER":
                    return OTHER;
            }
        }
        throw new IllegalArgumentException("Invalid topic string: " + topicString);
    }
    public String toString() {
        return name();
    }

}
