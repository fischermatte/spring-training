package org.fischermatte.training.spring.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class D {

    private A a;
    private B b;

    @Autowired (required = false)
    public D(A a) {
        this.a = a;
    }

    @Autowired (required = false)
    public D(B b, C c) {
        this.b = b;
    }
}
