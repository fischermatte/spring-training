package org.fischermatte.training.spring.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class D {

    private A a;
    private B b;

    @Autowired (required = true)
    public D(A a) {
        this.a = a;
    }

    @Autowired (required = true)
    public D(B b, C c) {
        this.b = b;
    }
}
