package aliance;

import aliance.advices.AfterTimeAdvice;
import aliance.advices.BeforeTimeAdvice;
import aliance.advices.MethodAdvice;
import aliance.advices.ThrowsAdviceImpl;
import org.springframework.aop.framework.ProxyFactory;

/**
 * 27.02.2018
 * Main
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        LoopClass target = new LoopClass();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvice(new AfterTimeAdvice());
        proxyFactory.addAdvice(new BeforeTimeAdvice());
        proxyFactory.addAdvice(new MethodAdvice());
        proxyFactory.addAdvice(new ThrowsAdviceImpl());
        LoopClass proxy = (LoopClass)proxyFactory.getProxy();

        proxy.someError();

    }
}