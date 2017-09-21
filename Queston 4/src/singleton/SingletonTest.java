package singleton;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SingletonTest {
    @Test
    public void testSingletonEnum() {
        SingletonEnum singletonOne = SingletonEnum.INSTANCE;
        SingletonEnum singletonTwo = SingletonEnum.INSTANCE;

        singletonOne.setValue(10);
        assertEquals(singletonOne.getValue(), singletonTwo.getValue());
    }

    @Test
    public void testSingleton() {
        Singleton singletonOne = Singleton.getInstance();
        Singleton singletonTwo = Singleton.getInstance();

        singletonOne.setValue(10);
        assertEquals(singletonOne.getValue(), singletonTwo.getValue());
    }
}
