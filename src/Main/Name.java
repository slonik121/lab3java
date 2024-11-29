package Main;

public class Name {
    private final String value;

    public Name(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public boolean isEqualTo(String otherName) {
        return value.equals(otherName);
    }
}


