package org.example.annotation;

import org.example.annotation.extension.CreateAnimalExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
@ExtendWith(CreateAnimalExtension.class)
public @interface CreateAnimal {

    String name() default "";

    int age() default 0;

}