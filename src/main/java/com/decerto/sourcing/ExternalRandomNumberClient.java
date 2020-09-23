package com.decerto.sourcing;

import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import javax.naming.ServiceUnavailableException;

@Component
public class ExternalRandomNumberClient implements FetchDataInterface<Integer> {

    @Override
    public Integer fetch() throws ServiceUnavailableException {
        RestTemplate restTemplate = new RestTemplate();
        try{
            String responseEntity = restTemplate.getForObject("https://www.random.org/integers/?num=1&min=-1000000&max=1000000&col=1&base=10&format=plain&rnd=new", String.class);
            return Integer.parseInt(responseEntity.split("\n")[0]);
        }
        catch (HttpServerErrorException.ServiceUnavailable e){
            throw new ServiceUnavailableException();
        }
    }
}
