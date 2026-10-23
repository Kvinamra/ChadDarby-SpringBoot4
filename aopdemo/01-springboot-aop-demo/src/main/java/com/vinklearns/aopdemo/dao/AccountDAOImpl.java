package com.vinklearns.aopdemo.dao;

import com.vinklearns.aopdemo.beans.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + " : DOING MY DB WORK: New account has been added.");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + " : doWork() has been called.");
        return false;
    }
}
