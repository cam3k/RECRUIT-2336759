package com.decerto.sourcing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;

class ExternalRandomNumberClientTest {

    @Test
    void fetch() {
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        testRestTemplate.getForObject(("https://www.random.org/integers/?num=1&min=-1000000&max=1000000&col=1&base=10&format=plain&rnd=new"), String.class);
        Assertions.assertNotNull(testRestTemplate);
    }

}