package com.decerto.sourcing;

import com.decerto.repository.RandomNumberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RandomNumberDbUtilTest {

    private RandomNumberDbUtil underTest;
    private RandomNumberRepository mockRandomNumberRepository;

    @BeforeEach
    public void init() {
        mockRandomNumberRepository = mock(RandomNumberRepository.class);
        underTest = new RandomNumberDbUtil(mockRandomNumberRepository);
    }

    @Test
    void fetch() {
        //given
        when(mockRandomNumberRepository.findRandom()).thenReturn(50);
        //when
        int result = underTest.fetch();
        //then
        Assertions.assertEquals(50, result);
    }

}