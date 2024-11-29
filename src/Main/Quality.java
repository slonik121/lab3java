package Main;

public class Quality {
    private int value;

    public Quality(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void increase(int amount) {
        value += amount;
    }

    public void decrease(int amount) {
        value -= amount;
    }
}

