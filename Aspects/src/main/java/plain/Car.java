package plain;

/**
 * 27.02.2018
 * plain.Car
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Car {

    /**
     * joinpoint - точка, где можно выполнить сквозную фукнциональность
     * например: метод, обращение к полю, вызов конструктора
     */
    public void go() {
        System.out.println("plain.Car is going");
    }
}
