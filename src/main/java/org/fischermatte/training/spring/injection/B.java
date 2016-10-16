package org.fischermatte.training.spring.injection;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class B {
    public B () {
        System.out.println("B invoked");
    }
}
