package com.thoughtworks.tddintro.Account;

/**
 * Created by natashaj7 on 15-09-16.
 */
public class Account {
    int balance;

    public Account(int startingBalance){
        balance = startingBalance;
    }

    public int getBalance(){
        return balance;
    }

    public int deposit (int amount){
        return balance+=amount;
    }

    public int withdraw(int amount){
        if (amount>balance){
            return-1;
        }
        else {
            return balance -= amount;
        }
    }
}
