package com.learning.springbootproject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/* When do unit tests, we want only test ONE class, even if
 * they have dependencies. If a class does depend on other
 * classes, we can use Mockito to "mock" those dependency classes without
 * worrying about their implementation interfering with our class'
 * unit tests. */
@SpringBootTest
class SpringBootProjectApplicationTests {

    /* We will test in this order:
     * 1. Service Layer
     * 2. Repository Layer
     * 3. Controller Layer.*/
    @Test
    void contextLoads() {
    }

}
