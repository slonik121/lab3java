package Main;

public class Quality {
    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;
    private int value;

    public Quality(int value) {
        this.value = value;
    }

    public void increase(int amount) {
        value = Math.min(value + amount, MAX_QUALITY);
    }

    public void decrease(int amount) {
        value = Math.max(value - amount, MIN_QUALITY);
    }

    public void reset() {
        value = MIN_QUALITY;
    }

    public int getValue() {
        return value;
    }
}
