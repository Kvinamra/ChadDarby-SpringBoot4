package com.vinklearns.aopdemo.dao;

import com.vinklearns.aopdemo.beans.Account;

public interface AccountDAO {

    void addAccount(Account account, boolean vipFlag);
    boolean doWork();
}
