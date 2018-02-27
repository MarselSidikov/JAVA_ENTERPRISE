package plain;

/**
 * 27.02.2018
 * plain.CarProxy
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class CarProxy extends Car {

    private Car inner;
    private CarBeforeAdvice carBeforeAdvice;
    private CarAfterAdvice carAfterAdvice;

    public CarProxy(Car car, CarBeforeAdvice carBeforeAdvice, CarAfterAdvice carAfterAdvice) {
        this.inner = car;
        this.carBeforeAdvice = carBeforeAdvice;
        this.carAfterAdvice = carAfterAdvice;
    }

    @Override
    public void go() {
        // АСПЕКТ = Advice + joinpoint
        carBeforeAdvice.before();
        inner.go();
        carAfterAdvice.after();
    }
}
