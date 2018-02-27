package aliance.advices;

import org.springframework.aop.ThrowsAdvice;

/**
 * 27.02.2018
 * ThrowsAdviceImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class ThrowsAdviceImpl implements ThrowsAdvice {
    public void afterThrowing(Exception ex) {
        System.out.println("In advice with " + ex.getMessage());
    }
}
