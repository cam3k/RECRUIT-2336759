package com.decerto.service;

import com.decerto.repository.RandomNumberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class NumberServiceTest {

    private NumberService underTest;
    private RandomNumberRepository mockRandomNumberRepository;

    @BeforeEach
    public void init() {
        mockRandomNumberRepository = mock(RandomNumberRepository.class);
        underTest = new NumberService(mockRandomNumberRepository);
    }

    @Test
    void getRandomIntegerFromExternalService() {

        TestRestTemplate testRestTemplate = new TestRestTemplate();
        testRestTemplate.getForObject(("https://www.random.org/integers/?num=1&min=-1000000&max=1000000&col=1&base=10&format=plain&rnd=new"), String.class);
        Assertions.assertNotNull(testRestTemplate);
    }

    @Test
    void getRandomIntegerFromDb() {
        //given
        when(mockRandomNumberRepository.findRandom()).thenReturn(50);
        //when
        int result = underTest.getRandomIntegerFromDb();
        //then
        Assertions.assertEquals(50, result);
    }

}