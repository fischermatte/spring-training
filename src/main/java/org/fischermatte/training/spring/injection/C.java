package org.fischermatte.training.spring.injection;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class C {
    private final A a;
    public C(A a) {
        this.a = a;
        System.out.println("C invoked");
    }
}
