package com.fc.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface AccountDao {
    void decrease(Integer from, Integer money);

    void increase(Integer to, Integer money);
}
