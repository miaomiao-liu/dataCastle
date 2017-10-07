package cn.edu.swpu.cins.dataCastle.async;

/**
 * Created by miaomiao on 17-10-6.
 */
public enum EventType {

    REGISTER(0);

    private int value;

    EventType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
