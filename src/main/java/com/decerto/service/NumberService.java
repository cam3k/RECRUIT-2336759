package com.decerto.service;

import com.decerto.repository.RandomNumberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import javax.naming.ServiceUnavailableException;

@Service
@RequiredArgsConstructor
public class NumberService {

    private final RandomNumberRepository randomNumberRepository;

    public int getRandomIntegerFromExternalService() throws ServiceUnavailableException {
        RestTemplate restTemplate = new RestTemplate();
        try{
            String responseEntity = restTemplate.getForObject("https://www.random.org/integers/?num=1&min=-1000000&max=1000000&col=1&base=10&format=plain&rnd=new", String.class);
            return Integer.parseInt(responseEntity.split("\n")[0]);
        }
        catch (HttpServerErrorException.ServiceUnavailable e){
            throw new ServiceUnavailableException();
        }

    }

    public int getRandomIntegerFromDb() {
        return randomNumberRepository.findRandom();
    }

    public int addTwoRandomIntegers() throws ServiceUnavailableException {
        return getRandomIntegerFromDb() + getRandomIntegerFromExternalService();
    }
}
