package com.vinklearns.aopdemo;

import com.vinklearns.aopdemo.beans.Account;
import com.vinklearns.aopdemo.dao.AccountDAO;
import com.vinklearns.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		return runner -> {
			demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		Account theAccount = new Account();
		theAccount.setName("John Doe");
		theAccount.setLevel("1");

		theAccountDAO.addAccount(theAccount, true);
		theMembershipDAO.addMember();

		theAccountDAO.setName("Yagini");
		theAccountDAO.setServiceCode("Platinum");
		theAccountDAO.getName();
		theAccountDAO.getServiceCode();

		theAccountDAO.doWork();
		theMembershipDAO.goToMembership();
	}
}
