package com.vinklearns.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount() {
        System.out.println(getClass() + " : DOING MY DB WORK: New account has been added.");
    }
}
