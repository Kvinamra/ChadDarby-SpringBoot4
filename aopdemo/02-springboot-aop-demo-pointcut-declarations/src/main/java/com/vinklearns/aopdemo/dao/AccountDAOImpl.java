package com.vinklearns.aopdemo.dao;

import com.vinklearns.aopdemo.beans.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;
    private String serviceCode;

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + " : DOING MY DB WORK: New account has been added.");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + " : doWork() has been called.");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + " : getName() has been called.");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + " : setName() has been called.");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + " : getServiceCode() has been called.");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + " : setServiceCode() has been called.");
        this.serviceCode = serviceCode;
    }
}
