package Main;

public class SellIn {
    private int value;

    public SellIn(int value) {
        this.value = value;
    }

    public void decrease() {
        value--;
    }

    public boolean isExpired() {
        return value < 0;
    }

    public int getValue() {
        return value;
    }
}

