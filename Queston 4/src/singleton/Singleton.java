package singleton;

public class Singleton {

    private static Singleton instance;
    private int value;

    public static Singleton getInstance() {

        if (instance == null) {
            synchronized(Singleton.class) {
                if (instance == null)
                    instance = new Singleton();
            }
        }
        return instance;
    }

    private Singleton() { }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

