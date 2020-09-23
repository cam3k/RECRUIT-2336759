package com.decerto.service;

import com.decerto.sourcing.ExternalRandomNumberClient;
import com.decerto.sourcing.RandomNumberDbUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.naming.ServiceUnavailableException;

@Service
@RequiredArgsConstructor
public class NumberService {

    private final ExternalRandomNumberClient externalRandomNumberClient;
    private final RandomNumberDbUtil randomNumberDbUtil;

    public Integer addition() throws ServiceUnavailableException {
        return randomNumberDbUtil.fetch() + externalRandomNumberClient.fetch();
    }
}
