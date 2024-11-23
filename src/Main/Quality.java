package Main;

public class Quality {
    private int value;

    public Quality(int value) {
        if (value < 0 || value > 50) {
            throw new IllegalArgumentException("Quality must be between 0 and 50");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void increase(int amount) {
        value = Math.min(value + amount, 50);
    }

    public void decrease(int amount) {
        value = Math.max(value - amount, 0);
    }
}

