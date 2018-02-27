package plain;

/**
 * 27.02.2018
 * plain.Driver
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Driver {
    private Car car;

    public Driver(Car car) {
        this.car = car;
    }

    public void drive() {
        car.go();
    }
}
