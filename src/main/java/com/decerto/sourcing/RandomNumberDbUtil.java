package com.decerto.sourcing;

import com.decerto.repository.RandomNumberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RandomNumberDbUtil implements FetchDataInterface<Integer> {

    private final RandomNumberRepository randomNumberRepository;

    @Override
    public Integer fetch() {
        return randomNumberRepository.findRandom();
    }
}
