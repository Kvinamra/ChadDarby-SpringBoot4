package com.vinklearns.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{

    @Override
    public boolean addMember() {
        System.out.println(getClass() + " : DOING MY DB WORK: New membership account has been added");
        return true;
    }

    @Override
    public void goToMembership() {
        System.out.println(getClass() + " : goToMembership() has been called.");
    }
}
