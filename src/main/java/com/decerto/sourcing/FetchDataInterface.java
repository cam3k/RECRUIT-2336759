package com.decerto.sourcing;

import javax.naming.ServiceUnavailableException;

public interface FetchDataInterface<T> {

    T fetch() throws ServiceUnavailableException;
}
