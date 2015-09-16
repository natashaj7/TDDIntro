package com.thoughtworks.tddintro.accountbalance;
import com.thoughtworks.tddintro.Account.Account;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTests {
    private Account myAccount;
    @Test
    public void shouldIncreaseMyBalanceWhenIDepositMoney(){
        myAccount = new Account(100);
        myAccount.deposit(50);
        assertThat(myAccount.getBalance(), is(150));

    }

    @Test
    public void shouldDecreaseMyBalanceWhenIWithdrawMoney(){
        myAccount = new Account(100);
        myAccount.withdraw(50);
        assertThat(myAccount.getBalance(), is(50));

    }

    @Test
    public void shouldNotDecreaseMyBalanceWhenIWithdrawMoneyAndDoNotHaveEnoughToCoverTheWithdrawal(){
        myAccount = new Account(50);
        myAccount.withdraw(100);
        assertThat(myAccount.getBalance(), is(50));
    }
}
