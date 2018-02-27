package plain;

/**
 * 27.02.2018
 * plain.Main
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        CarProxy proxy = new CarProxy(car,
                () -> System.out.println("Run before"),
                () -> System.out.println("Run after"));

        Driver driver = new Driver(proxy);

        driver.drive();
    }
}
