package aliance;

import lombok.SneakyThrows;

/**
 * 27.02.2018
 * LoopClass
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class LoopClass {

    @SneakyThrows
    public void longLoop() {
        int delay = (int)(Math.random() * 1000);
        System.out.println("Delay time " + delay);
        Thread.sleep(delay);
    }

    public void someError() {
        throw new IllegalArgumentException("Hello!");
    }
}
